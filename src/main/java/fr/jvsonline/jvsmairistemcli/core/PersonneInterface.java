package fr.jvsonline.jvsmairistemcli.core;

import javax.ws.rs.client.Invocation;

/**
 * Interface ClientWS
 * 
 * @author jeromeklam
 */
public interface PersonneInterface {
  
  /**
   * Retourne le nom complet
   * 
   * @return String
   */
  public String getNomComplet();
}
