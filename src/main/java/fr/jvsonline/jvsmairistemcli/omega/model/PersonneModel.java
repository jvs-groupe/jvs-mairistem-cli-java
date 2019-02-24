package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.core.PersonneInterface;
import fr.jvsonline.jvsmairistemcli.core.Tools;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;

/**
 * PersonneModel
 * 
 * @author jeromeklam
 * @package Personne
 */
@Type("Partner_Personne")
public class PersonneModel extends BaseModel implements BaseModelInterface, PersonneInterface {

  /**
   * Identifiant de la pesonne
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("personne_id")
  private Integer id;
  
  /**
   * Civilité
   * 
   * @var String
   */
  @JsonProperty("enum_civ")
  private String civilite;
  
  /**
   * Nom
   * 
   * @var String
   */
  @JsonProperty("nompers")
  private String nom;
  
  /**
   * Prénom
   * 
   * @var String
   */
  @JsonProperty("prenpers")
  private String prenom;
  
  /**
   * Complément du nom
   * 
   * @var String
   */
  @JsonProperty("cpltnom")
  private String complementNom;
  
  /**
   * Ligne adresse 1
   * 
   * @var String
   */
  @JsonProperty("adrpers1")
  private String adresse1;

  /**
   * Ligne adresse 2
   * 
   * @var String
   */
  @JsonProperty("adrpers2")
  private String adresse2;
  
  /**
   * Ligne adresse 3
   * 
   * @var String
   */
  @JsonProperty("adrpers3")
  private String adresse3;

  /**
   * Code postal
   * 
   * @var String
   */
  @JsonProperty("cppers")
  private String codePostal;
  
  /**
   * Ville
   * 
   * @var String
   */
  @JsonProperty("villepers")
  private String ville;

  /**
   * Pays
   * 
   * @var String
   */
  @JsonProperty("pays")
  private String pays;
  
  /**
   * Téléphone
   * 
   * @var String
   */
  @JsonProperty("tel")
  private String telephone;

  /**
   * Fax
   * 
   * @var String
   */
  @JsonProperty("fax")
  private String fax;
  
  /**
   * Mail
   * 
   * @var String
   */
  @JsonProperty("mail")
  private String email;
  
  /**
   * Numéro de TVA
   * 
   * @var String
   */
  @JsonProperty("numtva")
  private String numeroTva;
  
  /**
   * Téléphone mobile
   * 
   * @var String
   */
  @JsonProperty("telmobile")
  private String telephoneMobile;
  
  /**
   * Téléphone
   * 
   * @var String
   */
  @JsonProperty("teltravail")
  private String telephoneTravail;
  
  /**
   * Numéro de SIRET
   * 
   * @var String
   */
  @JsonProperty("numerosiret")
  private String numeroSiret;
  
  /**
   * Voie actif
   * 
   * @var Boolean
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;
  
  /**
   * Code tiers
   * 
   * @var String
   */
  @JsonProperty("enum_ctier")
  private String codeTier;
  
  /**
   * Code tiers
   * 
   * @var String
   */
  @JsonProperty("enum_natju")
  private String natureJuridique;
  
  /**
   * Constructor
   */
  public PersonneModel() {
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
   * @return PersonneModel
   */
  public PersonneModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  public fr.jvsonline.jvsmairistemcli.model.PersonneModel toPersonne() {
    fr.jvsonline.jvsmairistemcli.model.PersonneModel personne = new fr.jvsonline.jvsmairistemcli.model.PersonneModel();
    return personne;
  }

  @Override
  public String getNomComplet() {
    String str = Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
    return str.trim();
  }
}
