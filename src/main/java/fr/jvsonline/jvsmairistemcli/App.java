package fr.jvsonline.jvsmairistemcli;

import fr.jvsonline.jvsmairistemcli.omega.manager.PointDeConsommationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.CompteurManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.DemandeManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.ArticleManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.DemandeManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.OrganismeFactureurManager;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ContratModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ReleveModel;
import fr.jvsonline.jvsmairistemcli.omega.model.AdresseDesserteModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationType;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.model.DemandeModel;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.FactureExterneModel;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneFactureExterneModel;
import fr.jvsonline.jvsmairistemcli.omega.Container;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.Settings;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterCondition;

/**
 * Hello world!
 *
 */
public class App {

  /**
   * Logger
   */
  protected static final Logger logger = LoggerFactory.getLogger(App.class);

  /**
   * 
   * @param p_args Arguments
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
    logger.info("   Récupération des articles...");
    ArticleManager artManager = null;
    artManager = new ArticleManager(wsClient);
    artManager.setPage(1);
    artManager.setPageLimit(100);
    artManager.addRequestParameter("actif", "1");
    List<ArticleModel> myListArts = artManager.find();
    if (myListArts == null) {
      logger.info("Empty result...");
    } else {
      for (ArticleModel item : myListArts) {
        logger.info("Article " + item.getLibelle() + " : " + item.getPrixUnitaire());
      }
    }
    omegaContainer.setArticles(myListArts);
    //omegaContainer.setEnums(myListE);
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Récupération des organismes factureurs...");
    OrganismeFactureurManager ofactManager = null;
    ofactManager = new OrganismeFactureurManager(wsClient);
    ofactManager.setPage(1);
    ofactManager.setPageLimit(100);
    List<OrganismeFactureurModel> myListOfacts = ofactManager.find();
    if (myListOfacts == null) {
      logger.info("Empty result...");
    } else {
      for (OrganismeFactureurModel item : myListOfacts) {
        logger.info("Ofact " + item.getNom());
        omegaContainer.setOrganismeFactureur(item);
        break;
      }
    }
    //omegaContainer.setEnums(myListE);
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
    
    RequestParameters cd1 = new RequestParameters();
    cd1.setDefaultCondition(RequestParameterCondition.OR);
    cd1.addParameter("contratActif.occupant.prenom", "GE");
    cd1.addParameter("contratActif.occupant.nom", "LY");
    RequestParameters cd2 = new RequestParameters();
    cd2.setDefaultCondition(RequestParameterCondition.AND);
    cd2.addParameter("adresseDesserte.voie.commune.nom", "JOLIEVILLE");
    pconsoManager.addRequestCondition(cd1);
    pconsoManager.addRequestCondition(cd2);
    pconsoManager.setDefaultCondition(RequestParameterCondition.AND);
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
        } else {
          logger.info("    * Aucun occupant.");
        }
        logger.info("    * " + item.toAdresse());
        ReleveModel dernierReleve = item.getDernierReleve();
        if (dernierReleve != null) {
          logger.info("    * " + dernierReleve.toString());
        } else {
          logger.info("    * Pas de relevé.");
        }
      }
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("   Liste des points de consommation avec compteur C43FA...");
    pconsoManager.flushRequestParameters();
    pconsoManager.addRequestParameter("compteur.numeroSerie", "C43FA");
    List<PointDeConsommationModel> myListC2 = pconsoManager.find();
    if (myListC2 == null) {
      logger.info("Empty result...");
    } else {
      for (PointDeConsommationModel item : myListC2) {
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
    logger.info("   Liste des points de consommation avec une rue oceanite...");
    pconsoManager.flushRequestParameters();
    pconsoManager.addRequestParameter("adresseDesserte.voie.nom", "Oceanite");
    List<PointDeConsommationModel> myListV = pconsoManager.find();
    if (myListV == null) {
      logger.info("Empty result...");
    } else {
      for (PointDeConsommationModel item : myListV) {
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
    logger.info("   Point de consommation avec l'ID 2775...");
    pconsoManager.flushRequestParameters();
    PointDeConsommationModel myPConso = pconsoManager.getById(2775);
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
      logger.info(myPConso.getCoordonneeSig());
      logger.info(myPConso.getLatitude().toString() + " | " + myPConso.getLongitude().toString());
      /**
       * manager des demandes
       */
      DemandeManager reqManager = new DemandeManager(wsClient);
      // Ajouter un relevé
      ReleveModel unReleve = myPConso.getNouveauReleve();
      unReleve.setNouvelIndex(unReleve.getNouvelIndex() + 10);
      DemandeModel myRequest = reqManager.sendReleve(unReleve);
      if (myRequest != null) {
        logger.info("Demande id " + myRequest.getId() + " -- " + myRequest.getStatus());
      } else {
        logger.info("Erreur");
      }
      // Ajouter une facture externe
      Date aujourdhui = new Date(System.currentTimeMillis());
      FactureExterneModel uneFacture = new FactureExterneModel();
      uneFacture.setDateFacture(aujourdhui);
      uneFacture.setPointDeConsommation(myPConso);
      uneFacture.setRedevable(myPConso.getProprietaire());
      uneFacture.setOrganismeFactureur(omegaContainer.getOrganismeFactureur());
      // Une ligne
      LigneFactureExterneModel uneLigne1 = new LigneFactureExterneModel();
      uneLigne1.setId(-1);
      uneLigne1.setCodeArticle("toto");
      uneLigne1.setQuantite(3f);
      uneFacture.addLigneFactureExterne(uneLigne1);
      // Une seconde ligne
      LigneFactureExterneModel uneLigne2 = new LigneFactureExterneModel();
      uneLigne2.setId(-2);
      uneLigne2.setCodeArticle("tutu");
      uneLigne2.setQuantite(5.6f);
      uneFacture.addLigneFactureExterne(uneLigne2);
      reqManager.sendFactureExterne(uneFacture);
      // Mise à jour des coordonnées d'une personne
      reqManager.updatePersonne(myPConso.getContratActif().getOccupant());
    } else {
      logger.info("Pconso id 34 non trouvé !");
    }
    logger.info("----------------------------------------------------------");
    
    
    
    
    logger.info("----------------------------------------------------------");
    logger.info("That's All Folks...");
    logger.info("----------------------------------------------------------");
  }
}
