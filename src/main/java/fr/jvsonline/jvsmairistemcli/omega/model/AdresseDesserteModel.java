package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * AdresseDesserteModel
 */
@Type("POGRC_Pdessadr")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdresseDesserteModel extends BaseModel {

	/**
	 * Identifiant de l'adresse de desserte
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("pdessadr_id")
	private Integer id;

	/**
	 * Identifiant de la voie
	 */
	@JsonProperty("voie_id")
	private Integer id_voie;

	/**
	 * Numéro de voie
	 */
	@JsonProperty("numvoirie")
	private String numero_voie;

	/**
	 * Complément du numéro de voie
	 */
	@JsonProperty("cpltnumvoi")
	private String complement_numero_voie;

	/**
	 * Voie
	 */
	@Relationship("voie")
	private VoieModel voie;

	/**
	 * Constructor
	 */
	public AdresseDesserteModel() {
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
	 * @return AdresseDesserteModel
	 */
	public AdresseDesserteModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get id_voie
	 * 
	 * @return Integer
	 */
	public Integer getIdVoie() {
		return this.id_voie;
	}

	/**
	 * Set id_voie
	 * 
	 * @param p_id_voie id_voie
	 * 
	 * @return AdresseDesserteModel
	 */
	public AdresseDesserteModel setIdVoie(Integer p_id_voie) {
		this.id_voie = p_id_voie;
		return this;
	}

	/**
	 * Get numero_voie
	 * 
	 * @return String
	 */
	public String getNumeroVoie() {
		if (this.numero_voie != null) {
			return this.numero_voie;
		}
		return "";
	}

	/**
	 * Set numero_voie
	 * 
	 * @param p_numero_voie numero_voie
	 * 
	 * @return AdresseDesserteModel
	 */
	public AdresseDesserteModel setNumeroVoie(String p_numero_voie) {
		this.numero_voie = p_numero_voie;
		return this;
	}

	/**
	 * Get complement_numero_voie
	 * 
	 * @return String
	 */
	public String getComplementNumeroVoie() {
		if (this.complement_numero_voie != null) {
			return this.complement_numero_voie;
		}
		return "";
	}

	/**
	 * Get voie
	 * 
	 * @return VoieModel
	 */
	public VoieModel getVoie() {
		return this.voie;
	}

	/**
	 * Get nom of voie
	 * 
	 * @return String
	 */
	public String getNomVoie() {
		if (this.voie != null) {
			return this.voie.getNom();
		}
		return "";
	}

	/**
	 * Get code of voie
	 * 
	 * @return String
	 */
	public String getCodeVoie() {
		if (this.voie != null) {
			return this.voie.getCode();
		}
		return "";
	}

	/**
	 * Get code postal commune of voie
	 * 
	 * @return String
	 */
	public String getCodePostalVille() {
		if (this.voie != null) {
			OrganismeModel commune = this.voie.getCommune();
			if (commune != null) {
				return commune.getCodePostal();
			}
		}
		return "";
	}

	/**
	 * Get ville commune of voie
	 * 
	 * @return String
	 */
	public String getNomVille() {
		if (this.voie != null) {
			OrganismeModel commune = this.voie.getCommune();
			if (commune != null) {
				return commune.getVille();
			}
		}
		return "";
	}
}
