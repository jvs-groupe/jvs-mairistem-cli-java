package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.exceptions.ResourceParseException;
import com.github.jasminb.jsonapi.DeserializationFeature;
import com.github.jasminb.jsonapi.SerializationFeature;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.DemandeModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PersonneModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ReleveModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.FactureExterneModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;;

/**
 * DemandeManager
 * 
 * @author jeromeklam
 */
public class DemandeManager extends BaseManager {

  /**
   * Constructor
   * 
   * @param p_client Client WS
   */
  public DemandeManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Demande
   * 
   * @return List
   */
  public List<DemandeModel> find() {
    logger.info("find.start");
    List<DemandeModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/request",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(DemandeModel.class);
      converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
      JSONAPIDocument<List<DemandeModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, DemandeModel.class);
      bookCollection = bookDocumentCollection.get();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("find.end");
    return bookCollection;
  }
  
  /**
   * Get by Id
   * 
   * @param p_id Identifiant
   * 
   * @return DemandeModel
   */
  public DemandeModel getById(Integer p_id) {
    logger.info("getById.start");
    DemandeModel myModel = null;
    Invocation.Builder invocationBuilder = this.client.getClient("partner/request/" + p_id,
        this.parameters);
    Response response = invocationBuilder.get();
    String strResponse = response.readEntity(String.class);
    byte[] rawResponse = strResponse.getBytes();
    ResourceConverter converter = new ResourceConverter(DemandeModel.class);
    converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
    JSONAPIDocument<DemandeModel> myDocument = converter.readDocument(rawResponse,
        DemandeModel.class);
    myModel = myDocument.get();
    logger.info("getById.end");
    return myModel;
  }
  
  /**
   * Envoi d'une relève
   * 
   * @param p_reading Relève
   * 
   * @return DemandeModel
   */
  public DemandeModel sendReleve(ReleveModel p_reading) {
    logger.info("sendReleve.start");
    DemandeModel request = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/request/reading",
          this.parameters);
      ResourceConverter converter = new ResourceConverter(ReleveModel.class, DemandeModel.class);
      converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
      byte [] serializedObject = converter.writeObject(p_reading);
      String serializedAsString = new String(serializedObject);
      logger.info(serializedAsString);
      Response response = invocationBuilder.post(Entity.json(serializedAsString));
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      JSONAPIDocument<DemandeModel> bookDocument = converter
          .readDocument(rawResponse, DemandeModel.class);
      request = bookDocument.get();
    } catch (ResourceParseException e) {
      logger.error(e.getErrors().toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("sendReleve.end");
    return request;
  }
  
  /**
   * Envoi d'une facture externe
   * 
   * @param p_bill Facture externe
   * 
   * @return DemandeModel
   */
  public DemandeModel sendFactureExterne(FactureExterneModel p_bill) {
    logger.info("sendFactureExterne.start");
    DemandeModel request = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/request/bill",
          this.parameters);
      ResourceConverter converter = new ResourceConverter(FactureExterneModel.class, PointDeConsommationModel.class, DemandeModel.class);
      converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
      converter.enableSerializationOption(SerializationFeature.INCLUDE_RELATIONSHIP_ATTRIBUTES);
      byte [] serializedObject = converter.writeObject(p_bill);
      String serializedAsString = new String(serializedObject);
      logger.info(serializedAsString);
      Response response = invocationBuilder.post(Entity.json(serializedAsString));
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      JSONAPIDocument<DemandeModel> bookDocument = converter
          .readDocument(rawResponse, DemandeModel.class);
      request = bookDocument.get();
    } catch (ResourceParseException e) {
      logger.error(e.getErrors().toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("sendFactureExterne.end");
    return request;
  }
  
  /**
   * Mise à jour des coordonnées d'une personne
   * 
   * @param p_personne Personne
   * 
   * @return DemandeModel
   */
  public DemandeModel updatePersonne(PersonneModel p_personne) {
    logger.info("updatePersonne.start");
    DemandeModel request = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/request/personne/" + p_personne.getId(),
          this.parameters);
      ResourceConverter converter = new ResourceConverter(PersonneModel.class, DemandeModel.class);
      converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
      byte [] serializedObject = converter.writeObject(p_personne);
      String serializedAsString = new String(serializedObject);
      logger.info(serializedAsString);
      Response response = invocationBuilder.put(Entity.json(serializedAsString));
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      JSONAPIDocument<DemandeModel> bookDocument = converter
          .readDocument(rawResponse, DemandeModel.class);
      request = bookDocument.get();
    } catch (ResourceParseException e) {
      logger.error(e.getErrors().toString());
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("updatePersonne.end");
    return request;
  }
  
  /**
   * Get filter
   * 
   * @param p_fieldName Nom du champ
   * 
   * @return String
   */
  protected String getFilter(String p_fieldName) {
    DemandeModel myCount = new DemandeModel();
    String param = "";
    try {
      param = myCount.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
