package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.DeserializationFeature;

import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.Settings;

import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateModel;

/**
 * EnumerateManager
 * 
 */
public class EnumerateManager extends BaseManager {

	/**
	 * Constructor
	 * 
	 * @param p_client Client WS
	 */
	public EnumerateManager(ClientWSInterface p_client) {
		super();
		this.client = p_client;
	}

	/**
	 * Find Enumération(s)
	 * 
	 * @param p_codesList list des énumerations à retourner séparés par une virgule
	 * 
	 * @return List
	 */
	public List<EnumerateModel> find(String p_codesList) {
		logger.info("find.start");
		List<EnumerateModel> myCollection = null;

		try {
			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/enumerate", this.parameters);

			ResourceConverter converter = new ResourceConverter(EnumerateModel.class); // convertisseur en JSONApi !

			EnumerateModel modelEnumerate = new EnumerateModel();
			modelEnumerate.setCodeListe(p_codesList);

// ne fonctionne pas, car génére un format JSON, or le back attend un jsonapi ! 
//			Response response = invocationBuilder.post(Entity.entity(modelEnumerate, MediaType.APPLICATION_JSON));
// ne fonctionne pas, car Invocation.Builder ne sait pas convertir un objet en jsonapi !
//			Response response = invocationBuilder.post(Entity.entity(modelEnumerate, "application/vnd.api+json"));
//
// nous reste donc la bonne vieille manière : le string !
// 	- soit on construit une chaine de bout en bout
//	- soit on sérialise un objet en jsonapi

// le bon vieux string ! 
//			Response response = invocationBuilder.post(Entity.entity("{\"data\":{\"type\":\"POGRC_Enumerate\",\"attributes\":{\"code\":\"dcpt\"}}}", "application/vnd.api+json"));

// la sérialisation en jsonapi !

		    converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);

		    // méthode équivalente byte [] serializedObject = converter.writeObject(modelEnumerate), mais Deprecated !

		    // le try est obligatoire. il est imposé par le writeDocument ! 
//			try {
		    	byte [] serializedObject = converter.writeDocument(new JSONAPIDocument<>(modelEnumerate));
//			} catch (DocumentSerializationException e) {
//				throw new RuntimeException(e);
//			}

		    String serializedAsString = new String(serializedObject);
//		    logger.info(serializedAsString);

		    Response response = invocationBuilder.post(Entity.entity(serializedAsString, "application/vnd.api+json")); // effectue un appel de type post

//

		    String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			JSONAPIDocument<List<EnumerateModel>> enumDocumentCollection = converter.readDocumentCollection(rawResponse, EnumerateModel.class);
			myCollection = enumDocumentCollection.get();
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
		EnumerateModel myEnum = new EnumerateModel();
		String param = "";
		try {
			param = myEnum.getWSFieldName(p_fieldName);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return param;
	}
}
