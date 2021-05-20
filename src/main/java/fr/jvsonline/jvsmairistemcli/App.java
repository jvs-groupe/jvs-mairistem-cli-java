package fr.jvsonline.jvsmairistemcli;

import fr.jvsonline.jvsmairistemcli.omega.Container;

import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateType;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerateManager;

import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.ArticleManager;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.OrganismeFactureurManager;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.PointDeConsommationManager;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.CompteurManager;

import fr.jvsonline.jvsmairistemcli.omega.model.ContratModel;
import fr.jvsonline.jvsmairistemcli.omega.model.TourneeModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ConsommeModel;
import fr.jvsonline.jvsmairistemcli.omega.model.NatureAbonneModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ProprietaireModel;
import fr.jvsonline.jvsmairistemcli.omega.model.AdresseDesserteModel;

import fr.jvsonline.jvsmairistemcli.core.Settings;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
//import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
//import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterOperator;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterCondition;

//import java.io.FileNotFoundException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
import java.util.List;
//import java.util.Date;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.*;
import java.util.Collection;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
		Settings omegaSettings = App.readSettings("jvsmairistemcli.properties");
		JsonApiWS wsClient = new JsonApiWS(omegaSettings);

		Container omegaContainer = Container.getInstance();
        omegaContainer.init(wsClient); // Appels des web services de base pour initialiser le composant (article, enums, ofact, ...)

        //App.testArticles(wsClient);
        //App.testEnumerations(wsClient);
        //App.testCompteurs(wsClient, omegaContainer);
        //App.testOrganismesFactureur(wsClient);
        //App.testPointDeConsommation(wsClient);
        //App.testEnCours(wsClient);

		logger.info("----------------------------------------------------------");
		logger.info("That's All Folks...");
		logger.info("----------------------------------------------------------");
	}

	/**
	 * read settings...
	 * 
	 * @param p_wsClient
	 * 
	 * @return Settings
	 */
	public static Settings readSettings(String p_config) {
		logger.info("----------------------------------------------------------");
		logger.info("Read settings...");

		Settings omegaSettings = Settings.getInstance(p_config);

		logger.info("   Version  : " + omegaSettings.getVersion());
		logger.info("   Endpoint : " + omegaSettings.getWsEndpoint());
		logger.info("   Crossroad : " + omegaSettings.getWsCrossroad());
		logger.info("----------------------------------------------------------");

		return omegaSettings;
	}

	/**
	 * test articles...
	 * 
	 * @param p_wsClient
	 */
	public static void testArticles(JsonApiWS p_wsClient) {
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des 10 1er articles actifs...");

		ArticleManager artManager = new ArticleManager(p_wsClient);

//		artManager.setPage(1);
		artManager.setPageLimit(10);
		artManager.setDefaultCondition(RequestParameterCondition.AND);
		artManager.addRequestParameter("actif", "1", RequestParameterOperator.EQUAL);

		List<ArticleModel> myListArts = artManager.find();
		if (myListArts == null) {
			logger.info("Empty result...");
		} else {
			for (ArticleModel item : myListArts) {
				logger.info("    * art_id : " + item.getId() + " / " + item.getCode() + " / " + item.getLibelle() + " / " + (item.isActif() ? "actif" : "inactif"));
			}

			logger.info("----------------------------------------------------------");
			logger.info("   JsonApi en sortie du 1er article");

			ArticleModel myArticle = myListArts.get(0);
			logger.info("    * ART_ID : " + myArticle.getId());

			artManager.testJsonApi(myArticle);
		}
	}

	/**
	 * test énumérations...
	 * 
	 * @param p_wsClient
	 */
	public static void testEnumerations(JsonApiWS p_wsClient) {
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des enums...");

		String codesEnum = "";

		for (EnumerateType oneEnum : EnumerateType.values()) {
			codesEnum = codesEnum + (codesEnum != "" ? "," : "" ) + oneEnum.getCode();
		}

		logger.info("    * enums of : " + codesEnum);

		EnumerateManager enumManager = new EnumerateManager(p_wsClient);
		List<EnumerateModel> myListEnums = enumManager.find(codesEnum);
		if (myListEnums == null) {
			logger.info("Empty result...");
		} else {
			EnumerateModel lastEnum = myListEnums.get(myListEnums.size() - 1);

			/*
			for (EnumerateModel item : myListEnums) {
				logger.info("    * enum_id : " + item.getId() + " / code : " + item.getCode());
				lastEnum = item;
			}
			*/

			if (lastEnum == null) {
				logger.info("Weird, there are no last enum !");
			} else {
				logger.info("    * last enum charged : " + lastEnum.getCode() + " / libc : " + lastEnum.getLibelleCourt());
			}
		}
	}

	/**
	 * test organismes factureur...
	 * 
	 * @param p_wsClient
	 */
	public static void testOrganismesFactureur(JsonApiWS p_wsClient) {
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des 10er organismes factureur...");

		OrganismeFactureurManager ofactManager = new OrganismeFactureurManager(p_wsClient);

		ofactManager.setPageLimit(10);

		List<OrganismeFactureurModel> myListOfacts = ofactManager.find();
		if (myListOfacts == null) {
			logger.info("Empty result...");
		} else {
			for (OrganismeFactureurModel item : myListOfacts) {
				logger.info("    * organisme : " + item.getId() + "/" + item.getNom());
			}
		}
	}

	/**
	 * test compteurs...
	 * 
	 * @param p_wsClient
	 */
	public static void testCompteurs(JsonApiWS p_wsClient, Container p_omegaContainer) {
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des 10 1er compteurs...");

		CompteurManager cptManager = new CompteurManager(p_wsClient);

//		cptManager.setPage(1);
		cptManager.setPageLimit(10);
		cptManager.setDefaultCondition(RequestParameterCondition.AND);
		cptManager.addRequestParameter("actif", "1", RequestParameterOperator.EQUAL); // actif = compteur_actif

		List<CompteurModel> myListCpts = cptManager.find();
		if (myListCpts == null) {
			logger.info("Empty result...");
		} else {
			for (CompteurModel item : myListCpts) {
				EnumerateModel diametre = p_omegaContainer.getLigneEnumeration(EnumerateType.DIAMETRE_COMPTEUR, item.getDiametre());
				logger.info("    * Compteur n° " + item.getNumeroSerie() + " / diam : " + item.getDiametre() + " / libl : " + diametre.getLibelle());
			}
		}
	}

	/**
	 * test point de consommation...
	 * 
	 * @param p_wsClient
	 */
	public static void testPointDeConsommation(JsonApiWS p_wsClient) {
		PointDeConsommationManager pconsoManager = new PointDeConsommationManager(p_wsClient);

		Integer id_pconso = 0;
		PointDeConsommationModel myPconso = null;
		List<PointDeConsommationModel> myListPconso = null;

		logger.info("----------------------------------------------------------");
		logger.info("   Liste des 10er points de consommation...");

		// rappel, les includes sont gérés sur 2 niveaux.
		//	- ya ceux par défaut définis par le client java
		//	- ya ceux par défaut définis par le back
		//
		//	ceux du client java surcharge ceux du back. 
		//	ceux du back sont pris en compte, seulement si le client java ne précise AUCUN include
		//
		// pour avoir la liste : pconsoManager.getInclude(PointDeConsommationManager.IncludesByGet);

		pconsoManager.setPageLimit(10);

		myListPconso = pconsoManager.find(); // include appliqué par défaut : PointDeConsommationManager.IncludesByGet
		if (myListPconso == null) {
			logger.info("Empty result...");
		} else {
			for (PointDeConsommationModel item : myListPconso) {
				logger.info("    * pconso n° : " + item.getNumero() + " id : " + item.getId() + " numloc : " + item.getClefLocalisation());

				id_pconso = item.getId();
			}
		}

		logger.info("----------------------------------------------------------");
		logger.info("   points de consommation where numero IN (4656, 3156)...");

		pconsoManager.flushRequestParameters(); // reset des paramètres, nécessaire car pconsoManager a été utilisé !
		pconsoManager.addRequestParameter("numero", "4656,3156", RequestParameterOperator.IN);

		myListPconso = pconsoManager.find();
		if (myListPconso == null) {
			logger.info("Empty result...");
		} else {
			for (PointDeConsommationModel item : myListPconso) {
				logger.info("    * pconso n° : " + item.getNumero() + " id : " + item.getId());
			}
		}

		logger.info("----------------------------------------------------------");
		logger.info("   10er pconso dont le numeroSerie LIKE %A1234% + include compteur...");

		pconsoManager.flushRequestParameters();
		pconsoManager.addRequestParameter("compteur.numero_serie", "A1234", RequestParameterOperator.LIKE); // on met le nom connu de l'utilisateur et non celui de la table !
		pconsoManager.setInclude("monInclude", new String[] { "compteur" });

		myListPconso = pconsoManager.find("monInclude");
		if (myListPconso == null) {
			logger.info("Empty result...");
		} else {
			logger.info(myListPconso.size() + " result(s)");

			for (PointDeConsommationModel item : myListPconso) {
				CompteurModel myCpt = item.getCompteur();
				String numSerie = (myCpt != null ? myCpt.getNumeroSerie() : "");

				logger.info("    * pconso n° : " + item.getNumero() + " id : " + item.getId() + " cpt : " + numSerie);
			}
		}

//		id_pconso = 1; // j'veux celui-là et pas un autre !

		logger.info("----------------------------------------------------------");
		logger.info("   pconso avec ID=" + id_pconso + " + plein d'infos...");

		pconsoManager.flushRequestParameters();

		myPconso = pconsoManager.getById(id_pconso); // include appliqué par défaut : PointDeConsommationManager.IncludesById 
		if (myPconso == null) {
			logger.info("Empty result...");
		} else {
			logger.info("    * pconso n° : " + myPconso.getNumero() + " id : " + myPconso.getId());

			CompteurModel myCpt = myPconso.getCompteur();	// le compteur fait parti des includes par défaut :)
			if (myCpt == null) {
				logger.info("    * Compteur : aucun");
			} else {
				logger.info("    * Compteur : " + myCpt.getNumeroSerie() + " -- D" + myCpt.getDiametre());
			}
			
			TourneeModel myTournee = myPconso.getTournee();	// la tournée fait aussi partie des includes par défaut \^.^/
			if (myTournee == null) {
				logger.info("    * Tournée : aucune");
			} else {
				logger.info("    * Tournée : " + myTournee.getCode() + " -- " + myTournee.getLibelle() + " -- POS" + myPconso.getNumeroOrdreReleve());
			}

			// le getById renvoie une liste de contrats qui lui aussi fait parti des includes par défaut
			
			logger.info("    * Contrats : " + myPconso.getContrats().size());

			for (ContratModel myContrat : myPconso.getContrats()) {
				NatureAbonneModel myNatabo = myContrat.getNatureAbonne();	// et contrat.natabo aussi fait parti des includes par défaut !

				logger.info("      * n° : " + myContrat.getNumero() + " -- : " + myNatabo.getLibelle() + " -- " + myContrat.getConsommes().size() + " consomme(s)");
				
				for (ConsommeModel myConsomme : myContrat.getConsommes()) {
					logger.info("        * " + myConsomme.toString());
				}
			}

			ProprietaireModel myProprioActif = myPconso.getProprietaireActif();
			if (myProprioActif == null) {
				logger.info("    * Propriétaire actif : aucun");
			} else {
				logger.info("    * Propriétaire actif : " + myProprioActif.getPersonne().getNomComplet());
			}

			logger.info("    * Propriétaires : " + myPconso.getProprietaires().size());

			AdresseDesserteModel myAdrDesserte = myPconso.getAdresseDesserte();
			if (myAdrDesserte == null) {
				logger.info("    * Adresse de desserte : aucune");
			} else {
				logger.info("    * Adresse de desserte : " + myAdrDesserte.getNomVoie() + "," + myAdrDesserte.getNomVille());
			}
		}
	}
	
	/**
	 * test en cours...
	 * 
	 * @param p_wsClient
	 */
	public static void testEnCours(JsonApiWS p_wsClient) {
		logger.info("----------------------------------------------------------");
		logger.info("   ...");
	}

}
