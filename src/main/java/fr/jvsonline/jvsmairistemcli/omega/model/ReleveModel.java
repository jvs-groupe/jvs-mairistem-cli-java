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
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ReleveModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Releve")
public class ReleveModel extends BaseModel {

  /**
   * Identifiant du relevé
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("releve_id")
  private Integer id;
  
  /**
   * Identifiant du point de consommation
   */
  @JsonProperty("pconso_id")
  private Integer id_pconso;
  
  /**
   * Identifiant du compteur
   */
  @JsonProperty("compteur_id")
  private Integer id_compteur;
  
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
   * Radio relève
   */
  @JsonProperty("radiorlv")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean radioReleve;
  
  /**
   * Compteur inversé
   */
  @JsonProperty("cptinverse")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean compteurInverse;
  
  /**
   * Compteur tour
   */
  @JsonProperty("cpttour")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean tourCompteur;
  
  /**
   * Compteur fuite
   */
  @JsonProperty("cptfuite")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean fuiteCompteur;
  
  /**
   * Consommation relevée
   */
  @JsonProperty("consorlv")
  private Integer consommationReleve;
  
  /**
   * Indice
   */
  @JsonProperty("indinterm")
  private String indiceIntermediaire;
  
  /**
   * Commentaire
   */
  @JsonProperty("comlib")
  private String commentaire;
  
  /**
   * Constructor
   */
  public ReleveModel() {
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
   * @return ReleveModel
   */
  public ReleveModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Get pconso_id
   * 
   * @return Integer
   */
  public Integer getIdPconso() {
    return this.id_pconso;
  }
  
  /**
   * Set pconso_id
   * 
   * @param p_id_pconso Identifiant point de consommation
   * 
   * @return ReleveModel
   */
  public ReleveModel setIdPconso(Integer p_id_pconso) {
    this.id_pconso = p_id_pconso;
    return this;
  }
  
  /**
   * Get compteur_id
   * 
   * @return Integer
   */
  public Integer getIdCompteur() {
    return this.id_compteur;
  }
  
  /**
   * Set compteur_id
   * 
   * @param p_id_compteur Identifiant compteur
   * 
   * @return ReleveModel
   */
  public ReleveModel setIdCompteur(Integer p_id_compteur) {
    this.id_compteur = p_id_compteur;
    return this;
  }
  
  /**
   * Get date ancien index
   * 
   * @return Date
   */
  public Date getDateAncienIndex() {
    return this.dateAncienindex;
  }
  
  /**
   * Set date ancien index
   *  
   * @param p_date Date
   * 
   * @return ReleveModel
   */
  public ReleveModel setDateAncienIndex(Date p_date) {
    this.dateAncienindex = p_date;
    return this;
  }
  
  /**
   * Get ancien index
   * 
   * @return Integer
   */
  public Integer getAncienIndex() {
    return this.ancienIndex;
  }
  
  /**
   * Set ancien index
   * 
   * @param p_ancien_index Integer
   * 
   * @return ReleveModel
   */
  public ReleveModel setAncienIndex(Integer p_ancien_index) {
    this.ancienIndex = p_ancien_index;
    return this;
  }
  
  /**
   * Get date nouvel index
   * 
   * @return Date
   */
  public Date getDateNouvelIndex() {
    return this.dateNouvelIndex;
  }
  
  /**
   * Set date nouvel index
   * 
   * @param p_date Date
   * 
   * @return ReleveModel
   */
  public ReleveModel setDateNouvelIndex(Date p_date) {
    this.dateNouvelIndex = p_date;
    return this;
  }
  
  public Integer getNouvelIndex() {
    return this.nouvelIndex;
  }
  
  /**
   * Set nouvel index
   * 
   * @param p_index Nouvel index
   * 
   * @return ReleveModel
   */
  public ReleveModel setNouvelIndex(Integer p_index) {
    this.nouvelIndex = p_index;
    return this;
  }
  
  /**
   * Get type de relevé
   * 
   * @return String
   */
  public String getTypeReleve() {
    return this.typeReleve;
  }
  
  /**
   * Set type de relevé
   * 
   * @param p_type_releve String
   * 
   * @return ReleveModel
   */
  public ReleveModel setTypeReleve(String p_type_releve) {
    this.typeReleve = p_type_releve;
    return this;
  }
  
  /**
   * toString
   * 
   * @return String
   */
  @Override
  public String toString() {
    DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String converted = formatter.format(this.dateNouvelIndex);
    return "Index " + this.nouvelIndex.toString() + " du " + converted;
  }
}
