package fr.jvsonline.jvsmairistemcli.core;

import java.io.IOException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.Hawk;

/**
 * HawkAuthentication
 * 
 * @author jeromeklam
 */
public class HawkAuthentication extends Loggable implements ClientRequestFilter {

  /**
   * Id
   */
  private final String id;
  
  /**
   * Key
   */
  private final String key;

  /**
   * App
   */
  private final String app;

  /**
   * Constructor
   * 
   * @param p_id Identifiant
   * @param p_key Clef
   * @param p_app App
   */
  public HawkAuthentication(String p_id, String p_key, String p_app) {
    this.id = p_id;
    this.key = p_key;
    this.app = p_app;
  }

  /**
   * Filter to add Authorization header
   * 
   * @param p_requestContext Context
   */
  @Override
  public void filter(ClientRequestContext p_requestContext) throws IOException {
    logger.info("filter.start");
    MultivaluedMap<String, Object> headers = p_requestContext.getHeaders();
    Hawk hawkAuth = new Hawk(this.id, this.key, this.app);
    final String basicAuthentication = hawkAuth.getHawkHeader(p_requestContext);
    headers.add("Authorization", basicAuthentication);
    logger.info("filter.end");
  }
}
