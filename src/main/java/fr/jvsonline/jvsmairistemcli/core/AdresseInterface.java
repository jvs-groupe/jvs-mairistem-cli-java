package fr.jvsonline.jvsmairistemcli.core;

import javax.ws.rs.client.Invocation;

/**
 * Interface Adresse
 * 
 * @author jeromeklam
 */
public interface AdresseInterface {
  
  /**
   * Retourne l'appartement
   * 
   * @return String
   */
  public String getAppartement();
  
  /**
   * Retourne l'étage
   * 
   * @return String
   */
  public String getEtage();
}
