package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
//import fr.jvsonline.jvsmairistemcli.model.AdresseModel;
//import fr.jvsonline.jvsmairistemcli.core.AdresseInterface;

import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * PointDeConsommationModel
 */
@Type("POGRC_Pconso")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PointDeConsommationModel extends BaseModel { // implements AdresseInterface {

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
	private Integer id_point_desserte;

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
	private Integer id_adresse_desserte;

	/**
	 * Type d'habitation
	 */
	@JsonProperty("enum_thab")
	private String type_habitation;

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
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Date de début
	 */
	@JsonProperty("datedeb")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date date_debut;

	/**
	 * Date de début
	 */
	@JsonProperty("datefin")
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date date_fin;

	/**
	 * Ordre de relève
	 */
	@JsonProperty("noordrlv")
	private Integer numero_ordre_releve;

	/**
	 * Complément du numéro d'ordre de relève
	 */
	@JsonProperty("cpltnoordrlv")
	private Integer complement_numero_ordre_releve;

	/**
	 * Clef de localisation
	 */
	@JsonProperty("cleloc")
	private String clef_localisation;

	/**
	 * Coordonnées SIG
	 */
	@JsonProperty("sigcoord")
	private String coordonnee_sig;

	/**
	 * Coordonnées GPS
	 */
	@JsonProperty("coordgpsdl")
	private String coordonnee_gps;

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
	 * Adresse de desserte
	 */
	@Relationship("pdessadr")
	private AdresseDesserteModel adresse_desserte;

	/**
	 * Compteur
	 */
	@Relationship("compteur")
	private CompteurModel compteur;

	/**
	 * Tournée
	 */
	@Relationship("tournee")
	private TourneeModel tournee;

	/**
	 * Dernier relevé
	 */
	@Relationship("dernierreleve")
	private ReleveModel dernier_releve;

	/**
	 * Liste des propriétaires liés au point de consommation
	 */
	@Relationship("proprietaires")
	private List<ProprietaireModel> proprietaires;

	/**
	 * Propriétaire actif
	 */
	@Relationship("proprietaire_actif")
	private ProprietaireModel proprietaire_actif;

	/**
	 * Contrats
	 */
	@Relationship("contrats")
	private List<ContratModel> contrats = null;

	/**
	 * Contrat actif
	 */
	@Relationship("contrat_actif")
	private ContratModel contrat_actif;

	/**
	 * Dernier relevè
	 */
	@Relationship("dernierreleve")
	private ReleveModel dernierreleve;

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
	 * Get actif
	 * 
	 * @return Boolean
	 */
	@JsonIgnore
	public Boolean getActif() {
		return this.actif;
	}

	/**
	 * Get actif
	 * 
	 * @return Boolean
	 */
	public Boolean isActif() {
		return this.actif;
	}

	/**
	 * Set actif
	 * 
	 * @param p_actif actif
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setActif(Boolean p_actif) {
		this.actif = p_actif;
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
	 * Get type_habitation
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getTypeHabitation() {
		return this.type_habitation;
	}

	/**
	 * Set type_habitation
	 * 
	 * @param p_type_habitation type_habitation
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setTypeHabitation(String p_type_habitation) {
		this.type_habitation = p_type_habitation;
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
	 * Get numero_ordre_releve
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getNumeroOrdreReleve() {
		return this.numero_ordre_releve;
	}

	/**
	 * Set numero_ordre_releve
	 * 
	 * @param p_numero Numéro
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setNumeroOrdreReleve(Integer p_numero_ordre_releve) {
		this.numero_ordre_releve = p_numero_ordre_releve;
		return this;
	}

	/**
	 * Get complement_numero_ordre_releve
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getComplementNumeroOrdreReleve() {
		return this.complement_numero_ordre_releve;
	}

	/**
	 * Set complement_numero_ordre_releve
	 * 
	 * @param p_complement_numero_ordre_releve complement_numero_ordre_releve
	 * 
	 * @return PointDeConsommationModel
	 */
	@JsonIgnore
	public PointDeConsommationModel getComplementNumeroOrdreReleve(Integer p_complement_numero_ordre_releve) {
		this.complement_numero_ordre_releve = p_complement_numero_ordre_releve;
		return this;
	}

	/**
	 * Get clef_localisation
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getClefLocalisation() {
		return this.clef_localisation;
	}

	/**
	 * Set clef_localisation
	 * 
	 * @param p_clef_localisation clef_localisation
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setClefLocalisatio(String p_clef_localisation) {
		this.clef_localisation = p_clef_localisation;
		return this;
	}

	/**
	 * Get coordonnee_sig
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCoordonneeSig() {
		return this.coordonnee_sig;
	}

	/**
	 * Set coordonnee_sig
	 * 
	 * @param p_coordonnee_sig coordonnee_sig
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setCoordonneeSig(String p_coordonnee_sig) {
		this.coordonnee_sig = p_coordonnee_sig;
		return this;
	}

	/**
	 * Get coordonnee_gps
	 * 
	 * @return String
	 */
	@JsonIgnore
	public String getCoordonneeGps() {
		return this.coordonnee_gps;
	}

	/**
	 * Set coordonnee_gps
	 * 
	 * @param p_coordonnee_gps coordonnee_gps
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setCoordonneeGps(String p_coordonnee_gps) {
		this.coordonnee_gps = p_coordonnee_gps;
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
	 * @param p_commentaire commentaire
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setCommentaire(String p_commentaire) {
		this.commentaire = p_commentaire;
		return this;
	}

	/**
	 * Get id_externe
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getIdExterne() {
		return this.id_externe;
	}

	/**
	 * Set id_externe
	 * 
	 * @param p_id_externe id_externe
	 * 
	 * @return PointDeConsommationModel
	 */
	public PointDeConsommationModel setIdExterne(Integer p_id_externe) {
		this.id_externe = p_id_externe;
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
	 * Get adresse_desserte
	 * 
	 * @return AdresseDesserteModel
	 */
	@JsonIgnore
	public AdresseDesserteModel getAdresseDesserte() {
		return this.adresse_desserte;
	}

	/**
	 * Get contrat_actif
	 * 
	 * @return ContratModel
	 */
	@JsonIgnore
	public ContratModel getContratActif() {
		return this.contrat_actif;
	}

	/**
	 * Get tournee
	 * 
	 * @return TourneeModel
	 */
	@JsonIgnore
	public TourneeModel getTournee() {
		return this.tournee;
	}

	/**
	 * Get dernier_releve
	 * 
	 * @return ReleveModel
	 */
	@JsonIgnore
	public ReleveModel getDernierReleve() {
		return this.dernier_releve;
	}

	/**
	 * Get new a releve
	 * 
	 * @return ReleveModel
	 */
	@JsonIgnore
	public ReleveModel getNouveauReleve() {
		ReleveModel unReleve = new ReleveModel();

		unReleve
			.setId(-1)
			.setIdPconso(this.id)
			.setIdCompteur(this.id_compteur)
			;

		if (this.dernier_releve != null) {
			unReleve
				.setDateAncienIndex(this.dernier_releve.getDateNouvelIndex())
				.setAncienIndex(this.dernier_releve.getNouvelIndex())
				.setDateNouvelIndex(new Date())
				.setNouvelIndex(this.dernier_releve.getNouvelIndex())
				.setCommentaire("Relevé via partenaire")
				;
		}

		return unReleve;
	}

	/**
	 * Get a adresse
	 * 
	 * @return AdresseModel
	 */
	public Object toAdresse() { //AdresseModel
		return null;
/*		
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
*/
	}

	/**
	 * Get proprietaire_actif
	 * 
	 * @return ProprietaireModel
	 */
	public ProprietaireModel getProprietaireActif() {
		return this.proprietaire_actif;
	}

	/**
	 * Get Latitude
	 * 
	 * @return Double
	 */
	public Double getLatitude() {
		return this.getWhichCoordonneeSig(0);
	}

	/**
	 * Get Longitude
	 * 
	 * @return Double
	 */
	public Double getLongitude() {
		return this.getWhichCoordonneeSig(1);
	}

	/**
	 * Get which coordonnees sig ?
	 * 
	 * @return Double
	 */
	public Double getAltitude() {
		return this.getWhichCoordonneeSig(2);
	}
	
	/**
	 * Get Altitude
	 * 
	 * @return Double
	 */
	private double getWhichCoordonneeSig(int p_parts) {
		Double db = 0.0;

		try {
			String[] parts = this.coordonnee_sig.split("\\|", 3);
			if (parts.length == 3) {
				db = Double.parseDouble(parts[p_parts]);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return db;
	}

	/**
	 * Get contrats
	 * 
	 * @return [ContratModel]
	 */
	public List<ContratModel> getContrats() {
		if (this.contrats == null) {
			this.contrats = new ArrayList<ContratModel>();
		}
		return this.contrats;
	}

	/**
	 * Get proprietaires
	 * 
	 * @return [ProprietaireModel]
	 */
	public List<ProprietaireModel> getProprietaires() {
		if (this.proprietaires == null) {
			this.proprietaires = new ArrayList<ProprietaireModel>();
		}
		return this.proprietaires;
	}

	/**
	 * Get consumption of last releve
	 * 
	 * @return Integer
	 */
	public Integer getConsommationDernierReleve() {
		if (this.dernier_releve != null) {
			return this.dernier_releve.getConsommationRelevee();
		}
		return 0;
	}

	/**
	 * Get index of last releve
	 * 
	 * @return Integer
	 */
	public Integer getIndexDernierReleve() {
		if (this.dernier_releve != null) {
			return this.dernier_releve.getNouvelIndex();
		}
		return 0;
	}

	/**
	 * Get numero_voie of adresse_desserte
	 * 
	 * @return String
	 */
	public String getNumeroVoie() {
		AdresseDesserteModel adresse_desserte = this.getAdresseDesserte();
		if (adresse_desserte != null) {
			return adresse_desserte.getNumeroVoie();
		}
		return "";
	}

	/**
	 * Get nom_voie of adresse_desserte
	 * 
	 * @return String
	 */
	public String getNomVoie() {
		AdresseDesserteModel adresse_desserte = this.getAdresseDesserte();
		if (adresse_desserte != null) {
			return adresse_desserte.getNomVoie();
		}
		return "";
	}

	/**
	 * Get complement_numero_voie of adresse_desserte
	 * 
	 * @return String
	 */
	public String getComplementNumeroVoie() {
		AdresseDesserteModel adresse_desserte = this.getAdresseDesserte();
		if (adresse_desserte != null) {
			return adresse_desserte.getComplementNumeroVoie();
		}
		return "";
	}

	/**
	 * Get code_postal_ville of adresse_desserte
	 * 
	 * @return String
	 */
	public String getCodePostalVille() {
		AdresseDesserteModel adresse_desserte = this.getAdresseDesserte();
		if (adresse_desserte != null) {
			return adresse_desserte.getCodePostalVille();
		}
		return "";
	}

	/**
	 * Get nom_ville of adresse_desserte
	 * 
	 * @return String
	 */
	public String getNomVille() {
		AdresseDesserteModel adresse_desserte = this.getAdresseDesserte();
		if (adresse_desserte != null) {
			return adresse_desserte.getNomVille();
		}
		return "";
	}
}
