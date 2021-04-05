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
import fr.jvsonline.jvsmairistemcli.omega.Container;

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
  private String categorieTiers;
  
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
   * Affectation du code de la civilité
   * 
   * @param p_civilite Civilité
   * 
   * @return PersonneModel
   */
  public PersonneModel setCodeCivilite(String p_civilite) {
    this.civilite = p_civilite;
    return this;
  }

  /**
   * Retourne le code de la civilite
   * 
   * @return String
   */
  public String getCodeCivilite() {
    if (this.civilite != null) {
      return this.civilite;
    }
    return "";
  }

  /**
   * Retourne le libellé de la civilité
   * 
   * @return String
   */
  public String getCivilite() {
    if (this.civilite != null) {
      Container omegaContainer = Container.getInstance();
      return omegaContainer.getLibelleCivilite(this.civilite);
    }
    return "";
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
    if (this.nom != null) {
      return this.nom;
    }
    return "";
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
    if (this.prenom != null) {
      return this.prenom;
    }
    return "";
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
    if (this.adresse1 != null) {
      return this.adresse1;
    }
    return "";
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
    if (this.adresse2 != null) {
      return this.adresse2;
    }
    return "";
  }
  
  /**
   * Affectation de la troisième ligne de l'adresse
   * 
   * @param p_adr Adresse
   * 
   * @return PersonneModel
   */
  public PersonneModel setAdresse3(String p_adr) {
    this.adresse3 = p_adr;
    return this;
  }
  
  /**
   * Récupération de la troisième ligne de l'adresse
   * 
   * @return String
   */
  public String getAdresse3() {
    if (this.adresse3 != null) {
      return this.adresse3;
    }
    return "";
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
   * Retourne le code postal
   * 
   * @return String
   */
  public String getCodePostal() {
    if (this.codePostal != null) {
      return this.codePostal;
    }
    return "";
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
    if (this.ville != null) {
      return this.ville;
    }
    return "";
  }
  
  /**
   * Affectation du pays
   * 
   * @param p_pays Pays
   * 
   * @return PersonneModel
   */
  public PersonneModel setPays(String p_pays) {
    this.pays = p_pays;
    return this;
  }

  /**
   * Retourne le pays
   * 
   * @return String
   */
  public String getPays() {
    if (this.pays != null) {
      return this.pays;
    }
    return "";
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
    if (this.complementNom != null) {
      return this.complementNom;
    }
    return "";
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
    if (this.email != null) {
      return this.email;
    }
    return "";
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
    if (this.telephone != null) {
      return this.telephone;
    }
    return "";
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
    if (this.telephoneMobile != null) {
      return this.telephoneMobile;
    }
    return "";
  }

  /**
   * Affectation du numéro de fax
   * 
   * @param p_fax Fax
   * 
   * @return PersonneModel
   */
  public PersonneModel setFax(String p_fax) {
    this.fax = p_fax;
    return this;
  }

  /**
   * Retourne le numéro de fax
   * 
   * @return String
   */
  public String getFax() {
    if (this.fax != null) {
      return this.fax;
    }
    return "";
  }

  /**
   * Affectation du numéro de siret
   * 
   * @param p_siret Siret
   * 
   * @return PersonneModel
   */
  public PersonneModel setSiret(String p_siret) {
    this.numeroSiret = p_siret;
    return this;
  }

  /**
   * Retourne le numéro de siret
   * 
   * @return String
   */
  public String getSiret() {
    if (this.numeroSiret != null) {
      return this.numeroSiret;
    }
    return "";
  }

  /**
   * Affectation de la catégorie du Tiers
   * 
   * @param p_categorie CategorieTiers
   * 
   * @return PersonneModel
   */
  public PersonneModel setCategorieTiers(String p_categorie) {
    this.categorieTiers = p_categorie;
    return this;
  }

  /**
   * Retourne la catégorie du tiers
   * 
   * @return String
   */
  public String getCategorieTiers() {
    if (this.categorieTiers != null) {
      Container omegaContainer = Container.getInstance();
      return omegaContainer.getLibelleCategorieTiers(this.categorieTiers);
    }
    return "";
  }
  
  /**
   * Retourne le code catégorie de Tiers
   * 
   * @return String
   */
  public String getCodeCategorieTiers() {
    if (this.categorieTiers != null) {
      return this.categorieTiers;
    }
    return "";
  }

  /**
   * Affectation de la nature juridique
   * 
   * @param p_nature NatureJuridique
   * 
   * @return PersonneModel
   */
  public PersonneModel setNatureJuridique(String p_nature) {
    this.natureJuridique = p_nature;
    return this;
  }

  /**
   * Retourne la nature juridique
   * 
   * @return String
   */
  public String getNatureJuridique() {
    if (this.natureJuridique != null) {
      Container omegaContainer = Container.getInstance();
      return omegaContainer.getLibelleNatureJuridique(this.natureJuridique);
    }
    return "";
  }

  /**
   * Retourne le code natude juridique
   * 
   * @return String
   */
  public String getCodeNatureJuridique() {
    if (this.natureJuridique != null) {
      return this.natureJuridique;
    }
    return "";
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
    String civilite = this.getCivilite();
    String str = civilite + " " + Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
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
