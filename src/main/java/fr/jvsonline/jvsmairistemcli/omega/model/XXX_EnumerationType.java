package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * EnumerationType
 * 
 * @author jeromeklam
 */
public enum XXX_EnumerationType {
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
  CIVILITE("CIV");
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
  private XXX_EnumerationType(String p_code) {
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
