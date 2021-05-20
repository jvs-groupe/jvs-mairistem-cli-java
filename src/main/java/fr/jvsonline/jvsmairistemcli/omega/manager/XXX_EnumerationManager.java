package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.XXX_EnumerationModel;

/**
 * EnumerationManager
 * 
 * @author jeromeklam
 */
public class XXX_EnumerationManager extends BaseManager {

  /**
   * Constructor
   * 
   * @param p_client Client WS
   */
  public XXX_EnumerationManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Enumération
   * 
   * @return List
   */
  public List<XXX_EnumerationModel> find() {
    logger.info("find.start");
    List<XXX_EnumerationModel> myCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/enum", this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(XXX_EnumerationModel.class);
      JSONAPIDocument<List<XXX_EnumerationModel>> enumDocumentCollection = converter
          .readDocumentCollection(rawResponse, XXX_EnumerationModel.class);
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
    XXX_EnumerationModel myEnum = new XXX_EnumerationModel();
    String param = "";
    try {
      param = myEnum.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
