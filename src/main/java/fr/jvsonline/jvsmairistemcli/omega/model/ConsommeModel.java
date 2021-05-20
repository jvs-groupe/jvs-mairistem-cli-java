package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
//import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ConsommeModel
 */
@Type("POGRC_Consomme")
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
  private Date date_ancien_index;

  /**
   * Ancien index
   */
  @JsonProperty("ai")
  private Integer ancien_index;

  /**
   * Date nouvel index
   */
  @JsonProperty("dateni")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date date_nouvel_index;
  
  /**
   * Nouvel index
   */
  @JsonProperty("ni")
  private Integer nouvel_index;

  /**
   * Type de relevé
   */
  @JsonProperty("enum_crlv")
  private String type_releve;
  
  /**
   * A facturer
   */
  @JsonProperty("afacturer")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean a_facturer;
  
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
   * Budget
   */
  @JsonProperty("enum_budg")
  private String budget;

  /**
   * Consommation relevée
   */
  @JsonProperty("consorlv")
  private Integer consommation_releve;

  /**
   * Consommation facturée 
   */
  @JsonProperty("comsofact")
  private Integer consommation_facturee;
  
  /**
   * Constructor
   */
  public ConsommeModel() {
  }

  /**
   * Get id
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getId() {
    return this.id;
  }

  /**
   * Set id
   * 
   * @param p_id id
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
   * Get date_ancien_index
   * 
   * @return Date
   */
  @JsonIgnore
  public Date getDateAncienIndex() {
    return this.date_ancien_index;
  }
  
  /**
   * Set date_ancien_index
   *  
   * @param p_date_ancien_index date_ancien_index
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setDateAncienIndex(Date p_date_ancien_index) {
    this.date_ancien_index = p_date_ancien_index;
    return this;
  }
  
  /**
   * Get ancien_index
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getAncienIndex() {
    return this.ancien_index;
  }
  
  /**
   * Set ancien_index
   * 
   * @param p_ancien_index ancien_index
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setAncienIndex(Integer p_ancien_index) {
    this.ancien_index = p_ancien_index;
    return this;
  }
  
  /**
   * Get date_nouvel_index
   * 
   * @return Date
   */
  @JsonIgnore
  public Date getDateNouvelIndex() {
    return this.date_nouvel_index;
  }
  
  /**
   * Set date_nouvel_index
   * 
   * @param p_date_nouvel_index date_nouvel_index
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setDateNouvelIndex(Date p_date_nouvel_index) {
    this.date_nouvel_index = p_date_nouvel_index;
    return this;
  }
  
  /**
   * Get nouvel_index
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getNouvelIndex() {
    return this.nouvel_index;
  }
  
  /**
   * Set nouvel_index
   * 
   * @param p_nouvel_index nouvel_index
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setNouvelIndex(Integer p_nouvel_index) {
    this.nouvel_index = p_nouvel_index;
    return this;
  }
  
  /**
   * Get type_releve
   * 
   * @return String
   */
  @JsonIgnore
  public String getTypeReleve() {
    return this.type_releve;
  }
  
  /**
   * Set type_releve
   * 
   * @param p_type_releve type_releve
   * 
   * @return ConsommeModel
   */
  public ConsommeModel setTypeReleve(String p_type_releve) {
    this.type_releve = p_type_releve;
    return this;
  }
  
  /**
   * Get a_facturer
   * 
   * @return Boolean
   */
  public Boolean getAFacturer() {
    return this.a_facturer;
  }
  
  /**
   * Get a_facturer
   * 
   * @return Boolean
   */
  public Boolean isAFacturer() {
    return this.a_facturer;
  }
  
  /**
   * Get facture
   * 
   * @return Boolean
   */
  public Boolean getFacture() {
    return this.facture;
  }
  
  /**
   * Get facture
   * 
   * @return Boolean
   */
  public Boolean hasFacture() {
    return this.facture;
  }

  /**
   * Get forfait
   * 
   * @return Boolean
   */
  public Boolean getForfait() {
    return this.forfait;
  }
  
  /**
   * Get forfait
   * 
   * @return Boolean
   */
  public Boolean isForfait() {
    return this.forfait;
  }

  /**
   * Get budget
   * 
   * @return String
   */
  public String getBudget() {
    return this.budget;
  }

  /**
   * Get consommation_releve
   * 
   * @return Integer
   */
  public Integer getConsommationRelevee() {
    return this.consommation_releve;
  }
  
  /**
   * Get consommation_facturee
   * 
   * @return Integer
   */
  public Integer getConsommationFacturee() {
    return this.consommation_facturee;
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
    String converted = formatter.format(this.date_nouvel_index);

    return "Consomme " + this.nouvel_index.toString() + " du " + converted;
  }
}
