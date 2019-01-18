package fr.jvsonline.jvsmairistemcli.core;

import java.util.HashMap;
import java.util.Map;

import fr.jvsonline.jvsmairistemcli.core.Loggable;

/**
 * RequestParameter
 * 
 * @author jeromeklam
 * @package Request
 */
public class RequestParameter extends Loggable {
  
  /**
   * Standard operators
   * 
   * @var String
   */
  protected static final String FIND_EQUAL = "eq";
  protected static final String FIND_LIKE = "like";
  
  /**
   * Parameter name
   * 
   * @var String
   */
  protected String name;
  
  /**
   * Operator
   * 
   * @var String
   */
  protected String operator;
  
  /**
   * Parameter value
   * 
   * @var String
   */
  protected String value;
  
  /**
   * Constructor
   */
  public RequestParameter() {
  }
  
  /**
   * Constructor
   */
  public RequestParameter(String p_name, String p_value, String p_operator) {
    this.name = p_name;
    this.value = p_value;
    this.operator = p_operator;
  }
  
  /**
   * Set name
   * 
   * @param String p_name
   * 
   * @return RequestParameter
   */
  public RequestParameter setname(String p_name) {
    this.name = p_name;
    return this;
  }
  
  /**
   * Get name
   * 
   * @return String
   */
  public String getName() {
    return this.name;
  }
  
  /**
   * Get value
   * 
   * @return String
   */
  public String getValue() {
    return this.value;
  }
  
  /**
   * Get operator
   * 
   * @return String
   */
  public String getOperator() {
    return this.operator;
  }
}
