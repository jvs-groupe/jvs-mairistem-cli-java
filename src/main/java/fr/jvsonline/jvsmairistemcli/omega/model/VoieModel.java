package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeModel;

/**
 * VoieModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Voie")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoieModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant de l'adresse de desserte
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("voie_id")
  private Integer id;

  /**
   * Identifiant de l'organisme
   */
  @JsonProperty("organism_id")
  private Integer id_organism;

  /**
   * Identifiant du quartier
   */
  @JsonProperty("quartier_id")
  private Integer id_quartier;

  /**
   * Code de la voie
   */
  @JsonProperty("codevoie")
  private String code;

  /**
   * Type de la voie
   */
  @JsonProperty("typevoie")
  private String type;

  /**
   * Article de la voie
   */
  @JsonProperty("artvoie")
  private String article;

  /**
   * Nom de la voie
   */
  @JsonProperty("nomvoie")
  private String nom;

  /**
   * Coordoonées SIG
   */
  @JsonProperty("sigcoord")
  private String coordonnees;

  /**
   * Id admin
   */
  @JsonProperty("idadmin")
  private String admin;

  /**
   * Voie active
   */
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  @JsonProperty("actif")
  private Boolean actif;

  /**
   * Organisme
   */
  @Relationship("commune")
  private OrganismeModel commune;

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
  @JsonIgnore
  public Integer getId() {
    return this.id;
  }

  /**
   * Set Id
   * 
   * @param p_id Identifiant
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
  @JsonIgnore
  public Integer getIdOrganisme() {
    return this.id_organism;
  }

  /**
   * Set identifiant de l'organisme
   * 
   * @param p_idOrganisme Identifiant de l'organisme
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
  @JsonIgnore
  public String getCode() {
    if (this.code != null) {
      return this.code;
    }
    return "";
  }

  /**
   * Set code
   * 
   * @param p_code Code
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
  @JsonIgnore
  public String getNom() {
    if (this.nom != null) {
      return this.nom;
    }
    return "";
  }

  /**
   * Set nom
   * 
   * @param p_nom Nom
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
  @JsonIgnore
  public String getType() {
    if (this.type != null) {
      return this.type;
    }
    return "";
  }

  /**
   * Set type
   *
   * @param p_type Type
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
  @JsonIgnore
  public String getArticle() {
    if (this.article != null) {
      return this.article;
    }
    return "";
  }

  /**
   * Set article
   *
   * @param p_article Article
   *
   * @return VoieModel
   */
  public VoieModel setArticle(String p_article) {
    this.article = p_article;
    return this;
  }

  /**
   * Get commune
   * 
   * @return OrganismeModel
   */
  @JsonIgnore
  public OrganismeModel getCommune() {
    return this.commune;
  }
}
