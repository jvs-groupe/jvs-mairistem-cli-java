package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.List;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneCodificationModel;

/**
 * CodificationModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Listedef")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodificationModel extends BaseModel {

  /**
   * Identifiant de l'énumération
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("listedef_id")
  private Integer id;

  /**
   * Nom de l'énumération
   */
  @JsonProperty("libliste")
  private String nom;

  /**
   * Code de la liste
   */
  @JsonProperty("codeliste")
  private String codeListe;

  /**
   * Type de liste
   */
  @JsonProperty("typeliste")
  private String typeListe;

  /**
   * Lignes
   */
  @Relationship("listevals")
  private List<LigneCodificationModel> listevals;

  /**
   * Constructor
   */
  public CodificationModel() {
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
   * @return CodificationModel
   */
  public CodificationModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get nom
   * 
   * @return String
   */
  public String getNom() {
    return this.nom;
  }

  /**
   * Set nom
   * 
   * @param p_nom Nom
   * 
   * @return CodificationModel
   */
  public CodificationModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }

  /**
   * Retourne le type de liste
   * 
   * @return String
   */
  public String getTypeListe() {
    return this.typeListe;
  }

  /**
   * Affecte le type de liste
   * 
   * @param p_type Type de la liste
   * 
   * @return CodificationModel
   */
  public CodificationModel setTypeListe(String p_type) {
    this.typeListe = p_type;
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
   * Affectation du code de la liste
   * 
   * @param p_code Code de la liste
   * 
   * @return CodificationModel
   */
  public CodificationModel setCodeListe(String p_code) {
    this.codeListe = p_code;
    return this;
  }

  /**
   * Get lignes codification
   * 
   * @return List
   */
  public List<LigneCodificationModel> getLignes() {
    return this.listevals;
  }
}
