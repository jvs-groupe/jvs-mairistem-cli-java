package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.model.AdresseModel;

/**
 * AdresseDesserteModel
 * 
 * @author jeromeklam
 * @package AdresseDesserte
 */
@Type("Partner_Pdessadr")
public class AdresseDesserteModel extends BaseModel {

  /**
   * Identifiant de l'adresse de desserte
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("pdessadr_id")
  private Integer id;

  /**
   * Identifiant de la voie
   * 
   * @var Integer
   */
  @JsonProperty("voie_id")
  private Integer id_voie;

  /**
   * Numéro de voie
   * 
   * @var String
   */
  @JsonProperty("numvoirie")
  private String numeroVoie;

  /**
   * Complément du numéro de voie
   * 
   * @var String
   */
  @JsonProperty("cpltnumvoi")
  private String complementNumeroVoie;
  
  /**
   * Voie
   * 
   * @var VoieModel
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
   * @param Integer p_id
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
   * @param Integer p_idVoie
   * 
   * @return AdresseDesserteModel
   */
  public AdresseDesserteModel setIdVoie(Integer p_idVoie) {
    this.id_voie = p_idVoie;
    return this;
  }
  
  /**
   * Get numéro de voie
   * 
   * @return String
   */
  public String getNumeroVoie() {
    return this.numeroVoie;
  }
  
  /**
   * Set numéro de voie
   * 
   * @param String p_numeroVoie
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
}
