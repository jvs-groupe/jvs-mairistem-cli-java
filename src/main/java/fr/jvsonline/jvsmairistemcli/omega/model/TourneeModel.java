package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * TourneeModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Tournee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourneeModel extends BaseModel {

  /**
   * Identifiant de la tournée
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("tournee_id")
  private Integer id;

  /**
   * Code tournée
   */
  @JsonProperty("codetournee")
  private String code;

  /**
   * Libellé tournée
   */
  @JsonProperty("libtournee")
  private String libelle;

  /**
   * Identifiant de l'agent
   */
  @JsonProperty("agent_id")
  private Integer id_agent;

  /**
   * Constructor
   */
  public TourneeModel() {
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
   * @return TourneeModel
   */
  public TourneeModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get code
   * 
   * @return Code
   */
  public String getCode() {
    return this.code;
  }

  /**
   * Set code
   * 
   * @param p_code Code
   * 
   * @return TourneeModel
   */
  public TourneeModel setCode(String p_code) {
    this.code = p_code;
    return this;
  }

  /**
   * Get libelle
   * 
   * @return String
   */
  public String getLibelle() {
    return this.libelle;
  }

  /**
   * Set libelle
   * 
   * @param p_libelle Libellé
   * 
   * @return TourneeModel
   */
  public TourneeModel setLibelle(String p_libelle) {
    this.libelle = p_libelle;
    return this;
  }

  /**
   * Get identifiant agent
   * 
   * @return Integer
   */
  public Integer getIdAgent() {
    return this.id_agent;
  }

  /**
   * Set id egent
   * 
   * @param p_id_agent Identifiant de l'agent
   * 
   * @return TourneeModel
   */
  public TourneeModel setIdAgent(Integer p_id_agent) {
    this.id_agent = p_id_agent;
    return this;
  }
}
