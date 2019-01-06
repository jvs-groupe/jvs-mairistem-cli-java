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
   * Constructor
   */
  public HawkAuthentication() {
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
    Hawk hawkAuth = new Hawk();
    final String basicAuthentication = hawkAuth.getHawkHeader(p_requestContext);
    headers.add("Authorization", basicAuthentication);
    logger.info("filter.end");
  }
}
