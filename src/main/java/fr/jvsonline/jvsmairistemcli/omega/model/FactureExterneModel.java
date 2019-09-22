package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Relationship;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateSerializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * FactureExterneModel
 * 
 * @author jeromeklam
 */
@Type("Partner_FactureExterne")
@JsonIgnoreProperties(ignoreUnknown = true)
public class FactureExterneModel extends BaseModel {

  /**
   * Identifiant de la FactureExterne
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("facture_id")
  private Integer id;
  
  @JsonProperty("pconso_id")
  private Integer id_pconso;
  
  @Relationship("point_consommation")
  private PointDeConsommationModel point_consommation;
  
  @JsonProperty("personne_id")
  private Integer id_redevable;
  
  @Relationship("redevable")
  private PersonneModel redevable;
  
  @Relationship("organisme_factureur")
  private OrganismeFactureurModel ofact;
  
  /**
   * Date de facture
   */
  @JsonSerialize(using = CustomDateSerializer.class)
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("datefact")
  private Date dateFacture;
  
  /**
   * Lignes de facture
   */
  @Relationship("lignes")
  private List<LigneFactureExterneModel> lignes = null;

  /**
   * Constructeur
   */
  public FactureExterneModel() {
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
   * Affectation de l'identifiant
   * 
   * @param p_id Identifiant
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Retourne l'identifiant du point de consommation
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdPconso() {
    return this.id_pconso;
  }
  
  /**
   * Affectation de l'identifiant du point de consommation
   * 
   * @param p_idPconso Identifiant
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setIdPconso(Integer p_idPconso) {
    this.id_pconso = p_idPconso;
    return this;
  }
  
  /**
   * Retourne l'identifiant du redevable
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdRedevable() {
    return this.id_redevable;
  }
  
  /**
   * Affectation de l'identifiant du redevable
   * 
   * @param p_id_redevable Identifiant
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setIdRedevable(Integer p_id_redevable) {
    this.id_redevable = p_id_redevable;
    return this;
  }
  
  /**
   * Retourne le redevable
   * 
   * @return PersonneModel
   */
  @JsonIgnore
  public PersonneModel getRedevable() {
    return this.redevable;
  }
  
  /**
   * Affectation du redevable
   * 
   * @param p_redevable Redevable
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setRedevable(PersonneModel p_redevable) {
    this.redevable = p_redevable;
    return this;
  }
  
  /**
   * Retoune l'organisme factureur
   * 
   * @return OrganismeFactureurModel
   */
  @JsonIgnore
  public OrganismeFactureurModel getOrganismeFactureur() {
    return this.ofact;
  }
  
  /**
   * Affectation de l'organisme factureur
   * 
   * @param p_ofact Organisme factureur
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setOrganismeFactureur(OrganismeFactureurModel p_ofact) {
    this.ofact = p_ofact;
    return this;
  }
  
  /**
   * Retourne le point de consommation
   * 
   * @return PointConsommationModel
   */
  @JsonIgnore
  public PointDeConsommationModel getPointDeConsommation() {
    return this.point_consommation;
  }
  
  /**
   * Affectation du point de consommation
   * 
   * @param p_pconso Point de consommation
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setPointDeConsommation(PointDeConsommationModel p_pconso) {
    this.point_consommation = p_pconso;
    if (this.point_consommation != null) {
      this.id_pconso = this.point_consommation.getId();
    }
    return this;
  }
  
  /**
   * Affectation de la date de facture
   * 
   * @param p_date Date de facture
   * 
   * @return FactureExterneModel
   */
  public FactureExterneModel setDateFacture(Date p_date) {
    this.dateFacture = p_date;
    return this;
  }
  
  /**
   * Retourne la date de facture
   * 
   * @return Date
   */
  public Date getDateFacture() {
    return this.dateFacture;
  }
  
  /**
   * Ajoute une ligne
   * 
   * @param p_ligne Ligne
   * 
   * @return FactureExterneModel
   */
  @JsonIgnore
  public FactureExterneModel addLigneFactureExterne(LigneFactureExterneModel p_ligne) {
    if (this.lignes == null) {
      this.lignes = new ArrayList<LigneFactureExterneModel>();
    }
    this.lignes.add(p_ligne);
    return this;
  }
}
