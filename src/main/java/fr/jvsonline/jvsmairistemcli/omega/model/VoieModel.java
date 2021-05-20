package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * VoieModel
 */
@Type("POGRC_Voie")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VoieModel extends BaseModel {

	/**
	 * Identifiant de la voie
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("voie_id")
	private Integer id;

	/**
	 * Identifiant de l'organisme
	 */
	@JsonProperty("organism_id")
	private Integer id_organism;

	/**
	 * Identifiant du quartier
	 */
	@JsonProperty("quartier_id")
	private Integer id_quartier;

	/**
	 * Code de la voie
	 */
	@JsonProperty("codevoie")
	private String code;

	/**
	 * Type de la voie
	 */
	@JsonProperty("typevoie")
	private String type;

	/**
	 * Article de la voie
	 */
	@JsonProperty("artvoie")
	private String article;

	/**
	 * Nom de la voie
	 */
	@JsonProperty("nomvoie")
	private String nom;

	/**
	 * Coordoonées SIG
	 */
	@JsonProperty("sigcoord")
	private String coordonnee_sig;

	/**
	 * Id admin
	 */
	@JsonProperty("idadmin")
	private String admin;

	/**
	 * Voie active
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Commune
	 */
	@Relationship("commune")
	private CommuneModel commune;

	/**
	 * Constructor
	 */
	public VoieModel() {
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
	 * @return VoieModel
	 */
	public VoieModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get id_organism
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getIdOrganisme() {
		return this.id_organism;
	}

	/**
	 * Set id_organism
	 * 
	 * @param p_id_organism id_organism 
	 * 
	 * @return VoieModel
	 */
	public VoieModel setIdOrganism(Integer p_id_organism) {
		this.id_organism = p_id_organism;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCode() {
		if (this.code != null) {
			return this.code;
		}
		return "";
	}

	/**
	 * Set code
	 * 
	 * @param p_code code
	 * 
	 * @return VoieModel
	 */
	public VoieModel setCode(String p_code) {
		this.code = p_code;
		return this;
	}

	/**
	 * Get type
	 *
	 * @return String
	 */
	@JsonIgnore
	public String getType() {
		if (this.type != null) {
			return this.type;
		}
		return "";
	}

	/**
	 * Set type
	 *
	 * @param p_type type
	 *
	 * @return VoieModel
	 */
	public VoieModel setType(String p_type) {
		this.type = p_type;
		return this;
	}

	/**
	 * Get article
	 *
	 * @return String
	 */
	@JsonIgnore
	public String getArticle() {
		if (this.article != null) {
			return this.article;
		}
		return "";
	}

	/**
	 * Set article
	 *
	 * @param p_article article
	 *
	 * @return VoieModel
	 */
	public VoieModel setArticle(String p_article) {
		this.article = p_article;
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
	 * @return VoieModel
	 */
	public VoieModel setNom(String p_nom) {
		this.nom = p_nom;
		return this;
	}

	/**
	 * Get coordonnee_sig
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCoordonneeSig() {
		return this.coordonnee_sig;
	}

	/**
	 * Set coordonnee_sig
	 * 
	 * @param p_coordonnee_sig coordonnee_sig
	 * 
	 * @return VoieModel
	 */
	public VoieModel setCoordonneeSig(String p_coordonnee_sig) {
		this.coordonnee_sig = p_coordonnee_sig;
		return this;
	}

	/**
	 * Get Latitude
	 * 
	 * @return Double
	 */
	public Double getLatitude() {
		return this.getWhichCoordonneeSig(0);
	}

	/**
	 * Get Longitude
	 * 
	 * @return Double
	 */
	public Double getLongitude() {
		return this.getWhichCoordonneeSig(1);
	}

	/**
	 * Get which coordonnees sig ?
	 * 
	 * @return Double
	 */
	public Double getAltitude() {
		return this.getWhichCoordonneeSig(2);
	}

	/**
	 * Get Altitude
	 * 
	 * @return Double
	 */
	private double getWhichCoordonneeSig(int p_parts) {
		Double db = 0.0;

		try {
			String[] parts = this.coordonnee_sig.split("\\|", 3);
			if (parts.length == 3) {
				db = Double.parseDouble(parts[p_parts]);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return db;
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
	 * @return VoieModel
	 */
	public VoieModel setActif(Boolean p_actif) {
		this.actif = p_actif;
		return this;
	}

	/**
	 * Get commune
	 * 
	 * @return OrganismeModel
	 */
	@JsonIgnore
	public CommuneModel getCommune() {
		return this.commune;
	}
}
