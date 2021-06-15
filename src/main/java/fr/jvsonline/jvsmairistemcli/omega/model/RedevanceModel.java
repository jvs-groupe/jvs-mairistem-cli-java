package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * NomredevModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Nomredev")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RedevanceModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant du nomredev
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("nomredev_id")
  private Integer id;
  
  /**
   * Budget
   */
  @JsonProperty("enum_budg")
  private String budget;
  
  /**
   * Set budget
   * 
   * @param p_budget Budget (énumération)
   * 
   * @return NomredevModel
   */
  public RedevanceModel setBudget(String p_budget) {
    this.budget = p_budget;
    return this;
  }
  
  /**
   * Constructor
   */
  public RedevanceModel() {
  }
}