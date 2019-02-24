package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @package PointDeConsommation
 */
@Type("Partner_Pconso")
public class PointDeConsommationModel extends BaseModel implements BaseModelInterface, AdresseInterface {

  /**
   * Identifiant du point de consommation
   * 
   * @var Integer
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("pconso_id")
  private Integer              id;

  /**
   * Identifiant du point de desserte
   * 
   * @var Integer
   */
  @JsonProperty("pdess_id")
  private Integer              id_pointDesserte;

  /**
   * Identifiant du compteur
   * 
   * @var Integer
   */
  @JsonProperty("compteur_id")
  private Integer              id_compteur;

  /**
   * Numéro de point de consommation
   * 
   * @var String
   */
  @JsonProperty("numpconso")
  private String               numero;

  /**
   * Identifiant de l'adresse de point de desserte
   * 
   * @var Integer
   */
  @JsonProperty("pdessadr_id")
  private Integer              id_adresseDesserte;

  /**
   * Type d'habitation
   * 
   * @var String
   */
  @JsonProperty("enum_thab")
  private String               typeHabitation;

  /**
   * Etage
   * 
   * @var String
   */
  @JsonProperty("etage")
  private String               etage;

  /**
   * Appartement
   * 
   * @var String
   */
  @JsonProperty("numapt")
  private String               appartement;

  /**
   * Identifiant de la tournée
   * 
   * @var Integer
   */
  @JsonProperty("tournee_id")
  private Integer              id_tournee;

  /**
   * Actif
   * 
   * @var Boolean
   */
  @JsonProperty("actif")
  @JsonDeserialize(using = CustomBooleanDeserializer.class)
  private Boolean              actif;

  /**
   * Date de début
   * 
   * @var Date
   */
  @JsonProperty("datedeb")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date                 dateDebut;

  /**
   * Date de début
   * 
   * @var Date
   */
  @JsonProperty("datefin")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date                 dateFin;

  /**
   * Identifiant externe
   * 
   * @var Integer
   */
  @JsonProperty("ident_externe")
  private Integer              id_externe;

  /**
   * Compteur
   * 
   * @var CompteurModel
   */
  @Relationship("compteur")
  private CompteurModel        compteur;

  /**
   * Adresse de desserte
   * 
   * @var AdresseDesserteModel
   */
  @Relationship("pdessadr")
  private AdresseDesserteModel adresseDesserte;

  /**
   * Contrat actif
   * 
   * @var ContratModel
   */
  @Relationship("contratactif")
  private ContratModel         contratActif;

  /**
   * Tournée
   * 
   * @var TourneeModel
   */
  @Relationship("tournee")
  private TourneeModel         tournee;

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
   * @param Integer p_id
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
   * @param String p_numero
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
   * @param Integer p_idTournee
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
   * @param Integer p_idCompteur
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
   * @param String p_typeHabitation
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
   * @param String p_etage
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
   * @param String p_appartement
   * 
   * @return PointDeConsommationModel
   */
  public PointDeConsommationModel setAppartement(String p_appartement) {
    this.appartement = p_appartement;
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
   * @param Integer p_idExterne
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
