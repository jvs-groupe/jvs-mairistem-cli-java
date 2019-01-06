package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;

/**
 * EnumerationManager
 * 
 * @author jeromeklam
 * @package Enumeration
 */
public class EnumerationManager extends Loggable {

  /**
   * WS client
   * @var ClientWSInterface
   */
  ClientWSInterface client;
  
  /**
   * Constructor
   */
  public EnumerationManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Enumération
   * 
   * @return List<EnumerationModel>
   */
  public List<EnumerationModel> find() {
    logger.info("find.start");
    List<EnumerationModel> myCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/enum");
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(EnumerationModel.class);
      JSONAPIDocument<List<EnumerationModel>> enumDocumentCollection = converter
          .readDocumentCollection(rawResponse, EnumerationModel.class);
      myCollection = enumDocumentCollection.get();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("find.end");
    return myCollection;
  }
}
