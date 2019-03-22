package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;

import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * CompteurModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Compteur")
public class CompteurModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant du compteur
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("compteur_id")
  private Integer id;

  /**
   * Numéro de série
   */
  @JsonProperty("numserie")
  private String numeroSerie;
  
  /**
   * Marque
   */
  @JsonProperty("enum_marq")
  private String marque;
  
  /**
   * Diamètre
   */
  @JsonProperty("enum_diam")
  private String diametre;
  
  /**
   * Calibre
   */
  @JsonProperty("enum_calib")
  private String calibre;
  
  /**
   * Constructor
   */
  public CompteurModel() {
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
   * @return CompteurModel
   */
  public CompteurModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get numéro série
   * 
   * @return String
   */
  public String getNumeroSerie() {
    return this.numeroSerie;
  }

  /**
   * Set numéro de série
   * 
   * @param p_numeroSerie Numéro de série
   * 
   * @return CompteurModel
   */
  public CompteurModel setNumeroSerie(String p_numeroSerie) {
    this.numeroSerie = p_numeroSerie;
    return this;
  }

  /**
   * Get marque
   * 
   * @return String
   */
  public String getMarque() {
    return this.marque;
  }

  /**
   * Set marque
   * 
   * @param p_marque Marque
   * 
   * @return CompteurModel
   */
  public CompteurModel setMarque(String p_marque) {
    this.marque = p_marque;
    return this;
  }

  /**
   * Get diamètre
   * 
   * @return String
   */
  public String getDiametre() {
    return this.diametre;
  }

  /**
   * Set diamètre
   * 
   * @param p_diametre Diamètre
   * 
   * @return CompteurModel
   */
  public CompteurModel setDiametre(String p_diametre) {
    this.diametre = p_diametre;
    return this;
  }

  /**
   * Get calibre
   * 
   * @return String
   */
  public String getCalibre() {
    return this.calibre;
  }

  /**
   * Set calibre
   * 
   * @param p_calibre Calibre
   * 
   * @return CompteurModel
   */
  public CompteurModel setCalibre(String p_calibre) {
    this.calibre = p_calibre;
    return this;
  }
}
