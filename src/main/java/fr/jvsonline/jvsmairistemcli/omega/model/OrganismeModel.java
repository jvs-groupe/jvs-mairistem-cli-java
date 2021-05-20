package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * OrganismeModel
 */
@Type("POGRC_Organisme")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganismeModel extends BaseModel {

	/**
	 * Identifiant de l'organisme
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("organism_id")
	private Integer id;

	/**
	 * Type d'organisme
	 */
	@JsonProperty("enum_torg")
	private String type;

	/**
	 * Nom
	 */
	@JsonProperty("nomlorg")
	private String nom;

	/**
	 * Code postal
	 */
	@JsonProperty("cporg")
	private String code_postal;

	/**
	 * Ville
	 */
	@JsonProperty("villeorg")
	private String ville;

	/**
	 * Actif
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Constructor
	 */
	public OrganismeModel() {
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
	 * @return OrganismeModel
	 */
	public OrganismeModel setId(Integer p_id) {
		this.id = p_id;
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
	 * @param p_nom nom
	 *
	 * @return OrganismeModel
	 */
	public OrganismeModel setNom(String p_nom) {
		this.nom = p_nom;
		return this;
	}

	/**
	 * Get code_postal
	 *
	 * @return String
	 */
	@JsonIgnore
	public String getCodePostal() {
		if (this.code_postal != null) {
			return this.code_postal;
		}
		return "";
	}

	/**
	 * Set code_postal
	 *
	 * @param p_code_postal code_postal
	 *
	 * @return OrganismeModel
	 */
	public OrganismeModel setCodePostal(String p_code_postal) {
		this.code_postal = p_code_postal;
		return this;
	}

	/**
	 * Get ville
	 *
	 * @return String
	 */
	@JsonIgnore
	public String getVille() {
		if (this.ville != null) {
			return this.ville;
		}
		return "";
	}

	/**
	 * Set ville
	 *
	 * @param p_ville ville
	 *
	 * @return OrganismeModel
	 */
	public OrganismeModel setVille(String p_ville) {
		this.ville = p_ville;
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
	 * Set actif
	 * 
	 * @param p_actif actif
	 * 
	 * @return OrganismeModel
	 */
	public OrganismeModel setActif(Boolean p_actif) {
		this.actif = p_actif;
		return this;
	}
}
