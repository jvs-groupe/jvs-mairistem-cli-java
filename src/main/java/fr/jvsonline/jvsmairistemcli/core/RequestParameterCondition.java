package fr.jvsonline.jvsmairistemcli.core;

import java.util.Locale;

/**
 * RequestParameterCondition
 * 
 * @author jeromeklam
 */
public enum RequestParameterCondition {
  
  /**
   * Constantes
   */
  OR ("or"),
  AND ("and");
  
  /**
   * Nom de la propriété
   * @var String
   */
  private String name = "";
  
  /**
   * Constructor
   * 
   * @param p_name Name
   */
  RequestParameterCondition(String p_name) {
    this.name = p_name;
  }
  
  /**
   * override
   * 
   * @return String
   */
  public String toString() {
    return name;
  }
}
