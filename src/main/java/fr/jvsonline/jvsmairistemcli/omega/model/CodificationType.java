package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * CodificationType
 * 
 * @author jeromeklam
 */
public enum CodificationType {
  /**
   * Nature juridique
   */
  NATURE_JURIDIQUE("NATJU"),
  /**
   * Catégorie de Tiers
   */
  CATEGORIE_TIERS("CTIER"),
  /**
   * Pays
   */
  PAYS("PAYSR");
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
  private CodificationType(String p_code) {
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
