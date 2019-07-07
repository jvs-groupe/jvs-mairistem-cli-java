package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  private Integer              id;

  /**
   * Identifiant du point de desserte
   */
  @JsonProperty("pdess_id")
  private Integer              id_pointDesserte;

  /**
   * Identifiant du compteur
   */
  @JsonProperty("compteur_id")
  private Integer              id_compteur;

  /**
   * Numéro de point de consommation
   */
  @JsonProperty("numpconso")
  private String               numero;

  /**
   * Identifiant de l'adresse de point de desserte
   */
  @JsonProperty("pdessadr_id")
  private Integer              id_adresseDesserte;

  /**
   * Type d'habitation
   */
  @JsonProperty("enum_thab")
  private String               typeHabitation;

  /**
   * Etage
   */
  @JsonProperty("etage")
  private String               etage;

  /**
   * Appartement
   */
  @JsonProperty("numapt")
  private String               appartement;

  /**
   * Identifiant de la tournée
   */
  @JsonProperty("tournee_id")
  private Integer              id_tournee;

  /**
   * Actif
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean              actif;

  /**
   * Date de début
   */
  @JsonProperty("datedeb")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date                 dateDebut;

  /**
   * Date de début
   */
  @JsonProperty("datefin")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date                 dateFin;

  /**
   * Ordre de relève
   */
  @JsonProperty("noordrlv")
  private Integer              numeroOrdreReleve;
  
  /**
   * Complément du numéro d'ordre de relève
   */
  @JsonProperty("cpltnoordrlv")
  private Integer              complementNumeroOrdreReleve;
  
  /**
   * Clef de localisation
   */
  @JsonProperty("cleloc")
  private String               clefLocalisation;
  
  /**
   * Coordonnées SIG
   */
  @JsonProperty("sigcoord")
  private String               coordonneeSig;
  
  /**
   * Coordonnées GPS
   */
  @JsonProperty("coordgpsdl")
  private String               coordonneeGps;
  
  /**
   * Commentaire
   */
  @JsonProperty("comlib")
  private String               commentaire;
  
  /**
   * Identifiant externe
   */
  @JsonProperty("ident_externe")
  private Integer              id_externe;

  /**
   * Compteur
   */
  @Relationship("compteur")
  private CompteurModel        compteur;

  /**
   * Adresse de desserte
   */
  @Relationship("pdessadr")
  private AdresseDesserteModel adresseDesserte;

  /**
   * Contrat actif
   */
  @Relationship("contratactif")
  private ContratModel         contratActif;

  /**
   * Tournée
   */
  @Relationship("tournee")
  private TourneeModel         tournee;

  /**
   * Dernier relevé
   */
  @Relationship("dernierreleve")
  private ReleveModel          dernierReleve;
  
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
  public String getEtage() {
    return this.etage;
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
  public String getAppartement() {
    return this.appartement;
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
   * Get numéro ordre relève
   * 
   * @return Integer
   */
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
  public PointDeConsommationModel getComplementNumeroOrdreReleve(Integer p_complement) {
    this.complementNumeroOrdreReleve = p_complement;
    return this;
  }

  /**
   * Get clef de localisation
   * 
   * @return String
   */
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
  public CompteurModel getCompteur() {
    return this.compteur;
  }

  /**
   * Get adresse de desserte
   * 
   * @return AdresseDesserteModel
   */
  public AdresseDesserteModel getAdresseDesserte() {
    return this.adresseDesserte;
  }

  /**
   * Get contrat actif
   * 
   * @return ContratModel
   */
  public ContratModel getContratActif() {
    return this.contratActif;
  }

  /**
   * Get tournée
   * 
   * @return TourneeModel
   */
  public TourneeModel getTournee() {
    return this.tournee;
  }

  /**
   * Get dernier relevé
   * 
   * @return ReleveModel
   */
  public ReleveModel getDernierReleve() {
    return this.dernierReleve;
  }

  /**
   * Get as Adresse
   * 
   * @return Adresse
   */
  public AdresseModel toAdresse() {
    AdresseModel adresse = new AdresseModel();
    adresse.setAppartement(this.appartement).setEtage(this.etage);
    AdresseDesserteModel adresseDesserte = this.getAdresseDesserte();
    if (adresseDesserte != null) {
      adresse.setNumero(adresseDesserte.getNumeroVoie());
      VoieModel voie = adresseDesserte.getVoie();
      if (voie != null) {
        adresse.setTypeVoie(voie.getType()).setNom(voie.getNom());
        OrganismeModel organisme = voie.getCommune();
        if (organisme != null) {
          adresse.setCodePostal(organisme.getCodePostal()).setVille(organisme.getVille());
        }
      }
    }
    return adresse;
  }
}
