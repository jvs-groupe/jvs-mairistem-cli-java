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
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("message_id")
  private Integer id;

  /**
   * Thème
   * 
   * @var String
   */
  @JsonProperty("theme")
  private String  theme;

  /**
   * Identifiant de l'objet dans le thème
   * 
   * @var Integer
   */
  @JsonProperty("any_id")
  private Integer id_objet;

  /**
   * Titre
   * 
   * @var String
   */
  @JsonProperty("titremsg")
  private String  titre;

  /**
   * Contenu
   * 
   * @var String
   */
  @JsonProperty("corpsmsg")
  private String  message;

  /**
   * Date de début de diffusion
   * 
   * @var Date
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("ddebdiff")
  private Date    dateDebut;

  /**
   * Date de fin de diffusion
   * 
   * @var Date
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("dfindiff")
  private Date    dateFin;

  /**
   * Résumé (256 characters)
   * 
   * @var String
   */
  @JsonProperty("resumsg")
  private String  resume;

  /**
   * Résumé court (100 characters)
   * 
   * @var String
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
   * @param Integer p_id
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
   * @param String p_theme
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
   * @param Integer p_idObjet
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
   * @param String p_titre
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
   * @param corpsmsg p_message
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
   * @param Date p_dateDebut
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
   * @param Date p_dateFin
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
   * @param String p_resume
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
   * @param String
   * 
   * @return MessageModel
   */
  public MessageModel setResumeCourt(String p_resumeCourt) {
    this.resumeCourt = p_resumeCourt;
    return this;
  }
}
