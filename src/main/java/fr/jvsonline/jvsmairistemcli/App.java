package fr.jvsonline.jvsmairistemcli;

import fr.jvsonline.jvsmairistemcli.omega.manager.PointDeConsommationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.CompteurManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerationManager;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ContratModel;
import fr.jvsonline.jvsmairistemcli.omega.model.AdresseDesserteModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationType;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.Container;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.Settings;
import java.io.FileNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {

  /**
   * @var Logger
   */
  protected static final Logger logger = LoggerFactory.getLogger(App.class);

  /**
   * 
   * @param String[] p_args
   * @throws FileNotFoundException
   */
  public static void main(String[] p_args) {
    logger.info("----------------------------------------------------------");
    logger.info("Read settings...");
    Settings omegaSettings = Settings.getInstance("jvsmairistemcli.properties");
    logger.info("   Version  : " + omegaSettings.getVersion());
    logger.info("   Endpoint : " + omegaSettings.getWsEndpoint());
    logger.info("----------------------------------------------------------");
    JsonApiWS wsClient = new JsonApiWS(omegaSettings);
    Container omegaContainer = new Container();
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Récupération des codifications...");
    EnumerationManager enumManager = null;
    enumManager = new EnumerationManager(wsClient);
    List<EnumerationModel> myListE = enumManager.find();
    if (myListE == null) {
      logger.info("Empty result...");
    } else {
      for (EnumerationModel item : myListE) {
        logger.info("Enumération " + item.getNom());
      }
    }
    omegaContainer.setEnums(myListE);
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Liste des premiers compteurs...");
    CompteurManager cptManager = null;
    cptManager = new CompteurManager(wsClient);
    List<CompteurModel> myListC = cptManager.find();
    if (myListC == null) {
      logger.info("Empty result...");
    } else {
      for (CompteurModel item : myListC) {
        LigneEnumerationModel diametre = omegaContainer.getLigneEnumeration(
            EnumerationType.DIAMETRE_COMPTEUR,
            item.getDiametre()
        );
        logger.info("Compteur n° " + item.getNumeroSerie() + " / " + diametre);
      }
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Liste des points de consommation ayant 56 dans le numéro...");
    PointDeConsommationManager pconsoManager = null;
    pconsoManager = new PointDeConsommationManager(wsClient);
    // Add parameters to find....
    pconsoManager.flushRequestParameters();
    pconsoManager.setPage(1);
    pconsoManager.addRequestParameter("numero", "56");
    // Go
    List<PointDeConsommationModel> myList = pconsoManager.find();
    if (myList == null) {
      logger.info("Empty result...");
    } else {
      for (PointDeConsommationModel item : myList) {
        String numero = item.getNumero();
        CompteurModel monCompteur = item.getCompteur();
        String numSerie = "";
        if (monCompteur != null) {
          numSerie = monCompteur.getNumeroSerie();
        }
        logger.info("Pconso n° " + item.getNumero() + " : " + numero + " [" + numSerie + "]");
      }
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Liste des points de consommation ayant un occupant prénommé Georges...");
    pconsoManager.flushRequestParameters();
    pconsoManager.addRequestParameter("contratActif.occupant.prenom", "Georges");
    List<PointDeConsommationModel> myListN = pconsoManager.find();
    if (myListN == null) {
      logger.info("Empty result...");
    } else {
      for (PointDeConsommationModel item : myListN) {
        String numero = item.getNumero();
        CompteurModel monCompteur = item.getCompteur();
        String numSerie = "";
        if (monCompteur != null) {
          numSerie = monCompteur.getNumeroSerie();
        }
        logger.info("Pconso n° " + item.getNumero() + " : " + numero + " [" + numSerie + "]");
        ContratModel contratActif = item.getContratActif();
        if (contratActif != null) {
          logger.info("    * " + contratActif.getOccupant());
        }
        logger.info("    * " + item.toAdresse());
      }
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Point de consommation avec l'ID 99...");
    pconsoManager.flushRequestParameters();
    PointDeConsommationModel myPConso = pconsoManager.getById(99);
    if (myPConso != null) {
      CompteurModel monCompteur99 = myPConso.getCompteur();
      String numSerie99 = "";
      if (monCompteur99 != null) {
        numSerie99 = monCompteur99.getNumeroSerie();
      }
      AdresseDesserteModel monAdresse99 = myPConso.getAdresseDesserte();
      LigneEnumerationModel typeH = omegaContainer.getLigneEnumeration(
          EnumerationType.TYPE_HABITATION,
          myPConso.getTypeHabitation()
      );
      logger.info(myPConso.toAdresse().toString() + " : " + numSerie99 + " / " + typeH);
    } else {
      logger.info("Pconso id 99 non trouvé !");
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("That's All Folks...");
    logger.info("----------------------------------------------------------");
  }
}
