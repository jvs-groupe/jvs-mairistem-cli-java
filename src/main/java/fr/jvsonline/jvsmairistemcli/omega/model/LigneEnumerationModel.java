package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LigneEnumerationModel
 * 
 * @author jeromeklam
 * @package Enumeration
 */
@Type("Partner_Ligenum")
public class LigneEnumerationModel {

  /**
   * Identifiant de la ligne d'énumération
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("ligenum_id")
  private Integer id;
  
  /**
   * Identifiant de l'énumération
   * 
   * @var Integer
   */
  @JsonProperty("enum_id")
  private Integer id_enum;

  /**
   * Code
   * 
   * @var String
   */
  @JsonProperty("codeenum")
  private String code;

  /**
   * Libellé
   * 
   * @var String
   */
  @JsonProperty("liblenum")
  private String libelle;
  
  /**
   * Libellé court
   * 
   * @var String
   */
  @JsonProperty("libcenum")
  private String libelleCourt;
  
  /**
   * Code lié
   * 
   * @var String
   */
  @JsonProperty("codelie")
  private String codeLie;
  
  /**
   * Constructor
   */
  public LigneEnumerationModel() {
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
   * @return LigneEnumerationModel
   */
  public LigneEnumerationModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get libellé
   * 
   * @return String
   */
  public String getLibelle() {
    return this.libelle;
  }

  /**
   * Set libellé
   * 
   * @param String p_libelle
   * 
   * @return LigneEnumerationModel
   */
  public LigneEnumerationModel setLibelle(String p_libelle) {
    this.libelle = p_libelle;
    return this;
  }
  
  /**
   * Get code
   * 
   * @return String
   */
  public String getCode() {
    return this.code;
  }
  
  /**
   * Set code
   * 
   * @param String p_code
   * 
   * @return LigneEnumerationModel
   */
  public LigneEnumerationModel setLibre(String p_code) {
    this.code = p_code;
    return this;
  }
  
  /**
   * Get libellé court
   * 
   * @return String
   */
  public String getLibelleCourt() {
    return this.libelleCourt;
  }
  
  /**
   * Set libellé court
   * 
   * @param String p_libelleCourt
   * 
   * @return LigneEnumerationModel
   */
  public LigneEnumerationModel setLibelleCourt(String p_libelleCourt) {
    this.libelleCourt = p_libelleCourt;
    return this;
  }
  
  /**
   * To string
   * 
   * @return String
   */
  @Override
  public String toString() {
    return this.libelle;
  }
}
