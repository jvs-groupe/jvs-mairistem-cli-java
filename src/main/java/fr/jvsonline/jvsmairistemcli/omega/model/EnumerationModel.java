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
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;

/**
 * EnumerationModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Enum")
@JsonIgnoreProperties(ignoreUnknown = true)
public class EnumerationModel extends BaseModel {

  /**
   * Identifiant de l'énumération
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("enum_id")
  private Integer id;

  /**
   * Nom de l'énumération
   */
  @JsonProperty("nomenum")
  private String nom;

  /**
   * Libre
   */
  @JsonProperty("libre")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean libre;
  
  /**
   * Lignes
   */
  @Relationship("ligenums")
  private List<LigneEnumerationModel> ligenums;
  
  /**
   * Constructor
   */
  public EnumerationModel() {
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
   * @return EnumerationModel
   */
  public EnumerationModel setId(Integer p_id) {
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
   * @return EnumerationModel
   */
  public EnumerationModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }
  
  /**
   * Get libre
   * 
   * @return Boolean
   */
  public Boolean getLibre() {
    return this.libre;
  }
  
  /**
   * Set libre
   * 
   * @param p_libre Libre
   * 
   * @return EnumerationModel
   */
  public EnumerationModel setLibre(Boolean p_libre) {
    this.libre = p_libre;
    return this;
  }
  
  /**
   * Get lignes énumérations
   * 
   * @return List
   */
  public List<LigneEnumerationModel> getLignes() {
    return this.ligenums;
  }
}
