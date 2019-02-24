package fr.jvsonline.jvsmairistemcli.core;

import java.util.ArrayList;

import fr.jvsonline.jvsmairistemcli.core.Loggable;

/**
 * RequestParameters
 * 
 * @author jeromeklam
 * @package Request
 */
public class RequestParameters extends Loggable {

  /**
   * Standard page length
   * 
   * @var int
   */
  protected static final int              PAGE_LENGTH      = 20;

  /**
   * Standard consitions
   * 
   * @var String
   */
  protected static final String           COND_OR          = "or";
  protected static final String           COND_AND         = "and";

  /**
   * Start, assumes start is 1.
   * 
   * @var int
   */
  protected int                           offset           = 1;

  /**
   * Length
   * 
   * @var int
   */
  protected int                           limit            = RequestParameters.PAGE_LENGTH;

  /**
   * Parameters
   * 
   * @var ArrayList<RequestParameter>
   */
  protected ArrayList<RequestParameter> map;

  /**
   * Default operator
   * 
   * @var String
   */
  protected String                        default_operator = RequestParameter.FIND_LIKE;

  /**
   * Default condition
   * 
   * @var String
   */
  protected String                        default_condition = COND_AND;
  
  /**
   * Pagination updated ?
   * 
   * @var boolean
   */
  protected boolean paginated = false;
  
  /**
   * Constructor
   */
  public RequestParameters() {
    this.map = new ArrayList<RequestParameter>();
  }

  /**
   * Set offset and limit by page number
   * 
   * @param int page
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
   * @param int p_offset
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
   * @param int p_limit
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
   * @param String p_name
   * @param String p_value
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
   * @return ArrayList<RequestParameter>
   */
  public ArrayList<RequestParameter> getParameters()
  {
    return this.map;
  }
}
