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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ConsommeModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Consomme")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsommeModel extends BaseModel {

  /**
   * Identifiant du consomme
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("consomme_id")
  private Integer id;
  
  /**
   * Identifiant du contrat
   */
  @JsonProperty("contrat_id")
  private Integer id_contrat;
  
  /**
   * Date ancien index
   */
  @JsonProperty("dateai")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateAncienindex;

  /**
   * Ancien index
   */
  @JsonProperty("ai")
  private Integer ancienIndex;

  /**
   * Date nouvel index
   */
  @JsonProperty("dateni")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateNouvelIndex;
  
  /**
   * Nouvel index
   */
  @JsonProperty("ni")
  private Integer nouvelIndex;

  /**
   * Type de relevé
   */
  @JsonProperty("enum_crlv")
  private String typeReleve;
  
  /**
   * A facturer
   */
  @JsonProperty("afacturer")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean aFacturer;
  
  /**
   * Facturé
   */
  @JsonProperty("facture")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean facture;
  
  /**
   * Forfait
   */
  @JsonProperty("forfait")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean forfait;
  
  /**
   * Consommation relevée
   */
  @JsonProperty("consorlv")
  private Integer consommationReleve;
  
  /**
   * Budget
   */
  @JsonProperty("enum_budg")
  private String budget;
  
  /**
   * Consommation facturée 
   */
  @JsonProperty("comsofact")
  private String consommationFacturee;
  
  /**
   * Constructor
   */
  public ConsommeModel() {
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
   * @return ConsommeModel
   */
  public ConsommeModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Get contrat_id
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdContrat() {
    return this.id_contrat;
  }
  
  /**
   * Get date ancien index
   * 
   * @return Date
   */
  @JsonIgnore
  public Date getDateAncienIndex() {
    return this.dateAncienindex;
  }
  
  /**
   * Set date ancien index
   *  
   * @param p_date Date
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setDateAncienIndex(Date p_date) {
    this.dateAncienindex = p_date;
    return this;
  }
  
  /**
   * Get ancien index
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getAncienIndex() {
    return this.ancienIndex;
  }
  
  /**
   * Set ancien index
   * 
   * @param p_ancien_index Integer
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setAncienIndex(Integer p_ancien_index) {
    this.ancienIndex = p_ancien_index;
    return this;
  }
  
  /**
   * Get date nouvel index
   * 
   * @return Date
   */
  @JsonIgnore
  public Date getDateNouvelIndex() {
    return this.dateNouvelIndex;
  }
  
  /**
   * Set date nouvel index
   * 
   * @param p_date Date
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setDateNouvelIndex(Date p_date) {
    this.dateNouvelIndex = p_date;
    return this;
  }
  
  /**
   * Retourne le nouvel index
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getNouvelIndex() {
    return this.nouvelIndex;
  }
  
  /**
   * Set nouvel index
   * 
   * @param p_index Nouvel index
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setNouvelIndex(Integer p_index) {
    this.nouvelIndex = p_index;
    return this;
  }
  
  /**
   * Get type de relevé
   * 
   * @return String
   */
  @JsonIgnore
  public String getTypeReleve() {
    return this.typeReleve;
  }
  
  /**
   * Set type de relevé
   * 
   * @param p_type_releve String
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setTypeReleve(String p_type_releve) {
    this.typeReleve = p_type_releve;
    return this;
  }
  
  /**
   * toString
   * 
   * @return String
   */
  @JsonIgnore
  @Override
  public String toString() {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String converted = formatter.format(this.dateNouvelIndex);
    return "Consomme " + this.nouvelIndex.toString() + " du " + converted;
  }
}
