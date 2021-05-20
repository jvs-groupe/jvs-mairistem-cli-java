package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TourneeModel
 */
@Type("POGRC_Tournee")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TourneeModel extends BaseModel {

	/**
	 * Identifiant de la tournée
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("tournee_id")
	private Integer id;

	/**
	 * Code tournée
	 */
	@JsonProperty("codetournee")
	private String code;

	/**
	 * Libellé tournée
	 */
	@JsonProperty("libtournee")
	private String libelle;

	/**
	 * Identifiant de l'agent
	 */
	@JsonProperty("agent_id")
	private Integer id_agent;

	/**
	 * Constructor
	 */
	public TourneeModel() {
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
	 * @return TourneeModel
	 */
	public TourneeModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return Code
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Set code
	 * 
	 * @param p_code code
	 * 
	 * @return TourneeModel
	 */
	public TourneeModel setCode(String p_code) {
		this.code = p_code;
		return this;
	}

	/**
	 * Get libelle
	 * 
	 * @return String
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Set libelle
	 * 
	 * @param p_libelle libelle
	 * 
	 * @return TourneeModel
	 */
	public TourneeModel setLibelle(String p_libelle) {
		this.libelle = p_libelle;
		return this;
	}

	/**
	 * Get id_agent
	 * 
	 * @return Integer
	 */
	public Integer getIdAgent() {
		return this.id_agent;
	}

	/**
	 * Set id_agent
	 * 
	 * @param p_id_agent id_agent
	 * 
	 * @return TourneeModel
	 */
	public TourneeModel setIdAgent(Integer p_id_agent) {
		this.id_agent = p_id_agent;
		return this;
	}
}
