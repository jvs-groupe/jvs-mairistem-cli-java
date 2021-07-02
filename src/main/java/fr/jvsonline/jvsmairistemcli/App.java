package fr.jvsonline.jvsmairistemcli;

import fr.jvsonline.jvsmairistemcli.omega.manager.*;
import fr.jvsonline.jvsmairistemcli.omega.model.*;
import fr.jvsonline.jvsmairistemcli.omega.Container;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterOperator;
import fr.jvsonline.jvsmairistemcli.core.Settings;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.Arrays;
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
    // String[] tests = new String[]{"ARTICLE", "OFACT", "CPT_FIRST", "CPT_NUM",
    // "PCONSO_NUM", "PCONSO_LIST", "PCONSO_GEORGES", "PCONSO_2789", "PCONSO_RUE",
    // "PCONSO_CPT", "DEMANDE_ID", "DEMANDE"};
    String[] tests = new String[] { "PCONSO_RUE" }; // ARTICLE","OFACT","PCONSO_2789","DEMANDE"};

    logger.info("----------------------------------------------------------");
    logger.info("Read settings...");
    Settings omegaSettings = Settings.getInstance("jvsmairistemcli.properties");
    logger.info("   Version  : " + omegaSettings.getVersion());
    logger.info("   Endpoint : " + omegaSettings.getWsEndpoint());
    logger.info("----------------------------------------------------------");
    JsonApiWS wsClient = new JsonApiWS(omegaSettings);
    Container omegaContainer = Container.getInstance();
    // Appels des services web de base pour initialiser le composant
    omegaContainer.init(wsClient, BudgetType.ASSAINISSEMENT);

    // Chargement des données dans le singleton
    PointDeConsommationManager pconsoManager = new PointDeConsommationManager(wsClient);
    CompteurManager cptManager = new CompteurManager(wsClient);
    DemandeManager reqManager = new DemandeManager(wsClient);

    if (Arrays.asList(tests).contains("CPT_FIRST")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des premiers compteurs...");
      List<CompteurModel> myListC = cptManager.find();
      if (myListC == null) {
        logger.info("Empty result...");
      } else {
        for (CompteurModel item : myListC) {
          LigneEnumerationModel diametre = omegaContainer.getLigneEnumeration(EnumerationType.DIAMETRE_COMPTEUR,
              item.getDiametre());
          logger.info("Compteur n° " + item.getNumeroSerie() + " / " + diametre);
        }
      }
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("PCONSO_NUM")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des points de consommation ayant 696 dans le numéro...");
      // Add parameters to find....
      pconsoManager.flushRequestParameters();
      pconsoManager.setPage(1);
      pconsoManager.addRequestParameter("numero", "696");
      // Go
      List<PointDeConsommationModel> myList = pconsoManager.findBasic();
      if (myList == null) {
        logger.info("Empty result...");
      } else {
        for (PointDeConsommationModel item : myList) {
          pconsoManager.flushRequestParameters();
          PointDeConsommationModel myLocalPConso = pconsoManager.getById(item.getId());
          String numero = myLocalPConso.getNumero();
          CompteurModel monCompteur = myLocalPConso.getCompteur();
          TourneeModel MaTournee = myLocalPConso.getTournee();
          ReleveModel dernierReleve = myLocalPConso.getDernierReleve();
          logger.info("Pconso n° " + myLocalPConso.getNumero() + " : " + numero + " [" + myLocalPConso.getId() + "]");
          if (MaTournee != null) {
            String tournee = MaTournee.getCode() + " -- " + MaTournee.getLibelle();
            logger.info("    * Tournée : " + tournee + " [" + myLocalPConso.getNumeroOrdreReleve() + "]");
          } else {
            logger.info("    * Tournée : aucune");
          }
          if (monCompteur != null) {
            String numSerie = monCompteur.getNumeroSerie();
            String diametre = monCompteur.getDiametre();
            logger.info("    * Compteur : " + numSerie + " -- D" + diametre);
          } else {
            logger.info("    * Compteur : aucun");
          }
          if (dernierReleve != null) {
            Integer ni = dernierReleve.getNouvelIndex();
            Date di = dernierReleve.getDateNouvelIndex();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String converted = formatter.format(di);
            logger.info("    * Relevé : " + ni.toString() + " le " + converted);
          } else {
            logger.info("    * Relevé : aucun");
          }
          logger.info("    * Contrats : " + myLocalPConso.getContrats().size());
          for (ContratModel myContrat : myLocalPConso.getContrats()) {
            NatureAbonneModel myNature = myContrat.getNatureAbonne();
            PersonneModel myOccupant = myContrat.getOccupant();
            String nature = "";
            if (myNature != null) {
              nature = myNature.getLibelle();
            }
            LigneEnumerationModel monEnum = omegaContainer.getLigneEnumeration(EnumerationType.CIVILITE,
                myOccupant.getCivilite());
            logger.info(
                "      * n° " + myContrat.getNumero() + " -- " + nature + " [" + myContrat.getConsommes().size() + "]");
            if (myOccupant != null && monEnum != null) {
              logger.info("          * " + monEnum.getLibelle() + " " + myOccupant.getNomComplet());
            }
            logger.info("          * dernière consommation (relevée) : " + myContrat.getDerniereConsommationRelevee());
            // logger.info(" * consommation du dernier relevé : " +
            // myLocalPConso.getDernierReleve().getConsommationRelevee());
          }
        }
      }
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("PCONSO_LIST")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des points de consommation dans une liste...");
      // Add parameters to find....
      pconsoManager.flushRequestParameters();
      pconsoManager.setPage(1);
      pconsoManager.addRequestParameter("numero", "4656,3156", RequestParameterOperator.IN);
      // Go
      List<PointDeConsommationModel> myListIN = pconsoManager.findBasic();
      if (myListIN == null) {
        logger.info("Empty result...");
      } else {
        for (PointDeConsommationModel item : myListIN) {
          String numero = item.getNumero();
          CompteurModel monCompteur3 = item.getCompteur();
          String numSerie = "";
          if (monCompteur3 != null) {
            numSerie = monCompteur3.getNumeroSerie();
          }
          logger.info("Pconso n° " + item.getNumero() + " : " + numero + " [" + numSerie + "]");
        }
      }
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("PCONSO_GEORGES")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des points de consommation ayant un propriétaire prénommé Georges...");
      pconsoManager.flushRequestParameters();
      RequestParameters cd1 = new RequestParameters();
      cd1.setDefaultCondition(RequestParameterCondition.OR);
      cd1.addParameter("proprietaire.prenom", "GEORGES");
      pconsoManager.addRequestCondition(cd1);
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
    }

    if (Arrays.asList(tests).contains("PCONSO_CPT")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des points de consommation avec compteur 123...");
      pconsoManager.flushRequestParameters();
      pconsoManager.addRequestParameter("compteur.numeroSerie", "132");
      List<PointDeConsommationModel> myListC2 = pconsoManager.findBasic();
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
    }

    if (Arrays.asList(tests).contains("PCONSO_RUE")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Liste des points de consommation avec une rue principale...");
      pconsoManager.flushRequestParameters();
      pconsoManager.addRequestParameter("adresseDesserte.voie.nom", "GE");
      List<PointDeConsommationModel> myListV = pconsoManager.findBasic();
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
            logger.info("    * Occupant : " + contratActif.getOccupant());
          }
          PersonneModel proprio = item.getProprietaire();
          ComplementPersonnePConsoModel cplProprio = item.getComplementProprietaire();
          if (proprio != null) {
            logger.info("    * Propriétaire : " + proprio.toPersonne());
            if (cplProprio != null) {
              logger.info("    *         arrivée:   " + cplProprio.getDateArrivee());
            }
            logger.info("    *                " + proprio.getComplementNom());
            logger.info("    *         adr:   " + proprio.getAdresse1());
            logger.info("    *                " + proprio.getAdresse2());
            logger.info("    *                " + proprio.getAdresse3());
            logger.info("    *                " + proprio.getCodePostal());
            logger.info("    *                " + proprio.getVille());
            logger.info("    *                " + proprio.getPays());
            logger.info("    *         nais:  " + proprio.getDateNaissance());
            logger.info("    *         tel:   " + proprio.getTelephone());
            logger.info("    *         mob:   " + proprio.getTelephoneMobile());
            logger.info("    *         email: " + proprio.getEmail());
            logger.info("    *         natuj: " + proprio.getNatureJuridique());
            logger.info("    *         ctier: " + proprio.getCategorieTiers());
            logger.info("    *         siret: " + proprio.getSiret());
          }
          AdresseDesserteModel adr = item.getAdresseDesserte();
          logger.info("    * Etage : " + item.getEtage());
          logger.info("    * Appartement : " + item.getAppartement());
          logger.info("    * N° voie : " + item.getNumeroVoie());
          logger.info("    * Cplt n° voie : " + item.getComplementNumeroVoie());
          logger.info("    * Nom voie : " + item.getNomVoie());
          logger.info("    * Code postal : " + item.getCodePostalVille());
          logger.info("    * Ville : " + item.getNomVille());
          logger.info("    * " + item.toAdresse());
        }
      }
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("PCONSO_2789")) {
      logger.info("----------------------------------------------------------");
      logger.info("   Point de consommation avec l'ID 2789...");
      /**
       * manager des demandes
       */
      pconsoManager.flushRequestParameters();
      PointDeConsommationModel myPConso = pconsoManager.getById(16424);
      if (myPConso != null) {
        CompteurModel monCompteur99 = myPConso.getCompteur();
        String numSerie99 = "";
        if (monCompteur99 != null) {
          numSerie99 = monCompteur99.getNumeroSerie();
        }
        AdresseDesserteModel monAdresse99 = myPConso.getAdresseDesserte();
        LigneEnumerationModel typeH = omegaContainer.getLigneEnumeration(EnumerationType.TYPE_HABITATION,
            myPConso.getTypeHabitation());
        logger.info(myPConso.toAdresse().toString() + " : " + numSerie99 + " / " + typeH);
        logger.info(myPConso.getCoordonneeSig());
        logger.info(myPConso.getLatitude().toString() + " | " + myPConso.getLongitude().toString());
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
        uneLigne1.setCodeArticle("A3");
        uneLigne1.setQuantite(3f);
        uneFacture.addLigneFactureExterne(uneLigne1);
        // Une seconde ligne
        LigneFactureExterneModel uneLigne2 = new LigneFactureExterneModel();
        uneLigne2.setId(-2);
        uneLigne2.setCodeArticle("340");
        uneLigne2.setQuantite(5.6f);
        uneFacture.addLigneFactureExterne(uneLigne2);
        DemandeModel maFac = reqManager.sendFactureExterne(uneFacture);
        logger.info("Demande n° " + maFac.getId());
        // Mise à jour des coordonnées d'une personne
        reqManager.updatePersonne(myPConso.getProprietaire());
      } else {
        logger.info("Pconso id 2789 non trouvé !");
      }
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("DEMANDE_ID")) {
      logger.info("----------------------------------------------------------");
      DemandeModel myDmde = reqManager.getById(1001);
      logger.info("Demande n° " + myDmde.getId() + " / " + myDmde.getCode() + " : " + myDmde.getCode().getLabel());
      logger.info("----------------------------------------------------------");
    }

    if (Arrays.asList(tests).contains("DEMANDE")) {
      logger.info("----------------------------------------------------------");
      reqManager.flushRequestParameters();
      List<DemandeModel> myListDmde = reqManager.find();
      if (myListDmde == null) {
        logger.info("Empty result...");
      } else {
        for (DemandeModel item : myListDmde) {
          Integer id = item.getId();
          logger.info("Demande n° " + id + " / " + item.getCode() + " : " + item.getCode().getLabel());
        }
      }
      logger.info("----------------------------------------------------------");
    }

    logger.info("----------------------------------------------------------");
    logger.info("That's All Folks...");
    logger.info("----------------------------------------------------------");
  }
}
