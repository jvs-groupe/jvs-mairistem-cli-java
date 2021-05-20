package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * CompteurModel
 */
@Type("POGRC_Compteur")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompteurModel extends BaseModel {

	/**
	 * Identifiant du compteur
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("compteur_id")
	private Integer id;

	/**
	 * Numéro de série
	 */
	@JsonProperty("numserie")
	private String numero_serie;

	/**
	 * Marque
	 */
	@JsonProperty("enum_marq")
	private String marque;

	/**
	 * Diamètre
	 */
	@JsonProperty("enum_diam")
	private String diametre;

	/**
	 * Calibre
	 */
	@JsonProperty("enum_calib")
	private String calibre;

	/**
	 * Compteur actif
	 */
	@JsonProperty("compteur_actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Année de fabrication
	 */
	@JsonProperty("anneefab")
	private Integer annee_fabrication;

	/**
	 * Type de compteur
	 */
	@JsonProperty("enum_tcpt")
	private String modele;

	/**
	 * Mode de relève
	 */
	@JsonProperty("rrmodereleve")
	private String mode_releve;

	/**
	 * Type de module
	 */
	@JsonProperty("rrtypemodule")
	private String type_module;

	/**
	 * NS module
	 */
	@JsonProperty("rrnsmodule")
	private String numero_module;

	/**
	 * Relève radio
	 */
	@JsonProperty("releve_radio")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) 
	@JsonSerialize(using = CustomBooleanToIntSerializer.class)
	private Boolean radio;

	/**
	 * Constructor
	 */
	public CompteurModel() {
	}

	/**
	 * Get id
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set id
	 * 
	 * @param p_id id
	 * 
	 * @return CompteurModel
	 */
	public CompteurModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get numero_serie
	 * 
	 * @return String
	 */
	public String getNumeroSerie() {
		return this.numero_serie;
	}

	/**
	 * Set numero_serie
	 * 
	 * @param p_numero_serie numero_serie
	 * 
	 * @return CompteurModel
	 */
	public CompteurModel setNumeroSerie(String p_numero_serie) {
		this.numero_serie = p_numero_serie;
		return this;
	}

	/**
	 * Get marque
	 * 
	 * @return String
	 */
	public String getMarque() {
		return this.marque;
	}

	/**
	 * Set marque
	 * 
	 * @param p_marque marque
	 * 
	 * @return CompteurModel
	 */
	public CompteurModel setMarque(String p_marque) {
		this.marque = p_marque;
		return this;
	}

	/**
	 * Get diametre
	 * 
	 * @return String
	 */
	public String getDiametre() {
		return this.diametre;
	}

	/**
	 * Set diametre
	 * 
	 * @param p_diametre diametre
	 * 
	 * @return CompteurModel
	 */
	public CompteurModel setDiametre(String p_diametre) {
		this.diametre = p_diametre;
		return this;
	}

	/**
	 * Get calibre
	 * 
	 * @return String
	 */
	public String getCalibre() {
		return this.calibre;
	}

	/**
	 * Set calibre
	 * 
	 * @param p_calibre calibre
	 * 
	 * @return CompteurModel
	 */
	public CompteurModel setCalibre(String p_calibre) {
		this.calibre = p_calibre;
		return this;
	}

	/**
	 * Get actif
	 * 
	 * @return Boolean
	 */
	@JsonIgnore
	public Boolean getActif() {
		return this.actif;
	}

	/**
	 * Get actif
	 * 
	 * @return Boolean
	 */
	public Boolean isActif() {
		return this.actif;
	}

	/**
	 * Get annee_fabrication
	 * 
	 * @return Integer
	 */
	public Integer getAnneeFabrication() {
		return this.annee_fabrication;
	}

	/**
	 * Get modele
	 * 
	 * @return String
	 */
	public String getModeleCompteur() {
		return this.modele;
	}

	/**
	 * Get mode_releve
	 * 
	 * @return String
	 */
	public String getModeReleve() {
		return this.mode_releve;
	}

	/**
	 * Get type_module
	 * 
	 * @return String
	 */
	public String getTypeModule() {
		return this.type_module;
	}

	/**
	 * Get numero_module
	 * 
	 * @return String
	 */
	public String getNumeroModule() {
		return this.numero_module;
	}

	/**
	 * Get radio
	 * 
	 * @return Boolean
	 */
	@JsonIgnore
	public Boolean getRadio() {
		return this.radio;
	}

	/**
	 * Get radio
	 * 
	 * @return Boolean
	 */
	public Boolean isRadio() {
		return this.radio;
	}
}
