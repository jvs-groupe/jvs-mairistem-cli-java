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
import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;

/**
 * OrganismeFactureurManager
 * 
 * @author jeromeklam
 */
public class OrganismeFactureurManager extends BaseManager {

	/**
	 * Constructor
	 * 
	 * @param p_client Client WS
	 */
	public OrganismeFactureurManager(ClientWSInterface p_client) {
		super();
		this.client = p_client;
	}

	/**
	 * Find OrganismeFactureur
	 * 
	 * @return List
	 */
	public List<OrganismeFactureurModel> find() {
		logger.info("find.start");
		List<OrganismeFactureurModel> myCollection = null;

		try {
			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/organisme_factureur", this.parameters);

			ResourceConverter converter = new ResourceConverter(OrganismeFactureurModel.class); // convertisseur en JSONApi !

			Response response = invocationBuilder.get(); // effectue un appel de type get

			String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			converter.disableDeserializationOption(DeserializationFeature.REQUIRE_RESOURCE_ID);
			converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS); // permet de gérer les included inconnus. ex: Included section contains unknown resource type: POGRC_Trucmuche

			JSONAPIDocument<List<OrganismeFactureurModel>> ofactDocumentCollection = converter.readDocumentCollection(rawResponse, OrganismeFactureurModel.class);
			myCollection = ofactDocumentCollection.get();
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
		OrganismeFactureurModel myOfact = new OrganismeFactureurModel();
		String param = "";
		try {
			param = myOfact.getWSFieldName(p_fieldName);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return param;
	}
}
