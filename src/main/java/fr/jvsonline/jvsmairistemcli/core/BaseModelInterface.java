package fr.jvsonline.jvsmairistemcli.core;

/**
 * Interface BaseModel
 * 
 * @author jeromeklam
 */
public interface BaseModelInterface {
  
  /**
   * Return the real filter name
   * 
   * @param p_fieldname Nom du champ
   * 
   * @return String
   */
  public String getWSFieldName(String p_fieldname);
}
