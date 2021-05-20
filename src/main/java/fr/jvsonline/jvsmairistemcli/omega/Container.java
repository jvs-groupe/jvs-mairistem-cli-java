package fr.jvsonline.jvsmairistemcli.omega;

import java.util.List;

import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;

import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.ArticleManager;

import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateType;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerateManager;

import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;
import fr.jvsonline.jvsmairistemcli.omega.manager.OrganismeFactureurManager;

/**
 * Container
 * 
 * @author jeromeklam
 */
public class Container extends Loggable {

	/**
	 * Enumérations
	 */
	List<EnumerateModel> enums = null;

	/**
	 * Articles
	 */
	List<ArticleModel> articles = null;

	/**
	 * Organisme factureur
	 */
	List<OrganismeFactureurModel> organisme_factureur = null;

	/**
	 * Instance
	 */
	private static Container INSTANCE = null;

	/**
	 * Get singleton
	 * 
	 * @return Container
	 */
	public static Container getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Container();
		}
		return INSTANCE;
	}

	/**
	 * Constructor
	 */
	public Container() {
	}

	/**
	 * Initialisation des listes
	 * 
	 * @param p_wsClient Client API
	 * 
	 * @return Container
	 */
	public Container init(JsonApiWS p_wsClient) {
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des énumérations...");

		EnumerateManager enumManager = new EnumerateManager(p_wsClient);

		String codesEnum = "";

   		for (EnumerateType oneEnum : EnumerateType.values()) {
    		codesEnum = codesEnum + (codesEnum != "" ? "," : "" ) + oneEnum.getCode();
    	}

		logger.info("enums of : " + codesEnum);

		List<EnumerateModel> myListEnum = enumManager.find(codesEnum);
		if (myListEnum == null) {
			logger.info("Empty result...");
		} else {
			logger.info("Enumérations :" + myListEnum.size());
		}

		this.setEnums(myListEnum);

		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des articles...");

		ArticleManager artManager = new ArticleManager(p_wsClient);

		artManager.addRequestParameter("actif", "1");
		
		List<ArticleModel> myListArts = artManager.find();
		if (myListArts == null) {
			logger.info("Empty result...");
		} else {
			logger.info("Articles :" + myListArts.size());
		}

		this.setArticles(myListArts);

		
		logger.info("----------------------------------------------------------");
		logger.info("   Récupération des organismes factureurs...");

		OrganismeFactureurManager ofactManager = new OrganismeFactureurManager(p_wsClient);

		List<OrganismeFactureurModel> myListOfacts = ofactManager.find();
		if (myListOfacts == null) {
			logger.info("Empty result...");
		} else {
			logger.info("Organismes factureur :" + myListOfacts.size());
		}

		this.setOrganismeFactureur(myListOfacts);

		logger.info("----------------------------------------------------------");
		return this;
	}

	/**
	 * Affectation des articles
	 * 
	 * @param p_articles Articles
	 * 
	 * @return Container
	 */
	private Container setArticles(List<ArticleModel> p_articles) {
		this.articles = p_articles;
		return this;
	}

	/**
	 * Retourne les articles
	 * 
	 * @return List
	 */
	public List<ArticleModel> getArticles() {
		return this.articles;
	}

	/**
	 * Affectation des énumérations
	 * 
	 * @param p_enums Enumérations
	 * 
	 * @return Container
	 */
	private Container setEnums(List<EnumerateModel> p_enums) {
		this.enums = p_enums;
		return this;
	}

	/**
	 * Retourne les énumération
	 * 
	 * @return List
	 */
	public List<EnumerateModel> getEnums() {
		return this.enums;
	}

	/**
	 * @deprecated
     * <p> Use {@link Container#setEnums(p_codifs)} instead.
	 */
	@Deprecated
	public Container setCodifs(List<EnumerateModel> p_codifs) {
		this.enums = p_codifs;
		return this;
	}

	/**
	 * @deprecated
     * <p> Use {@link Container#getEnums()} instead.
	 */
	@Deprecated
	public List<EnumerateModel> getCodifs() {
		return enums;
	}

	/**
	 * Recherche une énumération
	 * 
	 * @param p_code_enumeration Code de l'énumération dans laquelle on doit rechercher p_value
	 * @param p_value            Valeur de l'énumération à rechercher pour le code énumération p_codeEnumeration
	 * 
	 * @return EnumerateModel
	 */
	public EnumerateModel getEnumeration(EnumerateType p_code_enumeration, String p_value) {
		EnumerateModel enumModel = null;

		if (p_value != null) {
			for (EnumerateModel oneEnum : this.enums) {
				if (!oneEnum.getCodeListe().equals(p_code_enumeration.getCode())) continue;
				if (oneEnum.getCode().equals(p_value)) {
					enumModel = oneEnum;
					break;
				}
			}
		}

		return enumModel;
	}

	/**
	 * @deprecated
     * <p> Use {@link Container#getEnumeration(p_code_enumeration, p_value)} instead.
	 */
	@Deprecated
	public EnumerateModel getLigneEnumeration(EnumerateType p_code_enumeration, String p_value) {
		return this.getEnumeration(p_code_enumeration, p_value);
	}

	/**
	 * @deprecated
     * <p> Use {@link Container#getEnumeration(p_codeEnumeration, p_value)} instead.
	 */
	@Deprecated
	public EnumerateModel getLigneCodification(EnumerateType p_code_enumeration, String p_value) {
		return this.getEnumeration(p_code_enumeration, p_value);
	}

	/**
	 * Libellé de la civilité
	 * 
	 * @param p_value Valeur
	 * 
	 * @return String
	 */
	public String getLibelleCivilite(String p_value) {
		EnumerateModel oneEnum = this.getEnumeration(EnumerateType.CIVILITE, p_value);
		return (oneEnum != null ? oneEnum.getLibelle() : "");
	}

	/**
	 * Libellé de la nature juridique
	 * 
	 * @param p_value Valeur
	 * 
	 * @return String
	 */
	public String getLibelleNatureJuridique(String p_value) {
		EnumerateModel oneEnum = this.getEnumeration(EnumerateType.NATURE_JURIDIQUE, p_value);
		return (oneEnum != null ? oneEnum.getLibelle() : "");
	}

	/**
	 * Libellé de la catégorie de tiers
	 * 
	 * @param p_value Valeur
	 * 
	 * @return String
	 */
	public String getLibelleCategorieTiers(String p_value) {
		EnumerateModel oneEnum = this.getEnumeration(EnumerateType.CATEGORIE_TIERS, p_value);
		return (oneEnum != null ? oneEnum.getLibelle() : "");
	}
	
	/**
	 * Affectation des organismes factureur
	 * 
	 * @param p_ofact list organisme factureur
	 * 
	 * @return Container
	 */
	private Container setOrganismeFactureur(List<OrganismeFactureurModel> p_ofact) {
		this.organisme_factureur = p_ofact;
		return this;
	}

	/**
	 * Retourne la liste des organismes factureur
	 * 
	 * @return OrganismeFactureurModel
	 */
	public List<OrganismeFactureurModel> getOrganismeFactureur() {
		return this.organisme_factureur;
	}
}
