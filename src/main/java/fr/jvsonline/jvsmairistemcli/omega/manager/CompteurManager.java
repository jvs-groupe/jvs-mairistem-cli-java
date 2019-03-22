package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;;

/**
 * CompteurManager
 * 
 * @author jeromeklam
 */
public class CompteurManager extends BaseManager {

  /**
   * Constructor
   * 
   * @param p_client Client WS
   */
  public CompteurManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Compteur
   * 
   * @return List
   */
  public List<CompteurModel> find() {
    logger.info("find.start");
    List<CompteurModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/compteur",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(CompteurModel.class);
      JSONAPIDocument<List<CompteurModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, CompteurModel.class);
      bookCollection = bookDocumentCollection.get();
    } catch (Exception e) {
      logger.error(e.getMessage());
    }
    logger.info("find.end");
    return bookCollection;
  }
  
  /**
   * Get filter
   * 
   * @param p_fieldName Nom du champ
   * 
   * @return String
   */
  protected String getFilter(String p_fieldName) {
    CompteurModel myCount = new CompteurModel();
    String param = "";
    try {
      param = myCount.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
