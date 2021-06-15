package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
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
 * ArticleModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Article")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArticleModel extends BaseModel {

  /**
   * Identifiant de l'article
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("article_id")
  private Integer id;

  /**
   * Code article
   */
  @JsonProperty("codeart")
  private String code;

  /**
   * Libellé de l'article
   */
  @JsonProperty("libart")
  private String libelle;

  /**
   * Désignation de l'article
   */
  @JsonProperty("design")
  private String description;

  /**
   * Prix unitaire de l'article
   */
  @JsonProperty("pu")
  private Float prix_unitaire = 0f;

  /**
   * Unité de l'article
   */
  @JsonProperty("enum_unite")
  private String unite;

  /**
   * Code TVA l'article
   */
  @JsonProperty("enum_tva")
  private String code_tva;

  /**
   * Code tri l'article
   */
  @JsonProperty("codetri")
  private String tri;

  /**
   * Actif
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;

  /**
   * Comptar
   */
  @Relationship("comptar")
  private CompositionTarifModel compositionTarif;
  
  /**
   * Constructor
   */
  public ArticleModel() {
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
   * @return ArticleModel
   */
  public ArticleModel setId(Integer p_id) {
    this.id = p_id;
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
   * @param p_code code
   * 
   * @return ArticleModel
   */
  public ArticleModel setCode(String p_code) {
    this.code = p_code;
    return this;
  }

  /**
   * Get Libellé
   * 
   * @return String
   */
  public String getLibelle() {
    return this.libelle;
  }

  /**
   * Set code
   * 
   * @param p_libelle libellé
   * 
   * @return ArticleModel
   */
  public ArticleModel setLibelle(String p_libelle) {
    this.libelle = p_libelle;
    return this;
  }

  /**
   * Get prix unitaire
   * 
   * @return float
   */
  public Float getPrixUnitaire() {
    return this.prix_unitaire;
  }

  /**
   * Set prix unitaire
   * 
   * @param p_pu Prix unitaire
   * 
   * @return ArticleModel
   */
  public ArticleModel setPrixUnitaire(Float p_pu) {
    this.prix_unitaire = p_pu;
    return this;
  }

  /**
   * Get unite
   * 
   * @return String
   */
  public String getUnite() {
    return this.unite;
  }

  /**
   * Set unite
   * 
   * @param p_unite unité
   * 
   * @return ArticleModel
   */
  public ArticleModel setUnite(String p_unite) {
    this.unite = p_unite;
    return this;
  }

  /**
   * Get code tva
   * 
   * @return String
   */
  public String getCodeTva() {
    return this.code_tva;
  }

  /**
   * Set cde tva
   * 
   * @param p_code_tva Code TVA
   * 
   * @return ArticleModel
   */
  public ArticleModel setCodeTva(String p_code_tva) {
    this.code_tva = p_code_tva;
    return this;
  }

  /**
   * Get tri
   * 
   * @return String
   */
  public String getTri() {
    return this.tri;
  }

  /**
   * Set tri
   * 
   * @param p_tri Tri
   * 
   * @return ArticleModel
   */
  public ArticleModel setTri(String p_tri) {
    this.tri = p_tri;
    return this;
  }

  /**
   * Get actif
   * 
   * @return Boolean
   */
  public Boolean getActif() {
    return this.actif;
  }

  /**
   * Set actif
   * 
   * @param p_actif Actif
   * 
   * @return ArticleModel
   */
  public ArticleModel setActif(Boolean p_actif) {
    this.actif = p_actif;
    return this;
  }
}
