package fr.jvsonline.jvsmairistemcli.core;

import java.util.HashMap;
import java.util.Map;

import fr.jvsonline.jvsmairistemcli.core.Loggable;

/**
 * RequestParameter
 * 
 * @author jeromeklam
 */
public class RequestParameter extends Loggable {
  
  /**
   * Standard operators
   */
  protected static final String FIND_EQUAL = "eq";
  protected static final String FIND_LIKE = "like";
  
  /**
   * Parameter name
   */
  protected String name;
  
  /**
   * Operator
   */
  protected String operator;
  
  /**
   * Parameter value
   */
  protected String value;
  
  /**
   * Constructor
   */
  public RequestParameter() {
  }
  
  /**
   * Constructor
   * 
   * @param p_name Nom
   * @param p_value Valeur
   * @param p_operator Opérateur
   */
  public RequestParameter(String p_name, String p_value, String p_operator) {
    this.name = p_name;
    this.value = p_value;
    this.operator = p_operator;
  }
  
  /**
   * Set name
   * 
   * @param p_name Nom
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
