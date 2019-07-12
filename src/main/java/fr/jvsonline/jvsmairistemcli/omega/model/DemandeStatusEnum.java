package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Locale;

/**
 * DemandeStatusEnum
 * 
 * @author jeromeklam
 */
public enum DemandeStatusEnum {
  
  /**
   * Constantes
   */
  SAVED ("SAVED"),
  SEND ("SEND"),
  OMEGA ("OMEGA"),
  CLIENT ("CLIENT"),
  CLOSED ("CLOSED"),
  ERROR ("ERROR"),
  REFUSED ("REFUSED");
  
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
  DemandeStatusEnum(String p_name) {
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
