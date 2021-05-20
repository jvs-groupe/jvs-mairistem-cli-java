package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.github.jasminb.jsonapi.DeserializationFeature;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.exceptions.ResourceParseException;

import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.Settings;

import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerateModel;

/**
 * ArticleManager
 * 
 * @author jeromeklam
 */
public class ArticleManager extends BaseManager {

	/**
	 * Constructor
	 * 
	 * @param p_client Client WS
	 */
	public ArticleManager(ClientWSInterface p_client) {
		super();
		this.client = p_client;
	}

	/**
	 * Find Article
	 * 
	 * @return List
	 */
	public List<ArticleModel> find() {
		logger.info("find.start");
		List<ArticleModel> myCollection = null;

		try {
			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/article", this.parameters);

			ResourceConverter converter = new ResourceConverter(ArticleModel.class); // convertisseur en JSONApi !

			Response response = invocationBuilder.get(); // effectue un appel de type get

			String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			converter.disableDeserializationOption(DeserializationFeature.REQUIRE_RESOURCE_ID);
			converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS); // permet de gérer les included inconnus. ex: Included section contains unknown resource type: POGRC_Trucmuche

			JSONAPIDocument<List<ArticleModel>> artDocumentCollection = converter.readDocumentCollection(rawResponse, ArticleModel.class);
			myCollection = artDocumentCollection.get();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("find.end");
		return myCollection;
	}

	/**
	 * @return ArticleModel
	 */
	public ArticleModel testJsonApi(ArticleModel p_article) {
		logger.info("testJsonApi Article.start");
		ArticleModel myRequest = null;

		try {
			Settings omegaSettings = Settings.getInstance();
			Invocation.Builder invocationBuilder = this.client.getClient(omegaSettings.getWsCrossroad() + "/enumerate", this.parameters);

			ResourceConverter converter = new ResourceConverter(ArticleModel.class); // convertisseur en JSONApi !

			ArticleModel modelArticle = p_article;

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
		    	byte [] serializedObject = converter.writeDocument(new JSONAPIDocument<>(modelArticle));
//			} catch (DocumentSerializationException e) {
//				throw new RuntimeException(e);
//			}

		    	String serializedAsString = new String(serializedObject);
		    logger.info(serializedAsString);

/*
		    Response response = invocationBuilder.post(Entity.entity(serializedAsString, "application/vnd.api+json")); // effectue un appel de type post

//

		    String strResponse = response.readEntity(String.class);
			byte[] rawResponse = strResponse.getBytes();

			JSONAPIDocument<ArticleModel> bookDocument = converter.readDocument(rawResponse, ArticleModel.class);
			myRequest = bookDocument.get();
*/
		} catch (ResourceParseException e) {
			logger.error(e.getErrors().toString());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("testJsonApi Article.end");
		return myRequest;
	}

	/**
	 * Get filter
	 * 
	 * @param p_fieldName Nom du champ
	 * 
	 * @return String
	 */
	protected String getFilter(String p_field_name) {
		ArticleModel myArt = new ArticleModel();
		String param = "";
		try {
			param = myArt.getWSFieldName(p_field_name);
		} catch (Exception e) {
			this.logger.error(e.getMessage());
		}
		return param;
	}
}
