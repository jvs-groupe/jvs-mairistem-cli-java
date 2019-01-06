package fr.jvsonline.jvsmairistemcli.core;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation;
import fr.jvsonline.jvsmairistemcli.core.HawkAuthentication;
import fr.jvsonline.jvsmairistemcli.core.Settings;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.ClientWSInterface;

/**
 * JsonApiWS
 * 
 * @author jeromeklam
 * @package WS
 */
public class JsonApiWS extends Loggable implements ClientWSInterface {

  /**
   * Settings
   * 
   * @var Settings
   */
  Settings settings;
  
  /**
   * Constructor
   */
  public JsonApiWS(Settings p_settings) {
    this.settings = p_settings;
  }

  /**
   * Get media Type
   * 
   * @return String[]
   */
  static String[] getMediaType() {
    String[] mediaTypes = new String[1];
    mediaTypes[0] = "application/vnd.api+json";
    return mediaTypes;
  }

  /**
   * Return an Invocation.Builder
   * 
   * @param String p_service
   * 
   * @return InputStream
   */
  public Invocation.Builder getClient(String p_service) {
    logger.info("getJsonApiWS.start for " + p_service);
    HawkAuthentication hawkAuth = new HawkAuthentication(
      this.settings.getWsHawkId(),
      this.settings.getWsHawkKey()
    );
    Client client = ClientBuilder.newClient().register(hawkAuth);
    WebTarget target = client.target(
      this.settings.getWsEndpoint()
    ).path(p_service);
    Invocation.Builder invocationBuilder = target.request(JsonApiWS.getMediaType());
    invocationBuilder.header("ApiId", this.settings.getWsApiId());
    logger.info("getJsonApiWS.end");
    return invocationBuilder;
  }
}
