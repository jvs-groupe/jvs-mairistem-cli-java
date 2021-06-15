package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

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
import fr.jvsonline.jvsmairistemcli.omega.model.ConsommeModel;
import fr.jvsonline.jvsmairistemcli.omega.model.NatureAbonneModel;

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
   * Contrat à facturer
   */
  @JsonProperty("facturer")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean facturer;
  
  /**
   * Abo1
   */
  @JsonProperty("abo1")
  private Integer abo1;
  
  /**
   * Abo2
   */
  @JsonProperty("abo2")
  private Integer abo2;
  
  /**
   * Nombre
   */
  @JsonProperty("nombre")
  private Integer nombre;
  
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
   * Complément de l'occupant
   */
  @Relationship("complement_occupant")
  private ComplementPersonneContratModel complement_occupant;
  
  /**
   * Redevable
   */
  @Relationship("redevable")
  private PersonneModel redevable;
  
  /**
   * Complément du redevable
   */
  @Relationship("complement_redevable")
  private ComplementPersonneContratModel complement_redevable;
  
  /**
   * Nature d'abonné
   */
  @Relationship("natabo")
  private NatureAbonneModel natabo;
  
  /**
   * Consommes
   */
  @Relationship("consommes")
  private List<ConsommeModel> consommes = null;
  
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
   * Retourne vrai si le contrat est à facturer
   * 
   * @return Boolean
   */
  public Boolean getAFacturer() {
    return this.facturer;
  }
  
  /**
   * Retourne vrai si le contrat est à facturer
   * 
   * @return Boolean
   */
  public Boolean isAFacturer() {
    return this.facturer;
  }
  
  /**
   * Retourne la valeur de groupe1
   * 
   * @return Integer
   */
  public Integer getGroupe1() {
    return this.abo1;
  }
  
  /**
   * Retourne la valeur de groupe 2
   * 
   * @return Integer
   */
  public Integer getGroupe2() {
    return this.abo2;
  }
  
  /**
   * Retourne la valeur de nombre
   * 
   * @return Integer
   */
  public Integer getNombre() {
    return this.nombre;
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
   * Get complément occupant
   * 
   * @return ComplementPersonneContratModel
   */
  public ComplementPersonneContratModel getComplementOccupant() {
    return this.complement_occupant;
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
   * Get complément redevable
   * 
   * @return ComplementPersonneContratModel
   */
  public ComplementPersonneContratModel getComplementRedevable() {
    return this.complement_redevable;
  }
  
  /**
   * Retourne la nature d'abonné
   * 
   * @return NatureAbonneModel
   */
  public NatureAbonneModel getNatureAbonne() {
    return this.natabo;
  }
  
  /**
   * Retourne les consommations
   * 
   * @return Consommes
   */
  public List<ConsommeModel> getConsommes() {
    if (this.consommes == null) {
      this.consommes = new ArrayList<ConsommeModel>();
    }
    return this.consommes;
  }
  
  /**
   * Retourne la dernière consommation relevée
   * 
   * @return Integer
   */
  public Integer getDerniereConsommationRelevee() {
    if (this.consommes.size() > 0) {
      return this.consommes.get(0).getConsommationRelevee();
    }
    return 0;
  }
  
  /**
   * Retourne la dernière consommation facturée
   * 
   * @return Integer
   */
  public Integer getDerniereConsommationFacturee() {
    if (this.consommes.size() > 0) {
      return this.consommes.get(0).getConsommationFacturee();
    }
    return 0;
  }
}
