package fr.jvsonline.jvsmairistemcli.core;

import java.lang.reflect.Constructor;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterCondition;

/**
 * BaseManager
 * 
 * @author jeromeklam
 */
public abstract class BaseManager extends Loggable {

  /**
   * WS client
   */
  protected ClientWSInterface client;
  
  /**
   * Request parameters
   */
  protected RequestParameters parameters;

  /**
   * Constructor
   */
  public BaseManager() {
    this.flushRequestParameters();
  }

  /**
   * Set default condition
   * 
   * @param condition AND/OR
   */
  public void setDefaultCondition(RequestParameterCondition condition) {
    this.parameters.setDefaultCondition(condition);
  }
  
  /**
   * Flush parameters
   */
  public void flushRequestParameters()
  {
    this.parameters = new RequestParameters();
  }
  
  /**
   * Add request parameter
   * 
   * @param p_fieldName Champ en notation modèle
   * @param p_value Valeur recherchée
   * 
   * @return boolean
   */
  public boolean addRequestParameter(String p_fieldName, String p_value)
  {
    String field = this.getFilter(p_fieldName);
    return this.parameters.addParameter(field, p_value);
  }

  /**
   * Get base RequestParameters
   * 
   * @return RequestParameters
   */
  public RequestParameters getRequestParameters() {
    return this.parameters;
  }
  
  /**
   * Set page
   * 
   * @param p_page Numéro de page : 1 à
   * 
   * @return boolean
   */
  public boolean setPage(int p_page) {
    return this.parameters.setPage(p_page);
  }
  
  /**
   * Get filter
   * 
   * @param p_fieldName Nom du champ
   * 
   * @return String
   */
  protected abstract String getFilter(String p_fieldName);
}
