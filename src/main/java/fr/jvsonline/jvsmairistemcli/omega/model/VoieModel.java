package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeModel;

/**
 * VoieModel
 * 
 * @author jeromeklam
 * @package Voie
 */
@Type("Partner_Voie")
public class VoieModel extends BaseModel {

  /**
   * Identifiant de l'adresse de desserte
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("voie_id")
  private Integer id;

  /**
   * Identifiant de l'organisme
   * 
   * @var Integer
   */
  @JsonProperty("organism_id")
  private Integer id_organism;

  /**
   * Identifiant du quartier
   * 
   * @var Integer
   */
  @JsonProperty("quartier_id")
  private Integer id_quartier;
  
  /**
   * Code de la voie
   * 
   * @var String
   */
  @JsonProperty("codevoie")
  private String code;

  /**
   * Type de la voie
   * 
   * @var String
   */
  @JsonProperty("typevoie")
  private String type;
  
  /**
   * Article de la voie
   * 
   * @var String
   */
  @JsonProperty("artvoie")
  private String article;
  
  /**
   * Nom de la voie
   * 
   * @var String
   */
  @JsonProperty("nomvoie")
  private String nom;

  /**
   * Coordoonées SIG
   * 
   * @var String
   */
  @JsonProperty("sigcoord")
  private String coordonnees;
  
  /**
   * Id admin
   * 
   * @var String
   */
  @JsonProperty("idadmin")
  private String admin;
  
  /**
   * Voie active
   * 
   * @var Boolean
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;
  
  /**
   * Organisme
   * 
   * @var OrganismeModel
   */
  @Relationship("organism")
  private OrganismeModel organisme;
  
  /**
   * Constructor
   */
  public VoieModel() {
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
   * @param Integer p_id
   * 
   * @return VoieModel
   */
  public VoieModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get identifiant de l'organisme
   * 
   * @return Integer
   */
  public Integer getIdOrganisme() {
    return this.id_organism;
  }

  /**
   * Set identifiant de l'organisme
   * 
   * @param Integer p_idOrganisme
   * 
   * @return VoieModel
   */
  public VoieModel setIdOrganism(Integer p_idOrganisme) {
    this.id_organism = p_idOrganisme;
    return this;
  }
  
  /**
   * Get code
   * 
   * @return String
   */
  public String getCode() {
    return this.code;
  }
  
  /**
   * Set code
   * 
   * @param String p_code
   * 
   * @return VoieModel
   */
  public VoieModel setCode(String p_code) {
    this.code = p_code;
    return this;
  }
  
  /**
   * Get nom
   * 
   * @return String
   */
  public String getNom() {
    return this.nom;
  }
  
  /**
   * Set nom
   * 
   * @param String p_nom
   * 
   * @return VoieModel
   */
  public VoieModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }

  /**
   * Get type
   *
   * @return String 
   */
  public String getType() {
    return this.type;
  }

  /**
   * Set type
   *
   * @param String p_type
   *
   * @return VoieModel
   */
  public VoieModel setType(String p_type) {
    this.type = p_type;
    return this;
  }

  /**
   * Get article
   *
   * @return String 
   */
  public String getArticle() {
    return this.article;
  }

  /**
   * Set article
   *
   * @param String p_article
   *
   * @return VoieModel
   */
  public VoieModel setArticle(String p_article) {
    this.article = p_article;
    return this;
  }
  
  /**
   * Get organisme
   * 
   * @return OrganismeModel
   */
  public OrganismeModel getOrganisme() {
    return this.organisme;
  }
}
