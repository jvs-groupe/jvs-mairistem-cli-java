package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Locale;

/**
 * DemandeCodeEnum
 * 
 * @author jeromeklam
 */
public enum DemandeCodeEnum {
  
  /**
   * Constantes
   */
  J_FACTURE ("Facture"),
  J_MAJPER ("Mise à jour personne"),
  J_RELEVE ("Transmission de relevé");
  
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
  DemandeCodeEnum(String p_name) {
    this.name = p_name;
  }
  
  /**
   * override
   * 
   * @return String
   */
  public String getLabel() {
    return name;
  }
}
