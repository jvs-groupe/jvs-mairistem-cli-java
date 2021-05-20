package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * ArticleModel
 */

@Type("POGRC_Article")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.ALWAYS) //les null sont pris en compte (par défaut NON_NULL. càd les null sont ignorés.)
public class ArticleModel extends BaseModel {

	/**
	 * Identifiant de l'article
	 */
	@Id(IntegerIdHandler.class)
	@JsonIgnore
	private Integer id;

	/**
	 * Code
	 */
	@JsonProperty("codeart")
	private String code;

	/**
	 * Libellé
	 */
	@JsonProperty(value = "libart")
	private String libelle;

	/**
	 * Désignation
	 */
	@JsonProperty("design")
	private String description;

	/**
	 * Prix unitaire
	 */
	@JsonProperty("pu") // ou @JsonProperty(value = "pu", access = JsonProperty.Access.WRITE_ONLY) seulement si en sortie on veut autre chose que "pu" !  
	private Float prix_unitaire = 0f;

	/**
	 * Unité
	 */
	@JsonProperty("enum_unite")
	private String unite;

	/**
	 * Code TVA
	 */
	@JsonProperty("enum_tva")
	private String code_tva;

	/**
	 * Code tri
	 */
	@JsonProperty("codetri")
	private Integer tri;

	/**
	 * Article actif
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Constructor
	 */
	public ArticleModel() {
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
	 * @param p_value id
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setId(Integer p_value) {
		this.id = p_value;
		return this;
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
	 * @param p_value code
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setCode(String p_value) {
		this.code = p_value;
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
	 * @param p_value libelle
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setLibelle(String p_value) {
		this.libelle = p_value;
		return this;
	}

	/**
	 * Get description
	 * 
	 * @return String
	 */
	@JsonIgnore	// ou  @JsonProperty("description")
	public String getDescription() {
		return this.description;
	}

	/**
	 * Set description
	 * 
	 * @param p_value description
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setDescription(String p_value) {
		this.description = p_value;
		return this;
	}

	/**
	 * Get prix_unitaire
	 * 
	 * @return float
	 */
	@JsonIgnore	// ou @JsonProperty("pu") // ou @JsonProperty("px_un") mais il faut modifier l'accés en WRITE_ONLY au niveau du membre ! 
	public Float getPrixUnitaire() {
		return this.prix_unitaire;
	}

	/**
	 * Set prix_unitaire
	 * 
	 * @param p_value prix_unitaire
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setPrixUnitaire(Float p_value) {
		this.prix_unitaire = p_value;
		return this;
	}

	/**
	 * Get unite
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getUnite() {
		return this.unite;
	}

	/**
	 * Set unite
	 * 
	 * @param p_value unite
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setUnite(String p_value) {
		this.unite = p_value;
		return this;
	}

	/**
	 * Get code_tva
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCodeTva() {
		return this.code_tva;
	}

	/**
	 * Set code_tva
	 * 
	 * @param p_value code_tva
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setCodeTva(String p_value) {
		this.code_tva = p_value;
		return this;
	}

	/**
	 * Get tri
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getTri() {
		return this.tri;
	}

	/**
	 * Set tri
	 * 
	 * @param p_value tri
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setTri(Integer p_value) {
		this.tri = p_value;
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
	 * @param p_value actif
	 * 
	 * @return ArticleModel
	 */
	public ArticleModel setActif(Boolean p_value) {
		this.actif = p_value;
		return this;
	}
}
