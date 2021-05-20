package fr.jvsonline.jvsmairistemcli.core;

import java.util.Locale;

/**
 * RequestParameterOperator
 * 
 * @author jeromeklam
 */
public enum RequestParameterOperator {
  
  /**
   * Constantes
   */
  EQUAL ("eq"),
  LIKE ("contains"),
  IN ("in");
  
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
  RequestParameterOperator(String p_name) {
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
