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
 * @package Auth
 */
public class HawkAuthentication extends Loggable implements ClientRequestFilter {

  /**
   * Id
   * 
   * @var String
   */
  private final String id;
  
  /**
   * Key
   * 
   * @var key
   */
  private final String key;
  
  /**
   * Constructor
   * 
   * @param String p_id
   * @param String p_key
   */
  public HawkAuthentication(String p_id, String p_key) {
    this.id = p_id;
    this.key = p_key;
  }

  /**
   * Filter to add Authorization header
   * 
   * @param ClientRequestContext p_requestContext
   * 
   * @return void
   */
  @Override
  public void filter(ClientRequestContext p_requestContext) throws IOException {
    logger.info("filter.start");
    MultivaluedMap<String, Object> headers = p_requestContext.getHeaders();
    Hawk hawkAuth = new Hawk(this.id, this.key);
    final String basicAuthentication = hawkAuth.getHawkHeader(p_requestContext);
    headers.add("Authorization", basicAuthentication);
    logger.info("filter.end");
  }
}
