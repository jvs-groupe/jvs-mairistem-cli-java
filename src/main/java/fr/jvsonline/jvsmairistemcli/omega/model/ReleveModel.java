package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ReleveModel
 */
@Type("POGRC_Releve")
@JsonIgnoreProperties(ignoreUnknown = true)
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
	 * Radio relève
	 */
	@JsonProperty("radiorlv")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	private Boolean radio_releve;

	/**
	 * Compteur inversé
	 */
	@JsonProperty("cptinverse")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	private Boolean compteur_inverse;

	/**
	 * Compteur tour
	 */
	@JsonProperty("cpttour")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	private Boolean tour_compteur;

	/**
	 * Compteur fuite
	 */
	@JsonProperty("cptfuite")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	private Boolean fuite_compteur;

	/**
	 * Consommation relevée
	 */
	@JsonProperty("consorlv")
	private Integer consommation_releve;

	/**
	 * Indice
	 */
	@JsonProperty("indinterm")
	private String indice_intermediaire;

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
	 * @return ReleveModel
	 */
	public ReleveModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get id_pconso
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getIdPconso() {
		return this.id_pconso;
	}

	/**
	 * Set id_pconso
	 * 
	 * @param p_id_pconso id_pconso
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setIdPconso(Integer p_id_pconso) {
		this.id_pconso = p_id_pconso;
		return this;
	}

	/**
	 * Get id_compteur
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getIdCompteur() {
		return this.id_compteur;
	}

	/**
	 * Set id_compteur
	 * 
	 * @param p_id_compteur id_compteur
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setIdCompteur(Integer p_id_compteur) {
		this.id_compteur = p_id_compteur;
		return this;
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
	 * @return ReleveModel
	 */
	public ReleveModel setDateAncienIndex(Date p_date_ancien_index) {
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
	 * @return ReleveModel
	 */
	public ReleveModel setAncienIndex(Integer p_ancien_index) {
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
	 * @return ReleveModel
	 */
	public ReleveModel setDateNouvelIndex(Date p_date_nouvel_index) {
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
	 * @return ReleveModel
	 */
	public ReleveModel setNouvelIndex(Integer p_nouvel_index) {
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
	 * @return ReleveModel
	 */
	public ReleveModel setTypeReleve(String p_type_releve) {
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
	 * Set a_facturer
	 * 
	 * @param p_a_facturer a_facturer
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setActif(Boolean p_a_facturer) {
		this.a_facturer = p_a_facturer;
		return this;
	}

	/**
	 * Get radio_releve
	 * 
	 * @return Boolean
	 */
	public Boolean getRadioReleve() {
		return this.radio_releve;
	}

	/**
	 * Get radio_releve
	 * 
	 * @return Boolean
	 */
	public Boolean isRadioReleve() {
		return this.radio_releve;
	}

	/**
	 * Set radio_releve
	 * 
	 * @param p_radio_releve radio_releve
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setRadioReleve(Boolean p_radio_releve) {
		this.radio_releve = p_radio_releve;
		return this;
	}

	/**
	 * Get compteur_inverse
	 * 
	 * @return Boolean
	 */
	public Boolean getCompteurInverse() {
		return this.compteur_inverse;
	}

	/**
	 * Get compteur_inverse
	 * 
	 * @return Boolean
	 */
	public Boolean hasCompteurInverse() {
		return this.compteur_inverse;
	}

	/**
	 * Set compteur_inverse
	 * 
	 * @param p_compteur_inverse compteur_inverse
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setCompteurInverse(Boolean p_compteur_inverse) {
		this.compteur_inverse = p_compteur_inverse;
		return this;
	}

	/**
	 * Get tour_compteur
	 * 
	 * @return Boolean
	 */
	public Boolean getTourCompteur() {
		return this.tour_compteur;
	}

	/**
	 * Get tour_compteur
	 * 
	 * @return Boolean
	 */
	public Boolean hasTourCompteur() {
		return this.tour_compteur;
	}

	/**
	 * Set tour_compteur
	 * 
	 * @param p_tour_compteur tour_compteur
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setTourCompteur(Boolean p_tour_compteur) {
		this.tour_compteur = p_tour_compteur;
		return this;
	}

	/**
	 * Get fuite_compteur
	 * 
	 * @return Boolean
	 */
	public Boolean getFuiteCompteur() {
		return this.fuite_compteur;
	}

	/**
	 * Get fuite_compteur
	 * 
	 * @return Boolean
	 */
	public Boolean hasFuiteCompteur() {
		return this.fuite_compteur;
	}

	/**
	 * Set fuite_compteur
	 * 
	 * @param p_fuite_compteur fuite_compteur
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setFuiteCompteur(Boolean p_fuite_compteur) {
		this.fuite_compteur = p_fuite_compteur;
		return this;
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
	 * Get indice_intermediaire
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getIndiceIntermediaire() {
		return this.indice_intermediaire;
	}

	/**
	 * Set indice_intermediaire
	 * 
	 * @param p_indice_intermediaire indice_intermediaire
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setIndiceIntermediaire(String p_indice_intermediaire) {
		this.indice_intermediaire = p_indice_intermediaire;
		return this;
	}

	/**
	 * Get commentaire
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCommentaire() {
		return this.commentaire;
	}

	/**
	 * Set commentaire
	 * 
	 * @param p_commentaire commentaire
	 * 
	 * @return ReleveModel
	 */
	public ReleveModel setCommentaire(String p_commentaire) {
		this.commentaire = p_commentaire;
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
		String converted = formatter.format(this.date_nouvel_index);

		return "Index " + this.nouvel_index.toString() + " du " + converted;
	}
}
