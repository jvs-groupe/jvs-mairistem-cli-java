package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonProperty;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.model.AdresseModel;

/**
 * AdresseDesserteModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Pdessadr")
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
}
