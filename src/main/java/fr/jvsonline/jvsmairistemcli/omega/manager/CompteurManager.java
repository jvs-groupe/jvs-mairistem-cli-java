package fr.jvsonline.jvsmairistemcli.omega.manager;

import java.util.List;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import com.github.jasminb.jsonapi.JSONAPIDocument;
import com.github.jasminb.jsonapi.ResourceConverter;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;;

/**
 * CompteurManager
 * 
 * @author jeromeklam
 * @package PointDeConsommation
 */
public class CompteurManager extends Loggable {

  /**
   * WS client
   * 
   * @var ClientWSInterface
   */
  ClientWSInterface client;

  /**
   * Constructor
   */
  public CompteurManager(ClientWSInterface p_client) {
    this.client = p_client;
  }

  /**
   * Find Compteur
   * 
   * @return List<CompteurModel>
   */
  public List<CompteurModel> find() {
    logger.info("find.start");
    List<CompteurModel> bookCollection = null;
    try {
      Invocation.Builder invocationBuilder = this.client.getClient("partner/compteur");
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
}
