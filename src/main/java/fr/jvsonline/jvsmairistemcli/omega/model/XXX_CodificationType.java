package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * CodificationType
 * 
 * @author jeromeklam
 */
public enum XXX_CodificationType {
  /**
   * Nature juridique
   */
  NATURE_JURIDIQUE("NATJU"),
  /**
   * Catégorie de Tiers
   */
  CATEGORIE_TIERS("CTIER");
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
  private XXX_CodificationType(String p_code) {
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
