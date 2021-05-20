package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * EnumerateModel
 * 
 */
@Type("POGRC_Enumerate")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnumerateModel extends BaseModel {

	/**
	 * Identifiant de l'énumération
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("enum_id")
	private Integer id;

	/**
	 * Nom de l'énumération
	 * <br/><b>ex:</b> { <b>'CIV'</b> 'Mr' 'Mr.' 'Monsieur'}
	 */
	@JsonProperty("code")
	private String code_liste;

	/**
	 * Code de l'énumération
	 * <br/><b>ex:</b> { 'CIV' <b>'Mr'</b> 'Mr.' 'Monsieur'}
	 */
	@JsonProperty("codeenum")
	private String code; // oui on a bien mis code !!!

	/**
	 * Description courte
	 * <br/><b>ex:</b> { 'CIV' 'Mr' <b>'Mr.'</b> 'Monsieur'}
	 */
	@JsonProperty("libcenum")
	private String libelle_court;

	/**
	 * Description longue
	 * <br/><b>ex:</b> { 'CIV' 'Mr' 'Mr.' <b>'Monsieur'</b>}
	 */
	@JsonProperty("liblenum")
	private String libelle;

	/**
	 * Constructor
	 */
	public EnumerateModel() {
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
	 * @return EnumerationModel
	 */
	public EnumerateModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get code_liste
	 * 
	 * @return String
	 */
	public String getCodeListe() {
		return this.code_liste;
	}

	/**
	 * Set code_liste
	 * 
	 * @param p_valeur code_liste
	 * 
	 * @return EnumerationModel
	 */
	public EnumerateModel setCodeListe(String p_valeur) {
		this.code_liste = p_valeur;
		return this;
	}

	/**
	 * Get code
	 * 
	 * @return String
	 */
	public String getCode() { // il s'agit du codeenum
		return this.code;
	}

	/**
	 * Get libelle_court
	 * 
	 * @return String
	 */
	public String getLibelleCourt() {
		return this.libelle_court;
	}

	/**
	 * Get libelle
	 * 
	 * @return String
	 */
	public String getLibelle() {
		return this.libelle;
	}
}
