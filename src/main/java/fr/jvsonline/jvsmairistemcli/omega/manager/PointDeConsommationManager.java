package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.DeserializationFeature;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.Tools;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;

/**
 * PointDeConsommationManager
 * 
 * @author jeromeklam
 */
public class PointDeConsommationManager extends BaseManager {

  /**
   * Constructor
   * 
   * @param p_client Client WS
   */
  public PointDeConsommationManager(ClientWSInterface p_client) {
    super();
    this.client = p_client;
  }

  /**
   * Find Point de consommation
   * 
   * @return List
   */
  public List<PointDeConsommationModel> find() {
    return this.find(this.getRequestParameters());
  }

  /**
   * Find Point de consommation
   * 
   * @param p_parameters paramètres
   * 
   * @return List
   */
  public List<PointDeConsommationModel> find(RequestParameters p_parameters) {
    logger.info("find.start");
    List<PointDeConsommationModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/pconso",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(PointDeConsommationModel.class);
      converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
      JSONAPIDocument<List<PointDeConsommationModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, PointDeConsommationModel.class);
      bookCollection = bookDocumentCollection.get();
    } catch (Exception e) {
      logger.error(e.getMessage());
      e.printStackTrace();
    }
    logger.info("find.end");
    return bookCollection;
  }

  /**
   * Find Point de consommation
   * 
   * @return List
   */
  public List<PointDeConsommationModel> findBasic() {
    String[] includes = {"contratactif", "tournee", "contratactif.natabo", "contratactif.redevable", "contratactif.occupant", "proprietaire", "compteur", "pdessadr", "pdessadr.voie", "pdessadr.voie.commune", "dernierreleve", "complement_proprietaire", "contratactif.complement_occupant", "contratactif.complement_redevable"};
    return this.findBasic(includes);
  }
  
  /**
   * Find Point de consommation
   * 
   * @param p_includes Includes
   * 
   * @return List
   */
  public List<PointDeConsommationModel> findBasic(String[] p_includes) {
    logger.info("findBasic.start");
    this.parameters.setIncludes(p_includes);
    logger.info("findBasic.end");
    return this.find();
  }

  /**
   * Get by Id
   * 
   * @param p_id Identifiant
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel getById(Integer p_id) {
    String[] includes = {"contrats", "contrats.natabo", "tournee", "contrats.redevable", "contrats.occupant", "contrats.consommes", "proprietaire", "compteur", "pdessadr", "pdessadr.voie", "pdessadr.voie.commune", "dernierreleve", "complement_proprietaire", "contratactif.complement_occupant", "contratactif.complement_redevable"};
    return this.getById(p_id, includes);
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
    this.parameters.setIncludes(p_includes);
    PointDeConsommationModel myModel = null;
    Invocation.Builder invocationBuilder = this.client.getClient("partner/pconso/" + p_id,
        this.parameters);
    Response response = invocationBuilder.get();
    String strResponse = response.readEntity(String.class);
    byte[] rawResponse = strResponse.getBytes();
    ResourceConverter converter = new ResourceConverter(PointDeConsommationModel.class);
    converter.enableDeserializationOption(DeserializationFeature.ALLOW_UNKNOWN_INCLUSIONS);
    JSONAPIDocument<PointDeConsommationModel> myDocument = converter.readDocument(rawResponse,
        PointDeConsommationModel.class);
    myModel = myDocument.get();
    logger.info("getById.end");
    return myModel;
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
