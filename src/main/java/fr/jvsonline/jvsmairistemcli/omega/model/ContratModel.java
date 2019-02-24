package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class ContratModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant du contrat
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("contrat_id")
  private Integer id;

  /**
   * Identifiant du point de consommation
   * 
   * @var Integer
   */
  @JsonProperty("pconso_id")
  private Integer id_pconso;
  
  /**
   * Numéro de contrat
   * 
   * @var String
   */
  @JsonProperty("numcontrat")
  private String  numeroContrat;

  /**
   * Contrat actif
   * 
   * @var Boolean
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;
  
  /**
   * Contrat suspendu
   * 
   * @var Boolean
   */
  @JsonProperty("suspendu")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean suspendu;
  
  /**
   * Type de contrat
   * 
   * @var String
   */
  @JsonProperty("enum_tcon")
  private String  typeContrat;

  /**
   * Nature de contrat
   * 
   * @var String
   */
  @JsonProperty("enum_natcont")
  private String  natureContrat;
  
  /**
   * Sous-type de contrat
   * 
   * @var String
   */
  @JsonProperty("enum_stcont")
  private String  sousTypeContrat;
  
  /**
   * Date de début
   * 
   * @var Date
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("datedeb")
  private Date    dateDebut;

  /**
   * Date de fin
   * 
   * @var Date
   */
  @JsonDeserialize(using = CustomDateDeserializer.class)
  @JsonProperty("datefin")
  private Date    dateFin;

  /**
   * Identifiant de la nature d'abonné
   * 
   * @var Integer
   */
  @JsonProperty("natabo_id")
  private Integer id_natureAbonne;
  
  /**
   * Contrat principal
   * 
   * @var Boolean
   */
  @JsonProperty("principal")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean principal;
  
  /**
   * Point de consommation
   * 
   * @var PointDeConsommationModel
   */
  @Relationship("pconso")
  private PointDeConsommationModel pointDeConsommation;
  
  /**
   * Occupant
   * 
   * @var PersonneModel
   */
  @Relationship("occupant")
  private PersonneModel occupant;
  
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
   * @param Integer p_id
   * 
   * @return ContratModel
   */
  public ContratModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Get occupant
   * 
   * @return PersonneModel
   */
  public PersonneModel getOccupant() {
    return this.occupant;
  }
}
