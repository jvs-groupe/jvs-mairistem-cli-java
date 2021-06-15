package fr.jvsonline.jvsmairistemcli.model;

import java.util.Arrays;
import java.util.List;

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
   * Article de la voie
   */
  private String articleVoie;

  /**
   * Type de voie
   */
  private String typeVoie;

  /**
   * Nom de la voie
   */
  private String nomVoie;

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
  public String getNumero() {
    if (numero != null) {
      return numero.toString();
    }
    return "";
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
    if (this.complementNumero != null) {
      return complementNumero;
    }
    return "";
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
    if (this.etage != null) {
      return this.etage;
    }
    return "";
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
    if (this.appartement != null) {
      return this.appartement;
    }
    return "";
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
    if (this.codeVoie != null) {
      return this.codeVoie;
    }
    return "";
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
    if (this.typeVoie != null) {
      return this.typeVoie;
    }
    return "";
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
   * Retourne l'article de la voie
   * 
   * @return String
   */
  public String getArticleVoie() {
    if (this.articleVoie != null) {
      return this.articleVoie;
    }
    return "";
  }

  /**
   * Affectation de l'article de la voie
   * 
   * @param p_article Article
   * 
   * @return AdresseModel
   */
  public AdresseModel setArticleVoie(String p_article) {
    this.articleVoie = p_article;
    return this;
  }

  /**
   * Get nom
   *
   * @return String 
   */
  public String getNomVoie() {
    if (this.nomVoie != null) {
      return nomVoie;
    }
    return "";
  }

  /**
   * Set nom
   *
   * @param p_nom Nom 
   *
   * @return AdresseModel
   */
  public AdresseModel setNomVoie(String p_nom) {
    this.nomVoie = p_nom;
    return this;
  }

  /**
   * Get complementNom
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
    if (this.codePostal != null) {
      return this.codePostal;
    }
    return "";
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
    if (this.ville != null) {
      return ville;
    }
    return "";
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
    if (this.codePays != null) {
      return this.codePays;
    }
    return "";
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
    if (this.pays != null) {
      return this.pays;
    }
    return "";
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
   * Set from full address
   * 
   * @param p_adr1 Ligne 1
   * @param p_adr2 Ligne 2
   * @param p_adr3 Ligne 3
   * 
   * @return AdresseModel
   */
  public AdresseModel setFullAdresse(String p_adr1, String p_adr2, String p_adr3) {
    if (p_adr1 == null) {
      p_adr1 = "";
    }
    if (p_adr2 == null) {
      p_adr2 = "";
    }
    if (p_adr3 == null) {
      p_adr3 = "";
    }
    String[] wordsType = new String[]{"CHEMIN","IMPASSE","VOIE","QUAI","RUE","ROUTE","BOULEVARD","AVENUE","ALLEE","AV","BLD","BLVD","IMP","QUARTIER","PLACE","IMP.","BLVD.","DOMAINE","SQUARE","ALLEES","ANCIEN","ANCIENNE","CHEMINS","ROUTES","VIEUX","BD","HAMEAU","CITE","RESIDENCE","RUELLE","PL","RTE"};
    List<String> listType = Arrays.asList(wordsType);
    String[] wordsArticle = new String[]{"DE","LE","LES","LA","DU","L'","DES","D'","AU","AUX"};
    List<String> listArticle = Arrays.asList(wordsArticle);
    String work = p_adr1.toUpperCase();
    String[] words = work.split("[\\s\\t]+");
    Boolean added = false;
    this.articleVoie = "";
    this.typeVoie = "";
    this.nomVoie = "";
    for(String s : words) {
      added = false;
      if (listType.contains(s)) {
        if (this.typeVoie == "" && this.nomVoie == "") {
          this.typeVoie += " " + s;
          added = true;
        }
      } else {
        if (listArticle.contains(s)) {
          if (this.nomVoie == "") {
            this.articleVoie += " " + s;
            added = true;
          }
        } else {
          if (this.typeVoie == "" && this.nomVoie == "") {
            try {
              // Ugly way
              int i = Integer.parseInt(s);
              this.numero = i;
              added = true;
            } catch (NumberFormatException e) {
              
            }
            added = true;
          }
        }
      }
      if (!added) {
        this.nomVoie += " " + s;
      }
    }
    this.articleVoie = this.articleVoie.trim();
    this.typeVoie = this.typeVoie.trim();
    this.nomVoie = this.nomVoie.trim();
    this.complementNom = p_adr2;
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
    if (this.complementNumero != null && this.complementNumero != "") {
      ret = ret + " " + this.complementNumero;
    }
    if (this.nomVoie != null && this.nomVoie != "") {
      ret = ret + " " + Tools.asString(this.typeVoie, "") + " " + Tools.asString(this.nomVoie, "");
    }
    ret = ret.trim() + "\n";
    if (this.complementNom != null && this.complementNom != "") {
      ret = ret.trim() + this.complementNom + "\n";
    }
    ret = ret.trim() + " " +
      Tools.asString(this.codePostal, "") + " " + 
      Tools.asString(this.ville, "")
    ;
    return ret.trim();
  }
}
