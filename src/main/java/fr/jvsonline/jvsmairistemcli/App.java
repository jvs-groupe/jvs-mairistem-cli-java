package fr.jvsonline.jvsmairistemcli;

import fr.jvsonline.jvsmairistemcli.omega.manager.PointDeConsommationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.CompteurManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerationManager;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.AdresseDesserteModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationType;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.Container;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
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
    Settings omegaSettings = Settings.getInstance();
    logger.info("   Version  : " + omegaSettings.getVersion());
    logger.info("   Endpoint : " + omegaSettings.getWsEndpoint());
    logger.info("----------------------------------------------------------");
    JsonApiWS wsClient = new JsonApiWS();
    Container omegaContainer = new Container();
    
    
    
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
    
    
    
    
    
    PointDeConsommationManager pconsoManager = null;
    pconsoManager = new PointDeConsommationManager(wsClient);
    List<PointDeConsommationModel> myList = pconsoManager.find();
    if (myList == null) {
      logger.info("Empty result...");
    } else {
      for (PointDeConsommationModel item : myList) {
        CompteurModel monCompteur = item.getCompteur();
        String numSerie = "";
        if (monCompteur != null) {
          numSerie = monCompteur.getNumeroSerie();
        }
        logger.info("Pconso n° " + item.getNumero() + " : " + numSerie);
      }
    }
    PointDeConsommationModel myPConso = pconsoManager.getById(921);
    if (myPConso != null) {
      CompteurModel monCompteur921 = myPConso.getCompteur();
      String numSerie921 = "";
      if (monCompteur921 != null) {
        numSerie921 = monCompteur921.getNumeroSerie();
      }
      AdresseDesserteModel monAdresse921 = myPConso.getAdresseDesserte();
      LigneEnumerationModel typeH = omegaContainer.getLigneEnumeration(
          EnumerationType.TYPE_HABITATION,
          myPConso.getTypeHabitation()
      );
      logger.info(myPConso.toAdresse().toString() + " : " + numSerie921 + " / " + typeH);
    } else {
      logger.info("Pconso id 921 non trouvé !");
    }
    
    
    
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("That's All Folks...");
    logger.info("----------------------------------------------------------");
  }
}
