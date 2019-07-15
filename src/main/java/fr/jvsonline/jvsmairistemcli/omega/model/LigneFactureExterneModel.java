package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Relationship;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * LigneFactureExterneModel
 * 
 * @author jeromeklam
 */
@Type("Partner_LigneFactureExterne")
@JsonIgnoreProperties(ignoreUnknown = true)
public class LigneFactureExterneModel extends BaseModel {
  
  /**
   * Identifiant de la ligne de facture
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("ligne_id")
  private Integer id;
  
  /**
   * Code article
   */
  @JsonProperty("codeart")
  private String code_article;
  
  /**
   * Quantite
   */
  @JsonProperty("quantite")
  private Float quantite;
  
  /**
   * Constructeur
   */
  public LigneFactureExterneModel() {
  }
  
  /**
   * Affectation e l'identifiant
   * 
   * @param p_id Identifiant
   * 
   * @return LigneFactureExterneModel
   */
  public LigneFactureExterneModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Retourne l'identifiant
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getId() {
    return this.id;
  }
  /**
   * Affectation du code article
   * 
   * @param p_code_article Code article
   * 
   * @return LigneFactureExterneModel
   */
  public LigneFactureExterneModel setCodeArticle(String p_code_article) {
    this.code_article = p_code_article;
    return this;
  }
  
  /**
   * Retourne le code article
   * 
   * @return String
   */
  @JsonIgnore
  public String getCodeArticle() {
    return this.code_article;
  }
  /**
   * Affectation de la quantité
   * 
   * @param p_quantite Quantité
   * 
   * @return LigneFactureExterneModel
   */
  public LigneFactureExterneModel setQuantite(Float p_quantite) {
    this.quantite = p_quantite;
    return this;
  }
  
  /**
   * Retourne la quantité
   * 
   * @return Float
   */
  @JsonIgnore
  public Float getQuantite() {
    return this.quantite;
  }
}
