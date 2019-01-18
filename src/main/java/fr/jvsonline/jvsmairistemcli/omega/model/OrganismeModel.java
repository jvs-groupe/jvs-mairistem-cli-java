package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * OrganismeModel
 * 
 * @author jeromeklam
 * @package Organisme
 */
@Type("Partner_Organism")
public class OrganismeModel extends BaseModel {

  /**
   * Identifiant de l'organisme
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("organism_id")
  private Integer id;

  /**
   * Type d'organisme
   * 
   * @var String
   */
  @JsonProperty("enum_torg")
  private String  type;

  /**
   * Nom
   * 
   * @var String
   */
  @JsonProperty("nomlorg")
  private String  nom;

  /**
   * Code postal
   * 
   * @var String
   */
  @JsonProperty("cporg")
  private String  codePostal;
  
  /**
   * Ville
   * 
   * @var String
   */
  @JsonProperty("villeorg")
  private String  ville;
  
  /**
   * Actif
   * 
   * @var Boolean
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;

  /**
   * Constructor
   */
  public OrganismeModel() {
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
  public OrganismeModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get nom
   *
   * @return String 
   */
  public String getNom() {
    return nom;
  }

  /**
   * Set nom
   *
   * @param String p_nom
   *
   * @return OrganismeModel
   */
  public OrganismeModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }

  /**
   * Get codePostal
   *
   * @return String 
   */
  public String getCodePostal() {
    return codePostal;
  }

  /**
   * Set codePostal
   *
   * @param String p_codePostal
   *
   * @return OrganismeModel
   */
  public OrganismeModel setCodePostal(String p_codePostal) {
    this.codePostal = p_codePostal;
    return this;
  }

  /**
   * Get ville
   *
   * @return String 
   */
  public String getVille() {
    return ville;
  }

  /**
   * Set ville
   *
   * @param String p_ville
   *
   * @return OrganismeModel
   */
  public OrganismeModel setVille(String p_ville) {
    this.ville = p_ville;
    return this;
  }
}
