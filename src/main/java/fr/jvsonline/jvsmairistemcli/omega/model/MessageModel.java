package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

/**
 * Message
 *
 */
@Type("Partner_Message")
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
  private String  theme;

  /**
   * Identifiant de l'objet dans le thème
   */
  @JsonProperty("any_id")
  private Integer id_objet;

  /**
   * Titre
   */
  @JsonProperty("titremsg")
  private String  titre;

  /**
   * Contenu
   */
  @JsonProperty("corpsmsg")
  private String  message;

  /**
   * Date de début de diffusion
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("ddebdiff")
  private Date    dateDebut;

  /**
   * Date de fin de diffusion
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("dfindiff")
  private Date    dateFin;

  /**
   * Résumé (256 characters)
   */
  @JsonProperty("resumsg")
  private String  resume;

  /**
   * Résumé court (100 characters)
   */
  @JsonProperty("shortmsg")
  private String  resumeCourt;

  /**
   * Constructor
   */
  public MessageModel() {
  }

  /**
   * Get identifiant
   * 
   * @return Integer
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Set Identifiant
   * 
   * @param p_id Identifiant
   * 
   * @return MessageModel
   */
  public MessageModel setMessage_id(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get thème
   * 
   * @return String
   */
  public String getTheme() {
    return this.theme;
  }

  /**
   * Set theme
   * 
   * @param p_theme Thème
   * 
   * @return MessageModel
   */
  public MessageModel setTheme(String p_theme) {
    this.theme = p_theme;
    return this;
  }

  /**
   * Get identifiant objet
   * 
   * @return Integer
   */
  public Integer getIdObjet() {
    return this.id_objet;
  }

  /**
   * Set identifiant objet
   * 
   * @param p_idObjet Identifiant de l'objet
   * 
   * @return MessageModel
   */
  public MessageModel setAny_id(Integer p_idObjet) {
    this.id_objet = p_idObjet;
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
   * @param p_titre Titre
   * 
   * @return MessageModel
   */
  public MessageModel setTitre(String p_titre) {
    this.titre = p_titre;
    return this;
  }

  /**
   * Get contenu
   * 
   * @return String
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * Set message
   * 
   * @param p_message Message
   * 
   * @return MessageModel
   */
  public MessageModel setCorpsmsg(String p_message) {
    this.message = p_message;
    return this;
  }

  /**
   * Get date début diffusion
   * 
   * @return Date
   */
  public Date getDateDebut() {
    return this.dateDebut;
  }

  /**
   * Set date début de diffusion
   * 
   * @param p_dateDebut Date de début
   * 
   * @return MessageModel
   */
  public MessageModel setDateDebut(Date p_dateDebut) {
    this.dateDebut = p_dateDebut;
    return this;
  }

  /**
   * Get date fin de diffusion
   * 
   * @return Date
   */
  public Date getDateFin() {
    return this.dateFin;
  }

  /**
   * Set date fin de diffusion
   * 
   * @param p_dateFin Date de fin
   * 
   * @return MessageModel
   */
  public MessageModel setDfindiff(Date p_dateFin) {
    this.dateFin = p_dateFin;
    return this;
  }

  /**
   * Get résumé
   * 
   * @return String
   */
  public String getResume() {
    return this.resume;
  }

  /**
   * Set résumé
   * 
   * @param p_resume Résumé
   * 
   * @return MessageModel
   */
  public MessageModel setResuMsg(String p_resume) {
    this.resume = p_resume;
    return this;
  }

  /**
   * Get résumé court
   * 
   * @return String
   */
  public String getResumeCourt() {
    return this.resumeCourt;
  }

  /**
   * Set résumé court
   * 
   * @param p_resumeCourt Résumé court
   * 
   * @return MessageModel
   */
  public MessageModel setResumeCourt(String p_resumeCourt) {
    this.resumeCourt = p_resumeCourt;
    return this;
  }
}
