package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;;

/**
 * OrganismeFactureurManager
 * 
 * @author jeromeklam
 */
public class OrganismeFactureurManager extends BaseManager {

  /**
   * Constructor
   * 
   * @param p_client Client WS
   */
  public OrganismeFactureurManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find OrganismeFactureur
   * 
   * @return List
   */
  public List<OrganismeFactureurModel> find() {
    logger.info("find.start");
    List<OrganismeFactureurModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/ofact",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(OrganismeFactureurModel.class);
      JSONAPIDocument<List<OrganismeFactureurModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, OrganismeFactureurModel.class);
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
    OrganismeFactureurModel myCount = new OrganismeFactureurModel();
    String param = "";
    try {
      param = myCount.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
