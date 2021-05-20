package fr.jvsonline.jvsmairistemcli.omega.model;


import fr.jvsonline.jvsmairistemcli.omega.Container;

import fr.jvsonline.jvsmairistemcli.core.Tools;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.core.PersonneInterface;

import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * PersonneModel
 */
@Type("POGRC_Personne")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonneModel extends BaseModel implements PersonneInterface {

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
	private String civilite; // via getCodeCivilite et le libellé via getCivilite

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
	private String complement_nom;

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
	private String code_postal;

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
	 * Téléphone mobile
	 */
	@JsonProperty("telmobile")
	private String telephone_mobile;

	/**
	 * Téléphone
	 */
	@JsonProperty("teltravail")
	private String telephone_travail;

	/**
	 * Numéro de TVA
	 */
	@JsonProperty("numtva")
	private String numero_tva; // via getTva

	/**
	 * Numéro de SIRET
	 */
	@JsonProperty("numerosiret")
	private String numero_siret; // via getSiret

	/**
	 * Voie actif
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Catégorie de tiers
	 */
	@JsonProperty("enum_ctier")
	private String categorie_tiers;

	/**
	 * Nature juridique
	 */
	@JsonProperty("enum_natju")
	private String nature_juridique;

	/**
	 * Constructor
	 */
	public PersonneModel() {
	}

	/**
	 * Get id
	 * 
	 * @return Integer
	 */
	@JsonIgnore
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set id
	 * 
	 * @param p_id id
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get libellé de la civilité
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
	 * Get civilite
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
	 * Set civilite
	 * 
	 * @param p_civilite civilite
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setCodeCivilite(String p_civilite) {
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
	 * @param p_nom nom
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setNom(String p_nom) {
		this.nom = p_nom;
		return this;
	}

	/**
	 * Get prenom
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
	 * Set prenom
	 * 
	 * @param p_prenom prenom
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setPrenom(String p_prenom) {
		this.prenom = p_prenom;
		return this;
	}

	/**
	 * Get complement_nom
	 * 
	 * @return String
	 */
	public String getComplementNom() {
		if (this.complement_nom != null) {
			return this.complement_nom;
		}
		return "";
	}

	/**
	 * Set complement_nom
	 * 
	 * @param p_complement_nom complement_nom
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setComplementNom(String p_complement_nom) {
		this.complement_nom = p_complement_nom;
		return this;
	}
	
	/**
	 * Get adresse1
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
	 * Set adresse1
	 * 
	 * @param p_adresse1 adresse1
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setAdresse1(String p_adresse1) {
		this.adresse1 = p_adresse1;
		return this;
	}

	/**
	 * Get adresse2
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
	 * Set adresse2
	 * 
	 * @param p_adresse2 adresse2
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setAdresse2(String p_adresse2) {
		this.adresse2 = p_adresse2;
		return this;
	}

	/**
	 * Get adresse3
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
	 * Set adresse3
	 * 
	 * @param p_adresse3 adresse3
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setAdresse3(String p_adresse3) {
		this.adresse3 = p_adresse3;
		return this;
	}

	/**
	 * Get code_postal
	 * 
	 * @return String
	 */
	public String getCodePostal() {
		if (this.code_postal != null) {
			return this.code_postal;
		}
		return "";
	}

	/**
	 * Set code_postal
	 * 
	 * @param p_code_postal code_postal
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setCodePostal(String p_code_postal) {
		this.code_postal = p_code_postal;
		return this;
	}

	/**
	 * Get ville
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
	 * Set ville
	 * 
	 * @param p_ville ville
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setVille(String p_ville) {
		this.ville = p_ville;
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
	 * @param p_pays pays
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setPays(String p_pays) {
		this.pays = p_pays;
		return this;
	}

	/**
	 * Get telephone
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
	 * Set telephone
	 * 
	 * @param p_telephone telephone
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setTelephone(String p_telephone) {
		this.telephone = p_telephone;
		return this;
	}

	/**
	 * Get fax
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
	 * Set fax
	 * 
	 * @param p_fax fax
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setFax(String p_fax) {
		this.fax = p_fax;
		return this;
	}

	/**
	 * Get email
	 * 
	 * @param p_email email
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setEmail(String p_email) {
		this.email = p_email;
		return this;
	}

	/**
	 * Set email
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
	 * Get telephone_mobile
	 * 
	 * @return String
	 */
	public String getTelephoneMobile() {
		if (this.telephone_mobile != null) {
			return this.telephone_mobile;
		}
		return "";
	}

	/**
	 * Set telephone_mobile
	 * 
	 * @param p_telephone_mobile telephone_mobile
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setTelephoneMobile(String p_telephone_mobile) {
		this.telephone_mobile = p_telephone_mobile;
		return this;
	}

	/**
	 * Get telephone_travail
	 * 
	 * @return String
	 */
	public String getTelephoneTravail() {
		if (this.telephone_travail != null) {
			return this.telephone_travail;
		}
		return "";
	}

	/**
	 * Set telephone_travail
	 * 
	 * @param p_telephone_travail telephone_travail
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setTelephoneTravail(String p_telephone_travail) {
		this.telephone_travail = p_telephone_travail;
		return this;
	}

	/**
	 * Get numero_tva
	 * 
	 * @return String
	 */
	public String getTva() {
		if (this.numero_tva != null) {
			return this.numero_tva;
		}
		return "";
	}

	/**
	 * Set numero_tva
	 * 
	 * @param p_numero_tva numero_tva
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setTva(String p_numero_tva) {
		this.numero_tva = p_numero_tva;
		return this;
	}

	/**
	 * Get numero_siret
	 * 
	 * @return String
	 */
	public String getSiret() {
		if (this.numero_siret != null) {
			return this.numero_siret;
		}
		return "";
	}

	/**
	 * Set numero_siret
	 * 
	 * @param p_numero_siret numero_siret
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setSiret(String p_numero_siret) {
		this.numero_siret = p_numero_siret;
		return this;
	}

	/**
	 * Get actif
	 * 
	 * @return Boolean
	 */
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
	 * @return PersonneModel
	 */
	public PersonneModel setActif(Boolean p_actif) {
		this.actif = p_actif;
		return this;
	}


	/**
	 * Get code catégorie de tiers
	 * 
	 * @return String
	 */
	public String getCodeCategorieTiers() {
		if (this.categorie_tiers != null) {
			return this.categorie_tiers;
		}
		return "";
	}

	/**
	 * Get categorie_tiers
	 * 
	 * @return String
	 */
	public String getCategorieTiers() {
		if (this.categorie_tiers != null) {
			Container omegaContainer = Container.getInstance();
			return omegaContainer.getLibelleCategorieTiers(this.categorie_tiers);
		}
		return "";
	}

	/**
	 * Set categorie_tiers
	 * 
	 * @param p_categorie_tiers categorie_tiers
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setCategorieTiers(String p_categorie_tiers) {
		this.categorie_tiers = p_categorie_tiers;
		return this;
	}

	/**
	 * Get code nature juridique
	 * 
	 * @return String
	 */
	public String getCodeNatureJuridique() {
		if (this.nature_juridique != null) {
			return this.nature_juridique;
		}
		return "";
	}

	/**
	 * Get nature_juridique
	 * 
	 * @return String
	 */
	public String getNatureJuridique() {
		if (this.nature_juridique != null) {
			Container omegaContainer = Container.getInstance();
			return omegaContainer.getLibelleNatureJuridique(this.nature_juridique);
		}
		return "";
	}
	
	/**
	 * Set nature_juridique
	 * 
	 * @param p_nature_juridique nature_juridique
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel setNatureJuridique(String p_nature_juridique) {
		this.nature_juridique = p_nature_juridique;
		return this;
	}

	// DES EXTRAS ///////////////////////////////////////////

	/**
	 * Convert to Person
	 * 
	 * @return fr.jvsonline.jvsmairistemcli.model.PersonneModel
	 */
	@JsonIgnore
	public fr.jvsonline.jvsmairistemcli.model.PersonneModel toPersonne() {
		fr.jvsonline.jvsmairistemcli.model.PersonneModel personne = new fr.jvsonline.jvsmairistemcli.model.PersonneModel();

		personne
			.setCivilite(this.getCivilite())
			.setNom(this.nom)
			.setPrenom(this.prenom)
			;

		personne.setFullAdresse(this.adresse1, this.adresse2, this.adresse3);

		personne
			.setCodePostal(this.code_postal)
			.setVille(this.ville)
			.setPays(this.pays)
			;

		return personne;
	}

	/**
	 * Get nom complet
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
