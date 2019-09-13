package fr.jvsonline.jvsmairistemcli.model;

import fr.jvsonline.jvsmairistemcli.core.Tools;

/**
 * AdresseModel
 * 
 * @author jeromeklam
 */
public class AdresseModel {
  
  /**
   * Identifiant de l'AdresseModel
   */
  private Integer id;
  
  /**
   * Numéro de l'AdresseModel
   */
  private Integer numero;
  
  /**
   * Complément du numéro
   */
  private String complementNumero;
  
  /**
   * Etage
   */
  private String etage;
  
  /**
   * Appartement
   */
  private String appartement;
  
  /**
   * Identifiant de la voie
   */
  private Integer id_voie;
  
  /**
   * Code de la voie
   */
  private String codeVoie;
  
  /**
   * Type de voie
   */
  private String typeVoie;
  
  /**
   * Nom de la voie
   */
  private String nom;
  
  /**
   * Complément du nom de la voie
   */
  private String complementNom;
  
  /**
   * Identifiant de la ville
   */
  private Integer id_ville;
  
  /**
   * Code postal
   */
  private String codePostal;
  
  /**
   * Ville
   */
  private String ville;
  
  /**
   * Identifiant du pays
   */
  private Integer id_pays;
  
  /**
   * Code du pays
   */
  private String codePays;
  
  /**
   * Libellé du pays
   */
  private String pays;
  
  /**
   * Constructor
   */
  public AdresseModel() {
  }

  /**
   * Get id
   *
   * @return Integer 
   */
  public Integer getId() {
    return id;
  }

  /**
   * Set id
   *
   * @param p_id Identifiant
   *
   * @return AdresseModel
   */
  public AdresseModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get numero
   *
   * @return Integer 
   */
  public Integer getNumero() {
    return numero;
  }

  /**
   * Set numero
   *
   * @param p_numero Numéro
   *
   * @return AdresseModel
   */
  public AdresseModel setNumero(Integer p_numero) {
    this.numero = p_numero;
    return this;
  }

  /**
   * Set numero
   *
   * @param p_numero Numéro
   *
   * @return AdresseModel
   */
  public AdresseModel setNumero(String p_numero) {
    if (p_numero != null) {
      try {
        this.numero = Integer.valueOf(p_numero);
      } catch (Exception ex) {
      }
    } else {
      this.numero = null;
    }
    return this;
  }
  
  /**
   * Get complementNumero Complément du numéro
   *
   * @return String 
   */
  public String getComplementNumero() {
    return complementNumero;
  }

  /**
   * Set complementNumero
   *
   * @param p_complementNumero Complément du numéro
   *
   * @return AdresseModel
   */
  public AdresseModel setComplementNumero(String p_complementNumero) {
    this.complementNumero = p_complementNumero;
    return this;
  }

  /**
   * Get etage
   *
   * @return String 
   */
  public String getEtage() {
    return etage;
  }

  /**
   * Set etage
   *
   * @param p_etage Etage
   *
   * @return AdresseModel
   */
  public AdresseModel setEtage(String p_etage) {
    this.etage = p_etage;
    return this;
  }

  /**
   * Get appartement
   *
   * @return String 
   */
  public String getAppartement() {
    return appartement;
  }

  /**
   * Set appartement
   *
   * @param p_appartement Appartement
   *
   * @return AdresseModel
   */
  public AdresseModel setAppartement(String p_appartement) {
    this.appartement = p_appartement;
    return this;
  }

  /**
   * Get id_voie
   *
   * @return Integer 
   */
  public Integer getId_voie() {
    return id_voie;
  }

  /**
   * Set id_voie
   *
   * @param p_id_voie Identifiant de la voie
   *
   * @return AdresseModel
   */
  public AdresseModel setId_voie(Integer p_id_voie) {
    this.id_voie = p_id_voie;
    return this;
  }

  /**
   * Get codeVoie
   *
   * @return String 
   */
  public String getCodeVoie() {
    return codeVoie;
  }

