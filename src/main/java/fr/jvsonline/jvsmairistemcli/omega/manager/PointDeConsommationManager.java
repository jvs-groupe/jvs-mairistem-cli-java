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
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.core.Tools;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;

/**
 * PointDeConsommationManager
 * 
 * @author jeromeklam
 * @package PointDeConsommation
 */
public class PointDeConsommationManager extends BaseManager {

  /**
   * Constructor
   */
  public PointDeConsommationManager(ClientWSInterface p_client) {
    super();
    this.client = p_client;
  }

  /**
   * Find Point de consommation
   * 
   * @return List<PointDeConsommationModel>
   */
  public List<PointDeConsommationModel> find() {
    return this.find(this.getRequestParameters());
  }

  /**
   * Find Point de consommation
   * 
   * @param RequestParameters p_parameters
   * 
   * @return List<PointDeConsommationModel>
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
   * Get by Id
   * 
   * @param Integer p_id
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel getById(Integer p_id) {
    logger.info("getById.start");
    PointDeConsommationModel myModel = null;
    Invocation.Builder invocationBuilder = this.client.getClient("partner/pconso/" + p_id,
        this.parameters);
    Response response = invocationBuilder.get();
    String strResponse = response.readEntity(String.class);
    byte[] rawResponse = strResponse.getBytes();
    ResourceConverter converter = new ResourceConverter(PointDeConsommationModel.class);
    JSONAPIDocument<PointDeConsommationModel> myDocument = converter.readDocument(rawResponse,
        PointDeConsommationModel.class);
    myModel = myDocument.get();
    logger.info("getById.end");
    return myModel;
  }

  /**
   * Get filter
   * 
   * @param String p_fieldName
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
