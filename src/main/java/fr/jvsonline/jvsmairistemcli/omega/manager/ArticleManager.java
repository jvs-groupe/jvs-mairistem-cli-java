package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.BaseManager;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;;

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
    this.client = p_client;
  }

  /**
   * Find Article
   * 
   * @return List
   */
  public List<ArticleModel> find() {
    logger.info("find.start");
    List<ArticleModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/article",
          this.parameters);
      Response response = invocationBuilder.get();
      String strResponse = response.readEntity(String.class);
      byte[] rawResponse = strResponse.getBytes();
      ResourceConverter converter = new ResourceConverter(ArticleModel.class);
      JSONAPIDocument<List<ArticleModel>> bookDocumentCollection = converter
          .readDocumentCollection(rawResponse, ArticleModel.class);
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
    ArticleModel myCount = new ArticleModel();
    String param = "";
    try {
      param = myCount.getWSFieldName(p_fieldName);
    } catch (Exception e) {
      this.logger.error(e.getMessage());
    }
    return param;
  }
}
