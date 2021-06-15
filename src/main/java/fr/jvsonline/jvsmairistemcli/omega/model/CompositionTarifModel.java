package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ComptarModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Comptar")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompositionTarifModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant du comptar
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("comptar_id")
  private Integer id;
  
  /**
   * Nomredev
   */
  @Relationship("nomredev")
  private RedevanceModel redevance;
  
  /**
   * Constructor
   */
  public CompositionTarifModel() {
  }
}