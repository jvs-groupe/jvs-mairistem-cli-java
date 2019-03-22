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
 */
@Type("Partner_Personne")
public class PersonneModel extends BaseModel implements BaseModelInterface, PersonneInterface {

  /**
   * Identifiant de la pesonne
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("personne_id")
  private Integer id;
  
  /**
   * Civilité
   */
  @JsonProperty("enum_civ")
  private String civilite;
  
  /**
   * Nom
   */
  @JsonProperty("nompers")
  private String nom;
  
  /**
   * Prénom
   */
  @JsonProperty("prenpers")
  private String prenom;
  
  /**
   * Complément du nom
   */
  @JsonProperty("cpltnom")
  private String complementNom;
  
  /**
   * Ligne adresse 1
   */
  @JsonProperty("adrpers1")
  private String adresse1;

  /**
   * Ligne adresse 2
   */
  @JsonProperty("adrpers2")
  private String adresse2;
  
  /**
   * Ligne adresse 3
   */
  @JsonProperty("adrpers3")
  private String adresse3;

  /**
   * Code postal
   */
  @JsonProperty("cppers")
  private String codePostal;
  
  /**
   * Ville
   */
  @JsonProperty("villepers")
  private String ville;

  /**
   * Pays
   */
  @JsonProperty("pays")
  private String pays;
  
  /**
   * Téléphone
   */
  @JsonProperty("tel")
  private String telephone;

  /**
   * Fax
   */
  @JsonProperty("fax")
  private String fax;
  
  /**
   * Mail
   */
  @JsonProperty("mail")
  private String email;
  
  /**
   * Numéro de TVA
   */
  @JsonProperty("numtva")
  private String numeroTva;
  
  /**
   * Téléphone mobile
   */
  @JsonProperty("telmobile")
  private String telephoneMobile;
  
  /**
   * Téléphone
   */
  @JsonProperty("teltravail")
  private String telephoneTravail;
  
  /**
   * Numéro de SIRET
   */
  @JsonProperty("numerosiret")
  private String numeroSiret;
  
  /**
   * Voie actif
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;
  
  /**
   * Code tiers
   */
  @JsonProperty("enum_ctier")
  private String codeTier;
  
  /**
   * Code tiers
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
   * @param p_id Identifiant
   * 
   * @return PersonneModel
   */
  public PersonneModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }
  
  /**
   * Convert to Person
   * 
   * @return fr.jvsonline.jvsmairistemcli.model.PersonneModel
   */
  public fr.jvsonline.jvsmairistemcli.model.PersonneModel toPersonne() {
    fr.jvsonline.jvsmairistemcli.model.PersonneModel personne = new fr.jvsonline.jvsmairistemcli.model.PersonneModel();
    return personne;
  }

  /**
   * Retourne le nom complet
   * 
   * @return String
   */
  @Override
  public String getNomComplet() {
    String str = Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
    return str.trim();
  }
}
