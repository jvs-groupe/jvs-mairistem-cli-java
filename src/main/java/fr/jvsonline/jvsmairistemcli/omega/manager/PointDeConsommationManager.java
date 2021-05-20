package fr.jvsonline.jvsmairistemcli.omega.manager;


import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.DeserializationFeature;

import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.Settings;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;

/**
 * PointDeConsommationManager
 * 
 * @author jeromeklam
 */
public class PointDeConsommationManager extends BaseManager {

	public static final String IncludesById = "IncludesById";
	public static final String IncludesByGet = "IncludesByGet";
	
	static final String[] defaultIncludesByGet = { 
		"contrat_actif", "contrat_actif.natabo", "contrat_actif.redevable", "contrat_actif.occupant",
		"proprietaire_actif",
		"pdessadr", "pdessadr.voie", "pdessadr.voie.commune",
		"compteur", "tournee", "dernierreleve"
		};

	static final String[] defaultIncludesById = { 
		"contrats", "contrats.natabo", "contrats.redevable", "contrats.occupant", "contrats.consommes", "contrat_actif",
		"proprietaires", "proprietaire_actif",
		"pdessadr", "pdessadr.voie", "pdessadr.voie.commune",
		"compteur", "tournee", "dernierreleve"
		};

	private MultivaluedMap<String, String[]> includes = new MultivaluedHashMap<>();

	/**
	 * à moi, à moi ...
	 * <i>(le monde de nemo)</i>
	 *  
	 * @param p_key
	 * @return boolean
	 */
	private final boolean dontTouchMyIncludes(String p_key) {
		return (p_key.equals(IncludesById) || p_key.equals(IncludesByGet));
	}

	/**
	 * 
	 */
	public Object setInclude(String p_key, String[] p_value) {
		if (!this.dontTouchMyIncludes(p_key)) {
			this.removeInclude(p_key);
			this.includes.add(p_key, p_value);
		}

		return this;
	}
	
	/**
	 * Get the include applied by default
	 *  
	 * @return String[]
	 */
	public String[] getInclude(String p_key) {
		List<String[]> myEntries = this.includes.get(p_key);

		if (myEntries != null) {
			return myEntries.get(0);
		} 

		return null; //new String[] {};
	}


	/**
	 * 
	 */
	public Object removeInclude(String p_key) {
		List<String[]> myEntries = this.includes.get(p_key);

		if (myEntries != null) {
			this.includes.remove(p_key);
		}

		return this;
	}

	/**
	 * Constructor
	 * 
	 * @param p_client Client WS
	 */
	public PointDeConsommationManager(ClientWSInterface p_client) {
		super(); // permet d'initialiser parameters 
		this.client = p_client;

		this.includes.add(IncludesById, defaultIncludesById);
		this.includes.add(IncludesByGet, defaultIncludesByGet);
	}

	/**
	 * Find Point de consommation
	 * 
	 * @param p_parameters paramètres
	 * @param p_includes liste des includes demandés
	 * 
	 * @return List
	 */
	public List<PointDeConsommationModel> find(String[] p_includes) {
		logger.info("find.start");
		List<PointDeConsommationModel> myCollection = null;

		try {
			this.parameters.setIncludes(p_includes);

			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/pconso", this.parameters);

			ResourceConverter converter = new ResourceConverter(PointDeConsommationModel.class); // convertisseur en JSONApi !

			Response response = invocationBuilder.get(); // effectue un appel de type get

			String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			converter.disableDeserializationOption(DeserializationFeature.REQUIRE_RESOURCE_ID);
			converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS); // permet de gérer les included inconnus. ex: Included section contains unknown resource type: POGRC_Trucmuche

			JSONAPIDocument<List<PointDeConsommationModel>> pconsoDocumentCollection = converter.readDocumentCollection(rawResponse, PointDeConsommationModel.class);
			myCollection = pconsoDocumentCollection.get();
		} catch (Exception e) {
			logger.error(e.getMessage());
//			e.printStackTrace();
		}

		logger.info("find.end");
		return myCollection;
	}

	/**
	 * Find Point de consommation
	 * 
	 * @return List
	 */
	public List<PointDeConsommationModel> find() {
		return this.find(this.getInclude(IncludesByGet));
	}

	/**
	 * Find Point de consommation
	 *
	 * @param p_includes
	 * 
	 * @return List
	 */
	public List<PointDeConsommationModel> find(String p_key) {
		return this.find(this.getInclude(p_key));
	}

	/**
	 * @deprecated
     * <p> Use {@link PointDeConsommationModel#find()} instead.
	 */
	@Deprecated
	public List<PointDeConsommationModel> findBasic() {
		return this.findBasic(defaultIncludesByGet);
	}

	/**
	 * @deprecated
     * <p> Use {@link PointDeConsommationModel#find(p_parameters, p_includes)} instead.
	 */
	@Deprecated
	public List<PointDeConsommationModel> findBasic(String[] p_includes) {
		return this.find(p_includes);
	}

	/**
	 * Get by Id
	 * 
	 * @param p_id Identifiant
	 * @param p_includes Includes
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel getById(Integer p_id, String[] p_includes) {
		logger.info("getById.start");
		PointDeConsommationModel myPconso = null;

		try {
			this.parameters.setIncludes(p_includes);

			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/pconso/" + p_id, this.parameters);

			ResourceConverter converter = new ResourceConverter(PointDeConsommationModel.class); // convertisseur en JSONApi !

			Response response = invocationBuilder.get(); // effectue un appel de type get

			String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			converter.disableDeserializationOption(DeserializationFeature.REQUIRE_RESOURCE_ID);
			converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);

			JSONAPIDocument<PointDeConsommationModel> pconsoDocument = converter.readDocument(rawResponse, PointDeConsommationModel.class);
			myPconso = pconsoDocument.get();
		} catch (Exception e) {
			logger.error(e.getMessage());
//			e.printStackTrace();
		}

		logger.info("getById.end");
		return myPconso;
	}

	/**
	 * Get by Id
	 * 
	 * @param p_id Identifiant
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel getById(Integer p_id) {
		return this.getById(p_id, this.getInclude(IncludesById));
	}

	/**
	 * Get by Id
	 * 
	 * @param p_id Identifiant
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel getById(Integer p_id, String p_key) {
		return this.getById(p_id, this.getInclude(p_key));
	}

	/**
	 * Get filter
	 * 
	 * @param p_fieldName Nom du champ
	 * 
	 * @return String
	 */
	protected String getFilter(String p_fieldName) {
		PointDeConsommationModel pconso = new PointDeConsommationModel();
		String param = "";
		try {
			param = pconso.getWSFieldName(p_fieldName);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return param;
	}
}
