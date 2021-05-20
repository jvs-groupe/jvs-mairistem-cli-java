package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

/**
 * PerspconModel
 */
@Type("POGRC_Perspcon")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProprietaireModel extends BaseModel {

	/**
	 * Identifiant de la liaison pconso - proprietaire
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("perspcon_id")
	private Integer id;

	/**
	 * Identifiant du point de consommation
	 */
	@JsonProperty("pconso_id")
	private Integer pconso_id;

	/**
	 * Identifiant de la personne
	 */
	@JsonProperty("personne_id")
	private Integer personne_id;

	/**
	 * Identifiant du type de personne
	 */
	@JsonProperty("typepers_id")
	private Integer typepers_id;

	/**
	 * Proprietaire actif
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Proprietaire principal
	 */
	@JsonProperty("principal")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	@JsonSerialize(using = CustomBooleanToIntSerializer.class)
	private Boolean principal;

	/**
	 * Personne
	 */
	@Relationship("personne")
	private PersonneModel personne;

	/**
	 * Constructor
	 */
	public ProprietaireModel() {
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
	 * @return PerspconModel
	 */
	public ProprietaireModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Retourne le flag actif du proprietaire
	 * 
	 * @return Boolean
	 */
	@JsonIgnore
	public Boolean getActif() {
		return this.actif;
	}

	/**
	 * Set actif
	 * 
	 * @param p_actif Actif
	 * 
	 * @return ProprietaireModel
	 */
	public ProprietaireModel setActif(Boolean p_actif) {
		this.actif = p_actif;
		return this;
	}

	/**
	 * Retourne vrai si le proprietaire est actif
	 * 
	 * @return Boolean
	 */
	public Boolean isActif() {
		return this.actif;
	}

	/**
	 * Retourne le flag principal du proprietaire
	 * 
	 * @return Boolean
	 */
	@JsonIgnore
	public Boolean getPrincipal() {
		return this.principal;
	}

	/**
	 * Set principal
	 * 
	 * @param p_principal Actif
	 * 
	 * @return ProprietaireModel
	 */
	public ProprietaireModel setPrincipal(Boolean p_principal) {
		this.actif = p_principal;
		return this;
	}

	/**
	 * Retourne vrai si le proprietaire est principal
	 * 
	 * @return Boolean
	 */
	public Boolean isPrincipal() {
		return this.principal;
	}
	
	/**
	 * Get personne
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel getPersonne() {
		return this.personne;
	}

}
