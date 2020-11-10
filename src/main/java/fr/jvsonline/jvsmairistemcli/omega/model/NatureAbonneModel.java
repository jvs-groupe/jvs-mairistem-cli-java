package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Relationship;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.omega.model.PointDeConsommationModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * LigneFactureExterneModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Natabo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NatureAbonneModel extends BaseModel {
  
  /**
   * Identifiant de la ligne de facture
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("natabo_id")
  private Integer id;
  
  /**
   * Code article
   */
  @JsonProperty("codenat")
  private String code;
  
  /**
   * Libellé
   */
  @JsonProperty("libnat")
  private String libelle;
  
  /**
   * Constructeur
   */
  public NatureAbonneModel() {
  }
  
  /**
   * Affectation de l'identifiant
   * 
   * @param p_id Identifiant
   * 
   * @return NatureAbonneModel
   */
  public NatureAbonneModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Retourne l'identifiant
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getId() {
    return this.id;
  }
  
  /**
   * Affectation du code
   * 
   * @param p_code Code
   * 
   * @return NatureAbonneModel
   */
  public NatureAbonneModel setCode(String p_code) {
    this.code = p_code;
    return this;
  }
  
  /**
   * Retourne le code
   * 
   * @return String
   */
  @JsonIgnore
  public String getCode() {
    return this.code;
  }
  
  /**
   * Affectation du libellé
   * 
   * @param p_libelle Libellé
   * 
   * @return NatureAbonneModel
   */
  public NatureAbonneModel setLibelle(String p_libelle) {
    this.libelle = p_libelle;
    return this;
  }
  
  /**
   * Retourne le libellé
   * 
   * @return String
   */
  @JsonIgnore
  public String getLibelle() {
    return this.libelle;
  }
}
