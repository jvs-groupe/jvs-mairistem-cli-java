package fr.jvsonline.jvsmairistemcli.omega.model;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

/**
 * MessageModel
 */
@Type("POGRC_Message")
@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageModel extends BaseModel {

	/**
	 * Identifiant du message
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("message_id")
	private Integer id;

	/**
	 * Thème
	 */
	@JsonProperty("theme")
	private String theme;

	/**
	 * Identifiant de l'objet dans le thème
	 */
	@JsonProperty("any_id")
	private Integer id_objet;

	/**
	 * Titre
	 */
	@JsonProperty("titremsg")
	private String titre;

	/**
	 * Contenu
	 */
	@JsonProperty("corpsmsg")
	private String message;

	/**
	 * Date de début de diffusion
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("ddebdiff")
	private Date date_debut;

	/**
	 * Date de fin de diffusion
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("dfindiff")
	private Date date_fin;

	/**
	 * Résumé (256 characters)
	 */
	@JsonProperty("resumsg")
	private String resume;

	/**
	 * Résumé court (100 characters)
	 */
	@JsonProperty("shortmsg")
	private String resume_court;

	/**
	 * Constructor
	 */
	public MessageModel() {
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
	 * @return MessageModel
	 */
	public MessageModel setMessage_id(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get theme
	 * 
	 * @return String
	 */
	public String getTheme() {
		return this.theme;
	}

	/**
	 * Set theme
	 * 
	 * @param p_theme theme
	 * 
	 * @return MessageModel
	 */
	public MessageModel setTheme(String p_theme) {
		this.theme = p_theme;
		return this;
	}

	/**
	 * Get id_objet
	 * 
	 * @return Integer
	 */
	public Integer getIdObjet() {
		return this.id_objet;
	}

	/**
	 * Set id_objet
	 * 
	 * @param p_id_objet id_objet
	 * 
	 * @return MessageModel
	 */
	public MessageModel setAny_id(Integer p_id_objet) {
		this.id_objet = p_id_objet;
		return this;
	}

	/**
	 * Get titre
	 * 
	 * @return String
	 */
	public String getTitre() {
		return this.titre;
	}

	/**
	 * Set titre
	 * 
	 * @param p_titre titre
	 * 
	 * @return MessageModel
	 */
	public MessageModel setTitre(String p_titre) {
		this.titre = p_titre;
		return this;
	}

	/**
	 * Get message
	 * 
	 * @return String
	 */
	public String getMessage() {
		return this.message;
	}

	/**
	 * Set message
	 * 
	 * @param p_message message
	 * 
	 * @return MessageModel
	 */
	public MessageModel setCorpsmsg(String p_message) {
		this.message = p_message;
		return this;
	}

	/**
	 * Get date_debut
	 * 
	 * @return Date
	 */
	public Date getDateDebut() {
		return this.date_debut;
	}

	/**
	 * Set date_debut
	 * 
	 * @param p_date_debut date_debut
	 * 
	 * @return MessageModel
	 */
	public MessageModel setDateDebut(Date p_date_debut) {
		this.date_debut = p_date_debut;
		return this;
	}

	/**
	 * Get date_fin
	 * 
	 * @return Date
	 */
	public Date getDateFin() {
		return this.date_fin;
	}

	/**
	 * Set date_fin
	 * 
	 * @param p_date_fin date_fin
	 * 
	 * @return MessageModel
	 */
	public MessageModel setDfindiff(Date p_date_fin) {
		this.date_fin = p_date_fin;
		return this;
	}

	/**
	 * Get resume
	 * 
	 * @return String
	 */
	public String getResume() {
		return this.resume;
	}

	/**
	 * Set resume
	 * 
	 * @param p_resume resume
	 * 
	 * @return MessageModel
	 */
	public MessageModel setResuMsg(String p_resume) {
		this.resume = p_resume;
		return this;
	}

	/**
	 * Get resume_court
	 * 
	 * @return String
	 */
	public String getResumeCourt() {
		return this.resume_court;
	}

	/**
	 * Set resume_court
	 * 
	 * @param p_resume_court resume_court
	 * 
	 * @return MessageModel
	 */
	public MessageModel setResumeCourt(String p_resume_court) {
		this.resume_court = p_resume_court;
		return this;
	}
}
