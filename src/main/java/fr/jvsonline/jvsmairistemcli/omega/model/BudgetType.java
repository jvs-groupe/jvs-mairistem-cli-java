package fr.jvsonline.jvsmairistemcli.omega.model;

/**
 * BudgetType
 * 
 * @author jeromeklam
 */
public enum BudgetType {
  /**
   * Tous
   */
  TOUS("TOUS"),
  /**
   * Eau
   */
  EAU("EAU"),
  /**
   * Assainissement
   */
  ASSAINISSEMENT("ASST");
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
  private BudgetType(String p_code) {
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
