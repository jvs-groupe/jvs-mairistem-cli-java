package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.model.AdresseModel;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeModel;

/**
 * AdresseDesserteModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Pdessadr")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdresseDesserteModel extends BaseModel implements BaseModelInterface {

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
  private String numeroVoie;

  /**
   * Complément du numéro de voie
   */
  @JsonProperty("cpltnumvoi")
  private String complementNumeroVoie;
  
  /**
   * Complément du nom de voie
   */
  @JsonProperty("cpltnomvoi")
  private String complementNomVoie;

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
   * Get identifiant de la voie
   * 
   * @return Integer
   */
  public Integer getIdVoie() {
    return this.id_voie;
  }

  /**
   * Set identifiant de la voie
   * 
   * @param p_idVoie Identifiant de la voie
   * 
   * @return AdresseDesserteModel
   */
  public AdresseDesserteModel setIdVoie(Integer p_idVoie) {
    this.id_voie = p_idVoie;
    return this;
  }

  /**
   * Get numero de voie
   * 
   * @return String
   */
  public String getNumeroVoie() {
    if (this.numeroVoie != null) {
      return this.numeroVoie;
    }
    return "";
  }

  /**
   * Set numero de voie
   * 
   * @param p_numeroVoie Numéro de la voie
   * 
   * @return AdresseDesserteModel
   */
  public AdresseDesserteModel setNumeroVoie(String p_numeroVoie) {
    this.numeroVoie = p_numeroVoie;
    return this;
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
   * Get complement numero
   * 
   * @return String
   */
  public String getComplementNumeroVoie() {
    if (this.complementNumeroVoie!= null) {
      return this.complementNumeroVoie;
    }
    return "";
  }
  
  /**
   * Get complement nom
   * 
   * @return String
   */
  public String getComplementNomVoie() {
    if (this.complementNomVoie!= null) {
      return this.complementNomVoie;
    }
    return "";
  }
  
  /**
   * Get nom voie
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
   * Get code voie
   * 
   * @return String
   */
  public String getCodeVoie() {
    if (this.voie != null) {
      return this.voie.getNom();
    }
    return "";
  }

  /**
   * Get code postal
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
   * Get nom ville
   * 
   * @return String
   */
  public String getNomVille() {
    if (this.voie != null) {
      OrganismeModel commune = this.voie.getCommune();
      if (commune != null) {
        return commune.getNom();
      }
    }
    return "";
  }
}