  /**
   * Set codeVoie
   *
   * @param p_codeVoie Code de la voie
   *
   * @return AdresseModel
   */
  public AdresseModel setCodeVoie(String p_codeVoie) {
    this.codeVoie = p_codeVoie;
    return this;
  }

  /**
   * Get typeVoie
   *
   * @return String 
   */
  public String getTypeVoie() {
    return typeVoie;
  }

  /**
   * Set typeVoie
   *
   * @param p_typeVoie Type de voie
   *
   * @return AdresseModel
   */
  public AdresseModel setTypeVoie(String p_typeVoie) {
    this.typeVoie = p_typeVoie;
    return this;
  }

  /**
   * Get nom
   *
   * @return String 
   */
  public String getNom() {
    return nom;
  }

  /**
   * Set nom
   *
   * @param p_nom Nom 
   *
   * @return AdresseModel
   */
  public AdresseModel setNom(String p_nom) {
    this.nom = p_nom;
    return this;
  }

  /**
   * Get complementNom
   *
   * @return String 
   */
  public String getComplementNom() {
    return complementNom;
  }

  /**
   * Set complementNom
   *
   * @param p_complementNom Complément du nom
   *
   * @return AdresseModel
   */
  public AdresseModel setComplementNom(String p_complementNom) {
    this.complementNom = p_complementNom;
    return this;
  }

  /**
   * Get id_ville
   *
   * @return Integer 
   */
  public Integer getId_ville() {
    return id_ville;
  }

  /**
   * Set id_ville
   *
   * @param p_id_ville Identifiant de la ville
   *
   * @return AdresseModel
   */
  public AdresseModel setId_ville(Integer p_id_ville) {
    this.id_ville = p_id_ville;
    return this;
  }

  /**
   * Get codePostal
   *
   * @return String 
   */
  public String getCodePostal() {
    return codePostal;
  }

  /**
   * Set codePostal
   *
   * @param p_codePostal Code postal
   *
   * @return AdresseModel
   */
  public AdresseModel setCodePostal(String p_codePostal) {
    this.codePostal = p_codePostal;
    return this;
  }

  /**
   * Get ville
   *
   * @return String 
   */
  public String getVille() {
    return ville;
  }

  /**
   * Set ville
   *
   * @param p_ville Ville
   *
   * @return AdresseModel
   */
  public AdresseModel setVille(String p_ville) {
    this.ville = p_ville;
    return this;
  }

  /**
   * Get id_pays
   *
   * @return Integer 
   */
  public Integer getId_pays() {
    return id_pays;
  }

  /**
   * Set id_pays
   *
   * @param p_id_pays Identifiant du pays
   *
   * @return AdresseModel
   */
  public AdresseModel setId_pays(Integer p_id_pays) {
    this.id_pays = p_id_pays;
    return this;
  }

  /**
   * Get codePays
   *
   * @return String 
   */
  public String getCodePays() {
    return codePays;
  }

  /**
   * Set codePays
   *
   * @param p_codePays Code pays
   *
   * @return AdresseModel
   */
  public AdresseModel setCodePays(String p_codePays) {
    this.codePays = p_codePays;
    return this;
  }

  /**
   * Get pays
   *
   * @return String 
   */
  public String getPays() {
    return pays;
  }

  /**
   * Set pays
   *
   * @param p_pays Pays
   *
   * @return AdresseModel
   */
  public AdresseModel setPays(String p_pays) {
    this.pays = p_pays;
    return this;
  }
  
  /**
   * toString
   * 
   * @return String
   */
  @Override
  public String toString() {
    String ret = "";
    if (this.numero != null) {
      ret = this.numero.toString();
    }
    if (this.complementNumero != null) {
      ret = ret + " " + this.complementNumero;
    }
    if (this.nom != null) {
      ret = ret + " " + Tools.asString(this.typeVoie, "") + " " + Tools.asString(this.nom, "");
    }
    ret = ret.trim() + "\n";
    if (this.complementNom != null) {
      ret = ret.trim() + this.complementNom + "\n";
    }
    ret = ret.trim() + " " +
      Tools.asString(this.codePostal, "") + " " + 
      Tools.asString(this.ville, "")
    ;
    return ret;
  }
}
