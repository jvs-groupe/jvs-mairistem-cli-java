package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LigneEnumerationModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Ligenum")
@JsonIgnoreProperties(ignoreUnknown = true)
public class XXX_LigneEnumerationModel extends BaseModel {

  /**
   * Identifiant de la ligne d'énumération
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("ligenum_id")
  private Integer id;
  
  /**
   * Identifiant de l'énumération
   */
  @JsonProperty("enum_id")
  private Integer id_enum;

  /**
   * Code
   */
  @JsonProperty("codeenum")
  private String code;

  /**
   * Libellé
   */
  @JsonProperty("liblenum")
  private String libelle;
  
  /**
   * Libellé court
   */
  @JsonProperty("libcenum")
  private String libelleCourt;
  
  /**
   * Code lié
   */
  @JsonProperty("codelie")
  private String codeLie;
  
  /**
   * Constructor
   */
  public XXX_LigneEnumerationModel() {
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
   * @return LigneEnumerationModel
   */
  public XXX_LigneEnumerationModel setId(Integer p_id) {
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
   * @param p_libelle Libellé
   * 
   * @return LigneEnumerationModel
   */
  public XXX_LigneEnumerationModel setLibelle(String p_libelle) {
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
   * @param p_code Code
   * 
   * @return LigneEnumerationModel
   */
  public XXX_LigneEnumerationModel setCode(String p_code) {
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
   * @param p_libelleCourt Libellé court
   * 
   * @return LigneEnumerationModel
   */
  public XXX_LigneEnumerationModel setLibelleCourt(String p_libelleCourt) {
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
