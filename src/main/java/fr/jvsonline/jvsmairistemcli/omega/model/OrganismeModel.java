package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * OrganismeModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Organism")
public class OrganismeModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant de l'organisme
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("organism_id")
  private Integer id;

  /**
   * Type d'organisme
   */
  @JsonProperty("enum_torg")
  private String  type;

  /**
   * Nom
   */
  @JsonProperty("nomlorg")
  private String  nom;

  /**
   * Code postal
   */
  @JsonProperty("cporg")
  private String  codePostal;
  
  /**
   * Ville
   */
  @JsonProperty("villeorg")
  private String  ville;
  
  /**
   * Actif
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
  @JsonIgnore
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
  public OrganismeModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get nom
   *
   * @return String 
   */
  @JsonIgnore
  public String getNom() {
    if (this.nom != null) {
      return this.nom;
    }
    return "";
  }

  /**
   * Set nom
   *
   * @param p_nom Nom
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
  @JsonIgnore
  public String getCodePostal() {
    if (this.codePostal != null) {
      return this.codePostal;
    }
    return "";
  }

  /**
   * Set codePostal
   *
   * @param p_codePostal Code postal
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
  @JsonIgnore
  public String getVille() {
    if (this.ville != null) {
      return this.ville;
    }
    return "";
  }

  /**
   * Set ville
   *
   * @param p_ville Ville
   *
   * @return OrganismeModel
   */
  public OrganismeModel setVille(String p_ville) {
    this.ville = p_ville;
    return this;
  }
}
