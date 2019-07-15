package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
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
  @JsonProperty("enum_paysr")
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
   * Catégorie de tiers
   */
  @JsonProperty("enum_ctier")
  private String categorieTier;
  
  /**
   * Nature juridique
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
  @JsonIgnore
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
   * Affectation de la civilité
   * 
   * @param p_civilite Civilité
   * 
   * @return PersonneModel
   */
  public PersonneModel setCivilite(String p_civilite) {
    this.civilite = p_civilite;
    return this;
  }
  
  /**
   * Retourne la civilité
   * 
   * @return String
   */
  public String getCivilite() {
    return this.civilite;
  }
  
  /**
   * Affectation du nom
   * 
   * @param p_nom Nom
   * 
   * @return PersonneModel
   */
  public PersonneModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }
  
  /**
   * Retourne le nom
   * 
   * @return String
   */
  public String getNom() {
    return this.nom;
  }

  /**
   * Affectation du prénom
   * 
   * @param p_prenom Prénom
   * 
   * @return PersonneModel
   */
  public PersonneModel setPrenom(String p_prenom) {
    this.prenom = p_prenom;
    return this;
  }
  
  /**
   * Retourne le prénom
   * 
   * @return String
   */
  public String getPrenom() {
    return this.prenom;
  }
  
  /**
   * Affectation de la première ligne de l'adresse
   * 
   * @param p_adr Adresse
   * 
   * @return PersonneModel
   */
  public PersonneModel setAdresse1(String p_adr) {
    this.adresse1 = p_adr;
    return this;
  }
  
  
  /**
   * Récupération de la première ligne d'adresse
   * 
   * @return String
   */
  public String getAdresse1() {
    return this.adresse1;
  }
  

  /**
   * Affectation de la seconde ligne de l'adresse
   * 
   * @param p_adr Adresse
   * 
   * @return PersonneModel
   */
  public PersonneModel setAdresse2(String p_adr) {
    this.adresse2 = p_adr;
    return this;
  }
  
  /**
   * Récupération de la seconde ligne de l'adresse
   * 
   * @return String
   */
  public String getAdresse2() {
    return this.adresse2;
  }
  
  /**
   * Affectation du code postal
   * 
   * @param p_code_postal Code postal
   * 
   * @return PersonneModel
   */
  public PersonneModel setCodePostal(String p_code_postal) {
    this.codePostal = p_code_postal;
    return this;
  }
  
  /**
   * Affectation de la ville
   * 
   * @param p_ville Ville
   * 
   * @return PersonneModel
   */
  public PersonneModel setVille(String p_ville) {
    this.ville = p_ville;
    return this;
  }
  
  /**
   * Retourne la ville
   * 
   * @return String
   */
  public String getVille() {
    return this.ville;
  }
  
  /**
   * Affectation du complément du nom
   * 
   * @param p_complement Complément
   * 
   * @return PersonneModel
   */
  public PersonneModel setComplementNom(String p_complement) {
    this.complementNom = p_complement;
    return this;
  }
  
  /**
   * Retourne le complément du nom
   * 
   * @return String
   */
  public String getComplementNom() {
    return this.complementNom;
  }
  
  /**
   * Affectation de l'email
   * 
   * @param p_email Email
   * 
   * @return PersonneModel
   */
  public PersonneModel setEmail(String p_email) {
    this.email = p_email;
    return this;
  }
  
  /**
   * Récupération de l'email
   * 
   * @return String
   */
  public String getEmail() {
    return this.email;
  }
  
  /**
   * Affectation du téléphone
   * 
   * @param p_telephone String
   * 
   * @return PersonneModel
   */
  public PersonneModel setTelephone(String p_telephone) {
    this.telephone = p_telephone;
    return this;
  }
  
  /**
   * Retourne le téléphone
   * 
   * @return String
   */
  public String getTelephone() {
    return this.telephone;
  }
  
  /**
   * Affectation du numéro de mobile
   * 
   * @param p_mobile Mobile
   * 
   * @return PersonneModel
   */
  public PersonneModel setTelephoneMobile(String p_mobile) {
    this.telephoneMobile = p_mobile;
    return this;
  }
  
  /**
   * Retourne le numéro de mobile
   * 
   * @return String
   */
  public String getTelephoneMobile() {
    return this.telephoneMobile;
  }
  
  /**
   * Convert to Person
   * 
   * @return fr.jvsonline.jvsmairistemcli.model.PersonneModel
   */
  @JsonIgnore
  public fr.jvsonline.jvsmairistemcli.model.PersonneModel toPersonne() {
    fr.jvsonline.jvsmairistemcli.model.PersonneModel personne = new fr.jvsonline.jvsmairistemcli.model.PersonneModel();
    return personne;
  }

  /**
   * Retourne le nom complet
   * 
   * @return String
   */
  @JsonIgnore
  @Override
  public String getNomComplet() {
    String str = Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
    return str.trim();
  }
  
  /**
   * toString
   * 
   * @return String
   */
  @JsonIgnore
  @Override
  public String toString() {
    return this.getNomComplet();
  }
}
