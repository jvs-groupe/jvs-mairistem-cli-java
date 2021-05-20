package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * NatureAbonneModel
 */
@Type("POGRC_Natabo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NatureAbonneModel extends BaseModel {

	/**
	 * Identifiant de la ligne de facture
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("natabo_id")
	private Integer id;

	/**
	 * Code article
	 */
	@JsonProperty("codenat")
	private String code;

	/**
	 * Libellé
	 */
	@JsonProperty("libnat")
	private String libelle;

	/**
	 * Constructeur
	 */
	public NatureAbonneModel() {
	}

	/**
	 * Set id
	 * 
	 * @param p_id id
	 * 
	 * @return NatureAbonneModel
	 */
	public NatureAbonneModel setId(Integer p_id) {
		this.id = p_id;
		return this;
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
	 * Get code
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCode() {
		return this.code;
	}

	/**
	 * Set code
	 * 
	 * @param p_code Code
	 * 
	 * @return NatureAbonneModel
	 */
	public NatureAbonneModel setCode(String p_code) {
		this.code = p_code;
		return this;
	}

	/**
	 * Get libelle
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Set libelle
	 * 
	 * @param p_libelle libelle
	 * 
	 * @return NatureAbonneModel
	 */
	public NatureAbonneModel setLibelle(String p_libelle) {
		this.libelle = p_libelle;
		return this;
	}
}
