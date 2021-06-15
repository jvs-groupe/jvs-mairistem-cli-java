package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * EnumerationType
 * 
 * @author jeromeklam
 */
public enum EnumerationType {
  /**
   * Type d'habitation
   */
  TYPE_HABITATION("THAB"),
  /**
   * Marque compteur
   */
  MARQUE_COMPTEUR("MQCPT"),
  /**
   * Diamètre compteur
   */
  DIAMETRE_COMPTEUR("DCPT"),
  /**
   * Calibre compteur
   */
  CALIBRE_COMPTEUR("CALIB"),
  /**
   * Civilité
   */
  CIVILITE("CIV"),
  /**
   * Budget
   */
  BUDGET("BUDG");
  /**
   * Code
   */
  private String code;

  /**
   * Constructor
   * 
   * @param p_code Code
   * 
   * @return void
   */
  private EnumerationType(String p_code) {
    this.code = p_code;
  }

  /**
   * As String
   * 
   * @return String
   */
  public String getCode() {
    return this.code;
  }
}
