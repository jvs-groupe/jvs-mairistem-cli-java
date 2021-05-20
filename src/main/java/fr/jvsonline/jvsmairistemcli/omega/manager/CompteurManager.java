package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.github.jasminb.jsonapi.DeserializationFeature;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;

import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.Settings;

import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;

/**
 * CompteurManager
 * 
 * @author jeromeklam
 */
public class CompteurManager extends BaseManager {

	/**
	 * Constructor
	 * 
	 * @param p_client Client WS
	 */
	public CompteurManager(ClientWSInterface p_client) {
		super();
		this.client = p_client;
	}

	/**
	 * Find Compteur
	 * 
	 * @return List
	 */
	public List<CompteurModel> find() {
		logger.info("find.start");
		List<CompteurModel> myCollection = null;

		try {
			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/compteur", this.parameters);

			ResourceConverter converter = new ResourceConverter(CompteurModel.class); // convertisseur en JSONApi !

			Response response = invocationBuilder.get(); // effectue un appel de type get

			String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			converter.disableDeserializationOption(DeserializationFeature.REQUIRE_RESOURCE_ID);
			converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS); // permet de gérer les included inconnus. ex: Included section contains unknown resource type: POGRC_Trucmuche

			JSONAPIDocument<List<CompteurModel>> cptDocumentCollection = converter.readDocumentCollection(rawResponse, CompteurModel.class);
			myCollection = cptDocumentCollection.get();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("find.end");
		return myCollection;
	}

	/**
	 * Get filter
	 * 
	 * @param p_fieldName Nom du champ
	 * 
	 * @return String
	 */
	protected String getFilter(String p_fieldName) {
		CompteurModel myCount = new CompteurModel();
		String param = "";
		try {
			param = myCount.getWSFieldName(p_fieldName);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return param;
	}
}
