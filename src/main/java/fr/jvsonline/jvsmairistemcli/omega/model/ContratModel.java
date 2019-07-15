package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

/**
 * Contrats
 * 
 * @author jeromeklam
 */
@Type("Partner_Contrat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContratModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant du contrat
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("contrat_id")
  private Integer id;

  /**
   * Identifiant du point de consommation
   */
  @JsonProperty("pconso_id")
  private Integer id_pconso;
  
  /**
   * Numéro de contrat
   */
  @JsonProperty("numcontrat")
  private String  numeroContrat;

  /**
   * Contrat actif
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;
  
  /**
   * Contrat suspendu
   */
  @JsonProperty("suspendu")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean suspendu;
  
  /**
   * Type de contrat
   */
  @JsonProperty("enum_tcon")
  private String  typeContrat;

  /**
   * Nature de contrat
   */
  @JsonProperty("enum_natcont")
  private String  natureContrat;
  
  /**
   * Sous-type de contrat
   */
  @JsonProperty("enum_stcont")
  private String  sousTypeContrat;
  
  /**
   * Date de début
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("datedeb")
  private Date    dateDebut;

  /**
   * Date de fin
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("datefin")
  private Date    dateFin;

  /**
   * Identifiant de la nature d'abonné
   */
  @JsonProperty("natabo_id")
  private Integer id_natureAbonne;
  
  /**
   * Contrat principal
   */
  @JsonProperty("principal")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean principal;
  
  /**
   * Point de consommation
   */
  @Relationship("pconso")
  private PointDeConsommationModel pointDeConsommation;
  
  /**
   * Occupant
   */
  @Relationship("occupant")
  private PersonneModel occupant;
  
  /**
   * Redevable
   */
  @Relationship("redevable")
  private PersonneModel redevable;
  
  /**
   * Propriétaire
   */
  @Relationship("proprietaire")
  private PersonneModel proprietaire;
  
  /**
   * Constructor
   */
  public ContratModel() {
  }

  /**
   * Get identifiant
   * 
   * @return Integer
   */
  public Integer getId() {
    return this.id;
  }

  /**
   * Set Identifiant
   * 
   * @param p_id Identifiant
   * 
   * @return ContratModel
   */
  public ContratModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Retourne le numéro de contrat
   * 
   * @return String
   */
  public String getNumero() {
    return this.numeroContrat;
  }
  
  /**
   * Retourne le flag actif su contrat
   * 
   * @return Boolean
   */
  public Boolean getActif() {
    return this.actif;
  }
  
  /**
   * Retourne vrai si le contrat est actif
   * 
   * @return Boolean
   */
  public Boolean isActif() {
    return this.actif;
  }
  
  /**
   * Get occupant
   * 
   * @return PersonneModel
   */
  public PersonneModel getOccupant() {
    return this.occupant;
  }
  
  /**
   * Get redevable
   * 
   * @return PersonneModel
   */
  public PersonneModel getRedevable() {
    return this.redevable;
  }
  
  /**
   * Get propriétaire
   * 
   * @return PersonneModel
   */
  public PersonneModel getProprietaire() {
    return this.proprietaire;
  }
}
