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
    return this.prenom;
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
    return Tools.asString(this.nom, "") + " " + Tools.asString(this.prenom, "");
  }
}
