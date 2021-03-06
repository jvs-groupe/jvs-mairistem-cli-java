package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fr.jvsonline.jvsmairistemcli.core.AdresseInterface;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.core.Tools;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import fr.jvsonline.jvsmairistemcli.model.AdresseModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CompteurModel;
import fr.jvsonline.jvsmairistemcli.omega.model.ContratModel;
import fr.jvsonline.jvsmairistemcli.omega.model.AdresseDesserteModel;

/**
 * PointDeConsommationModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Pconso")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointDeConsommationModel extends BaseModel implements BaseModelInterface, AdresseInterface {

  /**
   * Identifiant du point de consommation
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("pconso_id")
  private Integer id;

  /**
   * Identifiant du point de desserte
   */
  @JsonProperty("pdess_id")
  private Integer id_pointDesserte;

  /**
   * Identifiant du compteur
   */
  @JsonProperty("compteur_id")
  private Integer id_compteur;

  /**
   * Numéro de point de consommation
   */
  @JsonProperty("numpconso")
  private String numero;

  /**
   * Identifiant de l'adresse de point de desserte
   */
  @JsonProperty("pdessadr_id")
  private Integer id_adresseDesserte;

  /**
   * Type d'habitation
   */
  @JsonProperty("enum_thab")
  private String typeHabitation;

  /**
   * Etage
   */
  @JsonProperty("etage")
  private String etage;

  /**
   * Appartement
   */
  @JsonProperty("numapt")
  private String appartement;

  /**
   * Complément d'adresse
   */
  @JsonProperty("cpltadr")
  private String complement;

  /**
   * Identifiant de la tournée
   */
  @JsonProperty("tournee_id")
  private Integer id_tournee;

  /**
   * Actif
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean actif;

  /**
   * Date de début
   */
  @JsonProperty("datedeb")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateDebut;

  /**
   * Date de début
   */
  @JsonProperty("datefin")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateFin;

  /**
   * Ordre de relève
   */
  @JsonProperty("noordrlv")
  private Integer numeroOrdreReleve;

  /**
   * Complément du numéro d'ordre de relève
   */
  @JsonProperty("cpltnoordrlv")
  private Integer complementNumeroOrdreReleve;

  /**
   * Clef de localisation
   */
  @JsonProperty("cleloc")
  private String clefLocalisation;

  /**
   * Coordonnées SIG
   */
  @JsonProperty("sigcoord")
  private String coordonneeSig;

  /**
   * Coordonnées GPS
   */
  @JsonProperty("coordgpsdl")
  private String coordonneeGps;

  /**
   * Commentaire
   */
  @JsonProperty("comlib")
  private String commentaire;

  /**
   * Identifiant externe
   */
  @JsonProperty("ident_externe")
  private Integer id_externe;

  /**
   * Compteur
   */
  @Relationship("compteur")
  private CompteurModel compteur;

  /**
   * Adresse de desserte
   */
  @Relationship("pdessadr")
  private AdresseDesserteModel adresseDesserte;

  /**
   * Contrat actif
   */
  @Relationship("contratactif")
  private ContratModel contratActif;

  /**
   * Tournée
   */
  @Relationship("tournee")
  private TourneeModel tournee;

  /**
   * Dernier relevé
   */
  @Relationship("dernierreleve")
  private ReleveModel dernierReleve;

  /**
   * Propriétaire
   */
  @Relationship("proprietaire")
  private PersonneModel proprietaire;

  /**
   * Complément du propriétaire
   */
  @Relationship("complement_proprietaire")
  private ComplementPersonnePConsoModel complement_proprietaire;
  
  /**
   * Contrats
   */
  @Relationship("contrats")
  private List<ContratModel> contrats = null;

  /**
   * Constructor
   */
  public PointDeConsommationModel() {
  }

  /**
   * Get the pconso id
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getId() {
    return this.id;
  }

  /**
   * Set the identifier
   * 
   * @param p_id Identifiant
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setId(Integer p_id) {
    this.id = p_id;
    return this;
  }

  /**
   * Get the numero
   * 
   * @return String
   */
  @JsonIgnore
  public String getNumero() {
    return this.numero;
  }

  /**
   * Set numero
   * 
   * @param p_numero Numéro du point de consommation
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setNumero(String p_numero) {
    this.numero = p_numero;
    return this;
  }

  /**
   * Get identifiant tournée
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdTournee() {
    return this.id_tournee;
  }

  /**
   * Set identifiant tournée
   * 
   * @param p_idTournee Identifiant de la tournée
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setIdTournee(Integer p_idTournee) {
    this.id_tournee = p_idTournee;
    return this;
  }

  /**
   * Get identifiant compteur
   *
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdCompteur() {
    return this.id_compteur;
  }

  /**
   * Set identifiant compteur
   * 
   * @param p_idCompteur Identifiant du compteur
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setIdCompteur(Integer p_idCompteur) {
    this.id_compteur = p_idCompteur;
    return this;
  }

  /**
   * Get type d'habitation
   * 
   * @return String
   */
  @JsonIgnore
  public String getTypeHabitation() {
    return this.typeHabitation;
  }

  /**
   * Set type d'habitation
   * 
   * @param p_typeHabitation Type d'habitation (énumération)
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setTypeHabitation(String p_typeHabitation) {
    this.typeHabitation = p_typeHabitation;
    return this;
  }

  /**
   * Get etage
   * 
   * @return String
   */
  @JsonIgnore
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
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setEtage(String p_etage) {
    this.etage = p_etage;
    return this;
  }

  /**
   * Get appartement
   * 
   * @return String
   */
  @JsonIgnore
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
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setAppartement(String p_appartement) {
    this.appartement = p_appartement;
    return this;
  }

  /**
   * Get complement
   * 
   * @return String
   */
  @JsonIgnore
  public String getComplement() {
    return this.complement;
  }

  /**
   * Set complement
   * 
   * @param p_complement Complement
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setComplement(String p_complement) {
    this.complement = p_complement;
    return this;
  }

  /**
   * Get numéro ordre relève
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getNumeroOrdreReleve() {
    return this.numeroOrdreReleve;
  }

  /**
   * Set numéro ordre relève
   * 
   * @param p_numero Numéro
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setNumeroOrdreReleve(Integer p_numero) {
    this.numeroOrdreReleve = p_numero;
    return this;
  }

  /**
   * Get complément numéro ordre relève
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getComplementNumeroOrdreReleve() {
    return this.complementNumeroOrdreReleve;
  }

  /**
   * Set complément numéro ordre relève
   * 
   * @param p_complement Complément
   * 
   * @return PointDeConsommationModel
   */
  @JsonIgnore
  public PointDeConsommationModel getComplementNumeroOrdreReleve(Integer p_complement) {
    this.complementNumeroOrdreReleve = p_complement;
    return this;
  }

  /**
   * Get clef de localisation
   * 
   * @return String
   */
  @JsonIgnore
  public String getClefLocalisation() {
    return this.clefLocalisation;
  }

  /**
   * Set clef de localisation
   * 
   * @param p_clef Clef
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setClefLocalisatio(String p_clef) {
    this.clefLocalisation = p_clef;
    return this;
  }

  /**
   * Get coordonnées SIG
   * 
   * @return String
   */
  @JsonIgnore
  public String getCoordonneeSig() {
    return this.coordonneeSig;
  }

  /**
   * Set coordonnées SIG
   * 
   * @param p_coordonnee Coordonnées
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setCoordonneeSig(String p_coordonnee) {
    this.coordonneeSig = p_coordonnee;
    return this;
  }

  /**
   * Get coordonnées Gps
   * 
   * @return String
   */
  @JsonIgnore
  public String getCoordonneeGps() {
    return this.coordonneeGps;
  }

  /**
   * Set coordonnées Gps
   * 
   * @param p_coordonnee Coordonnées
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setCoordonneeGps(String p_coordonnee) {
    this.coordonneeGps = p_coordonnee;
    return this;
  }

  /**
   * Get commentaire
   * 
   * @return String
   */
  @JsonIgnore
  public String getCommentaire() {
    return this.commentaire;
  }

  /**
   * Set commentaire
   * 
   * @param p_commentaire String
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setCommentaire(String p_commentaire) {
    this.commentaire = p_commentaire;
    return this;
  }

  /**
   * Get identifiant externe
   * 
   * @return Integer
   */
  @JsonIgnore
  public Integer getIdExterne() {
    return this.id_externe;
  }

  /**
   * Set identifiant externe
   * 
   * @param p_idExterne Identifiant externe
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setIdExterne(Integer p_idExterne) {
    this.id_externe = p_idExterne;
    return this;
  }

  /**
   * Get compteur
   * 
   * @return CompteurModel
   */
  @JsonIgnore
  public CompteurModel getCompteur() {
    return this.compteur;
  }

  /**
   * Get adresse de desserte
   * 
   * @return AdresseDesserteModel
   */
  @JsonIgnore
  public AdresseDesserteModel getAdresseDesserte() {
    return this.adresseDesserte;
  }

  /**
   * Get contrat actif
   * 
   * @return ContratModel
   */
  @JsonIgnore
  public ContratModel getContratActif() {
    return this.contratActif;
  }

  /**
   * Get tournée
   * 
   * @return TourneeModel
   */
  @JsonIgnore
  public TourneeModel getTournee() {
    return this.tournee;
  }

  /**
   * Get dernier relevé
   * 
   * @return ReleveModel
   */
  @JsonIgnore
  public ReleveModel getDernierReleve() {
    return this.dernierReleve;
  }

  /**
   * Retourne un nouveau relevé
   * 
   * @return ReleveModel
   */
  @JsonIgnore
  public ReleveModel getNouveauReleve() {
    ReleveModel unReleve = new ReleveModel();
    unReleve.setId(-1);
    unReleve.setIdPconso(this.id);
    unReleve.setIdCompteur(this.id_compteur);
    if (this.dernierReleve != null) {
      unReleve.setDateAncienIndex(this.dernierReleve.getDateNouvelIndex());
      unReleve.setAncienIndex(this.dernierReleve.getNouvelIndex());
      unReleve.setDateNouvelIndex(new Date());
      unReleve.setNouvelIndex(this.dernierReleve.getNouvelIndex());
      unReleve.setCommentaire("Relevé via partenaire");
    }
    return unReleve;
  }

  /**
   * Get as Adresse
   * 
   * @return Adresse
   */
  public AdresseModel toAdresse() {
    AdresseModel adresse = new AdresseModel();
    if (this.appartement != null) {
      adresse.setAppartement(this.appartement);
    }
    if (this.etage != null) {
      adresse.setEtage(this.etage);
    }
    AdresseDesserteModel adresseDesserte = this.getAdresseDesserte();
    if (adresseDesserte != null) {
      adresse.setNumero(adresseDesserte.getNumeroVoie());
      VoieModel voie = adresseDesserte.getVoie();
      if (voie != null) {
        adresse.setTypeVoie(voie.getType()).setArticleVoie(voie.getArticle()).setNomVoie(voie.getNom());
        OrganismeModel organisme = voie.getCommune();
        if (organisme != null) {
          adresse.setCodePostal(organisme.getCodePostal()).setVille(organisme.getVille());
        }
      }
    }
    return adresse;
  }

  /**
   * Get propriétaire
   * 
   * @return PersonneModel
   */
  public PersonneModel getProprietaire() {
    return this.proprietaire;
  }

  /**
   * Get complément propriétaire
   * 
   * @return ComplementPersonnePConsoModel
   */
  public ComplementPersonnePConsoModel getComplementProprietaire() {
    return this.complement_proprietaire;
  }
  
  /**
   * Get Latitude
   * 
   * @return Double
   */
  public Double getLatitude() {
    Double db = 0.0;
    try {
      String[] parts = this.coordonneeSig.split("\\|", 3);
      if (parts.length == 3) {
        db = Double.parseDouble(parts[0]);
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return db;
  }

  /**
   * Get Longitude
   * 
   * @return Double
   */
  public Double getLongitude() {
    Double db = 0.0;
    try {
      String[] parts = this.coordonneeSig.split("\\|", 3);
      if (parts.length == 3) {
        db = Double.parseDouble(parts[1]);
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return db;
  }

  /**
   * Get Altitude
   * 
   * @return Double
   */
  public Double getAltitude() {
    Double db = 0.0;
    try {
      String[] parts = this.coordonneeSig.split("\\|", 3);
      if (parts.length == 3) {
        db = Double.parseDouble(parts[2]);
      }
    } catch (Exception ex) {
      System.out.println(ex);
    }
    return db;
  }

  /**
   * Retourne la liste des contrats
   * 
   * @return Contrats
   */
  public List<ContratModel> getContrats() {
    if (this.contrats == null) {
      this.contrats = new ArrayList<ContratModel>();
    }
    return this.contrats;
  }

  /**
   * Retourne la consommation du dernier relevé
   * 
   * @return Integer
   */
  public Integer getConsommationDernierReleve() {
    if (this.dernierReleve != null) {
      return this.dernierReleve.getConsommationRelevee();
    }
    return 0;
  }

  /**
   * Retourne l'index du dernier relevé
   * 
   * @return Integer
   */
  public Integer getIndexDernierReleve() {
    if (this.dernierReleve != null) {
      return this.dernierReleve.getNouvelIndex();
    }
    return 0;
  }

  /**
   * Get numero voie
   * 
   * @return String
   */
  public String getNumeroVoie() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getNumeroVoie();
    }
    return "";
  }

  /**
   * Get nom voie
   * 
   * @return String
   */
  public String getNomVoie() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getNomVoie();
    }
    return "";
  }

  /**
   * Get complement numero voie
   * 
   * @return String
   */
  public String getComplementNumeroVoie() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getComplementNumeroVoie();
    }
    return "";
  }
  
  /**
   * Get complement nom voie
   * 
   * @return String
   */
  public String getComplementNomVoie() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getComplementNomVoie();
    }
    return "";
  }

  /**
   * Get code postal ville
   * 
   * @return String
   */
  public String getCodePostalVille() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getCodePostalVille();
    }
    return "";
  }

  /**
   * Get nom ville
   * 
   * @return String
   */
  public String getNomVille() {
    AdresseDesserteModel adr = this.getAdresseDesserte();
    if (adr != null) {
      return adr.getNomVille();
    }
    return "";
  }
}
