package fr.jvsonline.jvsmairistemcli.model;

import fr.jvsonline.jvsmairistemcli.core.Tools;

/**
 * PersonneModel
 * 
 * @author jeromeklam
 */
public class PersonneModel extends AdresseModel {

  /**
   * Identifiant de la personne
   */
  private Integer id;

  /**
   * Civilité de la personne
   */
  private String civilite;

  /**
   * Nom de la personne
   */
  private String nom;

  /**
   * Prénom de la personne
   */
  private String prenom;

  /**
   * Coonstructor
   */
  public PersonneModel() {
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
   * Set identifiant
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
   * Get civilité
   * 
   * @return String
   */
  public String getCivilite() {
    if (this.civilite != null) {
      return this.civilite;
    }
    return "";
  }

  public PersonneModel setCivilite(String p_civilite) {
    this.civilite = p_civilite;
    return this;
  }

  /**
   * Get nom
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
   * Set nom
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
   * Get prénom
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
   * Set prénom
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
   * As string
   * 
   * @return String
   */
  @Override
  public String toString() {
    String str = Tools.asString(this.civilite, "") + " " + Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
    return str.trim();
  }
}
