package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateSerializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
  
  /**
   * Status de la demande
   */
  @JsonProperty("req_status")
  private DemandeStatusEnum status;
  
  /**
   * Code de la demande
   */
  @JsonProperty("req_code")
  private DemandeCodeEnum code;
  
  /**
   * Titre de la demande
   */
  @JsonProperty("req_title")
  private String title;
  
  /**
   * Date de la demande
   */
  @JsonSerialize(using = CustomDateSerializer.class)
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("req_ts")
  private Date dateDemande;
  
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
  
  /**
   * Get code
   * 
   * @return DemandeCodeEnum
   */
  public DemandeCodeEnum getCode() {
    return this.code;
  }
  
  /**
   * Set title
   * 
   * @param p_title Titre
   * 
   * @return DemandeModel
   */
  public DemandeModel setTitle(String p_title) {
    this.title = p_title;
    return this;
  }
  
  /**
   * Get title
   * 
   * @return String
   */
  public String getTitle() {
    return this.title;
  }
  
  /**
   * Set Ts
   * 
   * @param p_date Date de la demande
   * 
   * @return DemandeModel
   */
  public DemandeModel setDateDemande(Date p_date) {
    this.dateDemande = p_date;
    return this;
  }
  
  /**
   * Get ts
   * 
   * @return Date
   */
  public Date getDateDemande() {
    return this.dateDemande;
  }
}
