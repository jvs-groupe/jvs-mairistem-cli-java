package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.MessageModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import com.github.jasminb.jsonapi.ResourceConverter;
import com.github.jasminb.jsonapi.JSONAPIDocument;

/**
 * MessageManager
 * 
 * @author jeromeklam
 * @package Message
 */
public class MessageManager extends BaseManager {

  /**
   * Constructor
   */
  public MessageManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find
   * 
   * @retutn List<MessageModel>
   */
  public List<MessageModel> find() {
    logger.info("find.start");
    List<MessageModel> bookCollection = null;
    try {
      //
      Invocation.Builder invocationBuilder = this.client.getClient("partner/message",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(MessageModel.class);
      // To convert raw data into collection
      JSONAPIDocument<List<MessageModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, MessageModel.class);
      bookCollection = bookDocumentCollection.get();
    } catch (Exception ex) {
      logger.error(ex.getMessage());
    }
    logger.info("find.end");
    return bookCollection;
  }
  
  /**
   * Get filter
   * 
   * @param String p_fieldName
   * 
   * @return String
   */
  protected String getFilter(String p_fieldName) {
    MessageModel myMsg = new MessageModel();
    String param = "";
    try {
      param = myMsg.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
