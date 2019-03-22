package fr.jvsonline.jvsmairistemcli.core;

import javax.ws.rs.client.Invocation;

/**
 * Interface ClientWS
 * 
 * @author jeromeklam
 */
public interface ClientWSInterface {
  
  /**
   * Return an Invocation.Builder
   * 
   * @param p_service Service
   * @param p_parameters Paramètress
   * 
   * @return InputStream
   */
  public Invocation.Builder getClient(String p_service, RequestParameters p_parameters);
}
