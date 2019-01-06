package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;

/**
 * PointDeConsommationManager
 * 
 * @author jeromeklam
 * @package PointDeConsommation
 */
public class PointDeConsommationManager extends Loggable {

  /**
   * WS client
   * @var ClientWSInterface
   */
  ClientWSInterface client;
  
  /**
   * Constructor
   */
  public PointDeConsommationManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Point de consommation
   * 
   * @return List<PointDeConsommationModel>
   */
  public List<PointDeConsommationModel> find() {
    logger.info("find.start");
    List<PointDeConsommationModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/pconso");
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(
          PointDeConsommationModel.class
      );
      JSONAPIDocument<List<PointDeConsommationModel>> bookDocumentCollection = converter.readDocumentCollection(
          rawResponse,
          PointDeConsommationModel.class
      );
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
   * @param Integer p_id
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel getById(Integer p_id) {
    logger.info("getById.start");
    PointDeConsommationModel myModel = null;
    Invocation.Builder invocationBuilder = this.client.getClient("partner/pconso/" + p_id);
    Response response = invocationBuilder.get();
    String strResponse = response.readEntity(String.class);
    byte[] rawResponse = strResponse.getBytes();
    ResourceConverter converter = new ResourceConverter(
        PointDeConsommationModel.class
    );
    JSONAPIDocument<PointDeConsommationModel> myDocument = converter.readDocument(
        rawResponse,
        PointDeConsommationModel.class
    );
    myModel = myDocument.get();
    logger.info("getById.end");
    return myModel;
  }
}
