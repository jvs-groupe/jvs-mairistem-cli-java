package fr.jvsonline.jvsmairistemcli.core;

import java.lang.reflect.Constructor;

import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;

/**
 * BaseManager
 * 
 * @author jeromeklam
 * @package WS
 */
public abstract class BaseManager extends Loggable {

  /**
   * WS client
   * 
   * @var ClientWSInterface
   */
  protected ClientWSInterface client;

  /**
   * Request parameters
   * 
   * @var RequestParameters
   */
  protected RequestParameters parameters;

  /**
   * Constructor
   */
  public BaseManager() {
    this.flushRequestParameters();
  }

  /**
   * Flush parameters
   * 
   * @return void
   */
  public void flushRequestParameters()
  {
    this.parameters = new RequestParameters();
  }
  
  /**
   * Add request parameter
   * 
   * @param String p_fieldName
   * @param String p_value
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
   * @param int p_page
   * 
   * @return boolean
   */
  public boolean setPage(int p_page) {
    return this.parameters.setPage(p_page);
  }
  
  /**
   * Get filter
   * 
   * @param String p_fieldName
   * 
   * @return String
   */
  protected abstract String getFilter(String p_fieldName);
}
