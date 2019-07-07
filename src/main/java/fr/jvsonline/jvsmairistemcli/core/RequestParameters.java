package fr.jvsonline.jvsmairistemcli.core;

import java.util.ArrayList;

import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterCondition;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterOperator;

/**
 * RequestParameters
 * 
 * @author jeromeklam
 */
public class RequestParameters extends Loggable {

  /**
   * Standard page length
   */
  protected static final int              PAGE_LENGTH      = 20;

  /**
   * Start, assumes start is 1.
   */
  protected int                           offset           = 1;

  /**
   * Length
   */
  protected int                           limit            = RequestParameters.PAGE_LENGTH;

  /**
   * Parameters
   */
  protected ArrayList<RequestParameter>   map;

  /**
   * Default operator
   */
  protected RequestParameterOperator      default_operator = RequestParameterOperator.LIKE;

  /**
   * Default condition
   */
  protected RequestParameterCondition     default_condition = RequestParameterCondition.AND;
  
  /**
   * Pagination updated ?
   */
  protected boolean paginated = false;
  
  /**
   * Constructor
   */
  public RequestParameters() {
    this.map = new ArrayList<RequestParameter>();
  }

  /**
   * Set default condition AND/OR
   * 
   * @param condition AND/OR
   */
  public void setDefaultCondition(RequestParameterCondition condition) {
    this.default_condition = condition;
  }
  
  /**
   * Get condition
   * 
   * @return String
   */
  public String getCondition() {
    return this.default_condition.toString();
  }
  
  /**
   * Set offset and limit by page number
   * 
   * @param p_page Numéro de la page
   * 
   * @return RequestParameters
   */
  public boolean setPage(int p_page) {
    this.paginated = true;
    this.offset = (p_page - 1) * RequestParameters.PAGE_LENGTH;
    this.limit  = RequestParameters.PAGE_LENGTH;
    return true;
  }

  /**
   * Get offset
   * 
   * @return int
   */
  public int getOffset() {
    return this.offset;
  }

  /**
   * 
   * @param p_offset Offset
   * 
   * @return RequestParameters
   */
  public RequestParameters setOffset(int p_offset) {
    this.paginated = true;
    this.offset = p_offset;
    return this;
  }

  /**
   * Get limit
   * 
   * @return int
   */
  public int getLimit() {
    return this.limit;
  }

  /**
   * Set limit
   * 
   * @param p_limit Limite
   * 
   * @return RequestParameters
   */
  public RequestParameters setLimit(int p_limit) {
    this.paginated = true;
    this.limit = p_limit;
    return this;
  }
  
  /**
   * Add parameter
   * 
   * @param p_name Nom
   * @param p_value Valeur
   * 
   * @return boolean
   */
  public boolean addParameter(String p_name, String p_value) {
    RequestParameter param = new RequestParameter(p_name, p_value, this.default_operator);
    this.map.add(param);
    return true;
  }
  
  /**
   * Pagination changed ?
   * 
   * @return boolean
   */
  public boolean isPaginated() {
    return this.paginated;
  }
  
  /**
   * Get all parameters
   * 
   * @return ArrayList
   */
  public ArrayList<RequestParameter> getParameters()
  {
    return this.map;
  }
}
