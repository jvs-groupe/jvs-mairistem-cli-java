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
   * Standard page length (constant)
   */
  protected static final int              PAGE_LENGTH      = 20;

  /**
   * Offset (~Start)
   * 
   * <br/> assumes default start is 1 and never negative.
   */
  protected int                           offset           = 1;

  /**
   * Limit (~page length)
   * 
   * <br/>assumes default value is 20 (constant PAGE_LENGTH) and never negative.
   */
  protected int                           limit            = RequestParameters.PAGE_LENGTH;

  /**
   * Parameters
   */
  protected ArrayList<RequestParameter>   map;

  /**
   * Conditions
   */
  protected ArrayList<RequestParameters>  conditions;
  
  /**
   * Default operator
   * 
   *  <br/>assumes default value is equal.
   */
  protected RequestParameterOperator      default_operator = RequestParameterOperator.EQUAL;

  /**
   * Default condition
   *
   * <br/>assumes default value is and.
   */
  protected RequestParameterCondition     default_condition = RequestParameterCondition.AND;
  
  /**
   * Pagination updated ?
   * 
   * <br/>true is limit,page or offset are assigned
   */
  protected boolean paginated = false;
  
  /**
   * Tableau of includes
   */
  protected String[] includes = null;
  
  /**
   * Constructor
   */
  public RequestParameters() {
    this.map        = new ArrayList<RequestParameter>();
    this.conditions = new ArrayList<RequestParameters>();
    this.includes   = new String[0];
  }

  /**
   * Set includes
   * 
   * @param p_includes Includes
   * 
   * @return RequestParameters
   */
  public RequestParameters setIncludes(String[] p_includes) {
    this.includes = p_includes;
    return this;
  }
  
  /**
   * Get includes
   * 
   * @return String[]
   */
  public String[] getIncludes() {
    return this.includes;
  }
  
  /**
   * Set default condition AND/OR
   * 
   * @param condition enum RequestParameterCondition (ex: RequestParameterCondition.AND)
   * 
   * @return RequestParameters
   */
  public RequestParameters setDefaultCondition(RequestParameterCondition condition) {
    this.default_condition = condition;
    return this;
  }
  
  /**
   * Set default operator EQUAL/LIKE/IN
   * 
   * @param operator enum RequestParameterOperator (ex: RequestParameterOperator.EQUAL)
   * 
   * @return RequestParameters
   */
  public RequestParameters setDefaultOperator(RequestParameterOperator operator) {
    this.default_operator = operator;
    return this;
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
   * Set offset by page number you want to receive
   * <br/>if value is less than 1, then the value 1 will be assigned to it by default.
   * 
   * @param p_page number of page you want to receive
   * 
   * @return RequestParameters
   */
  public RequestParameters setPage(int p_page) {
    this.paginated = true;
    this.offset = ((p_page<1 ? 1 : p_page) - 1) * this.limit;
    return this;
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
   * Offset
   * <br/>if value is less than 1, then the value 1 will be assigned to it by default.
   * 
   * @param p_offset Offset
   * 
   * @return RequestParameters
   */
  public RequestParameters setOffset(int p_offset) {
    this.paginated = true;
    this.offset = (p_offset<1 ? 1 : p_offset);
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
   * <br/>if value is less than 1, then the value 20 (constant PAGE_LENGTH) will be assigned to it by default.

   * @param p_limit number of rows the query should return
   * 
   * @return RequestParameters
   */
  public RequestParameters setLimit(int p_limit) {
    this.paginated = true;
    this.limit = (p_limit<1 ? RequestParameters.PAGE_LENGTH : p_limit) ;
    return this;
  }

  /**
   * Add parameter with the default operator
   * <br/>adds a condition that will be applied to the request.
   * 
   * <br/><b>Example:</b><br/>
   * &emsp;.setDefaultOperator(RequestParameterOperator.EQUAL)<br/>
   * &emsp;.addRequestParameter("actif", "1")<br/>
   * 
   * @param p_name field name 
   * @param p_value Valeur
   * 
   * @return RequestParameters
   */
  public RequestParameters addParameter(String p_name, String p_value) {
    RequestParameter param = new RequestParameter(p_name, p_value, this.default_operator);
    this.map.add(param);
    return this;
  }
  
  /**
   * Add parameter with specific operator
   * 
   * <br/><b>Example:</b><br/>
   * &emsp;.addRequestParameter("actif", "1", RequestParameterOperator.EQUAL)<br/>
   * &emsp;.addRequestParameter("numero", "4656,3156", RequestParameterOperator.IN)<br/>
   * 
   * @param p_name Nom
   * @param p_value Valeur
   * @param p_oper RequestParameterOperator
   * 
   * @return RequestParameters
   */
  public RequestParameters addParameter(String p_name, String p_value, RequestParameterOperator p_oper) {
    RequestParameter param = new RequestParameter(p_name, p_value, p_oper);
    this.map.add(param);
    return this;
  }
  
  /**
   * Pagination changed ?
   * <br/> it's true if limit,page or offset are assigned
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
  
  /**
   * Add request condition
   * 
   * <br/><b>Example:</b><br/>
   * &emsp;myModel = new {@code <myModelManager extends BaseManager>};<br/>
   * &emsp;myModel.flushRequestParameters();<br/>
   * &emsp;RequestParameters myCondition = new RequestParameters();<br/>
   * &emsp;myCondition.setDefaultCondition(RequestParameterCondition.OR);<br/>
   * &emsp;myCondition.addParameter("proprietaire.prenom", "JVS");<br/>
   * &emsp;myModel.addRequestCondition(myCondition);<br/>

   * @param p_condition condition
   * 
   * @return RequestParameters
   */
  public RequestParameters addRequestCondition(RequestParameters p_condition)
  {
    this.conditions.add(p_condition);
    return this;
  }
  
  /**
   * Get conditions
   * 
   * @return ArrayList
   */
  public ArrayList<RequestParameters> getConditions()
  {
    return this.conditions;
  }
}
