package fr.jvsonline.jvsmairistemcli.core;

import java.util.HashMap;
import java.util.Map;

import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.RequestParameterOperator;

/**
 * RequestParameter
 * 
 * @author jeromeklam
 */
public class RequestParameter extends Loggable {
  
  /**
   * Parameter name
   */
  protected String name;
  
  /**
   * Operator
   */
  protected RequestParameterOperator operator;
  
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
  public RequestParameter(String p_name, String p_value, RequestParameterOperator p_operator) {
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
  public RequestParameter setName(String p_name) {
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
   * @return RequestParameterOperator
   */
  public RequestParameterOperator getOperator() {
    return this.operator;
  }
}
