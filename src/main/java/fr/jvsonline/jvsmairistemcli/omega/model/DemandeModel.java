package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
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
 * DemandeModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Request")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DemandeModel extends BaseModel {

  /**
   * Identifiant de la demande
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("req_id")
  private Integer id;
  
  @JsonProperty("req_status")
  private DemandeStatusEnum status;
  
  /**
   * Constructeur
   */
  public DemandeModel() {
  }
  
  /**
   * Get Id
   * 
   * @return Integer
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Set Id
   * 
   * @param p_id Identifiant
   * 
   * @return DemandeModel
   */
  public DemandeModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Get status
   * 
   * @return DemandeStatusEnum
   */
  public DemandeStatusEnum getStatus() {
    return this.status;
  }
}
