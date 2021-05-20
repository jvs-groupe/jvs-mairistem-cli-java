package fr.jvsonline.jvsmairistemcli.core;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterCondition;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterOperator;

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
   * @param condition enum RequestParameterCondition (ex: RequestParameterCondition.AND)
   * 
   * @return BaseManager
   */
  public BaseManager setDefaultCondition(RequestParameterCondition condition) {
    this.parameters.setDefaultCondition(condition);
    return this;    
  }
  
  /**
   * Set default operator
   * 
   * @param operator enum RequestParameterOperator (ex: RequestParameterOperator.EQUAL)
   * 
   * @return BaseManager
   */
  public BaseManager setDefaultOperator(RequestParameterOperator operator) {
    this.parameters.setDefaultOperator(operator);
    return this;
  }
  
  /**
   * Flush parameters
   */
  public void flushRequestParameters() {
    this.parameters = new RequestParameters();
  }

  /**
   * Add request parameter
   * 
   * @param p_fieldName field name in model notation
   * @param p_value expected value
   * 
   * @return BaseManager
   */
  public BaseManager addRequestParameter(String p_fieldName, String p_value) {
    String field = this.getFilter(p_fieldName);
    this.parameters.addParameter(field, p_value);
    return this;
  }
  
  /**
   * Add request parameter
   * 
   * @param p_fieldName field name in model notation
   * @param p_value expected value
   * @param p_oper RequestParameterOperator.AND or RequestParameterOperator.OR 
   * 
   * @return BaseManager
   */
  public BaseManager addRequestParameter(String p_fieldName, String p_value, RequestParameterOperator p_oper) {
    String field = this.getFilter(p_fieldName);
    this.parameters.addParameter(field, p_value, p_oper);
    return this;
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
   * Add request condition
   * 
   * @param p_condition condition
   * 
   * @return BaseManager
   */
  public BaseManager addRequestCondition(RequestParameters p_condition) {
    for (RequestParameter param : p_condition.getParameters()) {
      String field = this.getFilter(param.getName());
      param.setName(field);
    }
    this.parameters.addRequestCondition(p_condition);
    return this;
  }
  
  /**
   * Get conditions
   * 
   * @return ArrayList
   */
  public ArrayList<RequestParameters> getRequestConditions() {
    return this.parameters.getConditions();
  }
  
  /**
   * Set page number you want to receive
   * <br/>if value is less than 1, then the value 1 will be assigned to it by default.
   * 
   * @param p_page number of page you want to receive ( 1 to ...)
   * 
   * @return BaseManager
   */
  public BaseManager setPage(int p_page) {
    this.parameters.setPage(p_page);
    return this;
  }
  
  /**
   * Set page limit
   * <br/>if value is less than 1, then the value 20 (constant PAGE_LENGTH) will be assigned to it by default.

   * @param p_limit number of rows per page should return
   * 
   * @return BaseManager
   */
  public BaseManager setPageLimit(int p_limit) {
    this.parameters.setLimit(p_limit);
    return this;
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
