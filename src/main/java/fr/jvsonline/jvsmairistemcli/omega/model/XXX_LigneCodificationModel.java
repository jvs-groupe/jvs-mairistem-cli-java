package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * LigneCodificationModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Listeval")
@JsonIgnoreProperties(ignoreUnknown = true)
public class XXX_LigneCodificationModel extends BaseModel {

  /**
   * Identifiant de la ligne de codification
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("listeval_id")
  private Integer id;

  /**
   * Identifiant de la codification
   */
  @JsonProperty("listedef_id")
  private Integer id_codif;

  /**
   * Code de la codification
   */
  @JsonProperty("codeliste")
  private String codeListe;

  /**
   * Code
   */
  @JsonProperty("codeval")
  private String code;

  /**
   * Libellé
   */
  @JsonProperty("liblong")
  private String libelle;

  /**
   * Libellé court
   */
  @JsonProperty("libcourt")
  private String libelleCourt;

  /**
   * Constructor
   */
  public XXX_LigneCodificationModel() {
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
   * @return LigneCodificationModel
   */
  public XXX_LigneCodificationModel setId(Integer p_id) {
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
   * @return LigneCodificationModel
   */
  public XXX_LigneCodificationModel setLibelle(String p_libelle) {
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
   * @return LigneCodificationModel
   */
  public XXX_LigneCodificationModel setCode(String p_code) {
    this.code = p_code;
    return this;
  }

  /**
   * Retourne le code de la liste
   * 
   * @return String
   */
  public String getCodeListe() {
    return this.codeListe;
  }

  /**
   * Affectation du code liste
   * 
   * @param p_code Code de la liste
   * 
   * @return LigneCodificationModel
   */
  public XXX_LigneCodificationModel setCodeListe(String p_code) {
    this.codeListe = p_code;
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
   * @return LigneCodificationModel
   */
  public XXX_LigneCodificationModel setLibelleCourt(String p_libelleCourt) {
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
