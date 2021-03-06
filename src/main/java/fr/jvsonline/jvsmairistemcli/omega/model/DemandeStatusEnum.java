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
  SAVED ("Enregistrée"),
  SEND ("Envoyée"),
  OMEGA ("En traitement"),
  CLIENT ("Attente client"),
  CLOSED ("Terminée"),
  ERROR ("En erreur"),
  REFUSED ("Refusée");
  
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
  public String getLabel() {
    return name;
  }
}
