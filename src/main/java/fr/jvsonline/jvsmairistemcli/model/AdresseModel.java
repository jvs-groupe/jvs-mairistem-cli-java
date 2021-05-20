package fr.jvsonline.jvsmairistemcli.model;

import java.util.Arrays;
import java.util.List;

import fr.jvsonline.jvsmairistemcli.core.Tools;

/**
 * AdresseModel
 */
public class AdresseModel {

	/**
	 * Identifiant de l'adresse
	 */
	private Integer id;

	/**
	 * Numéro de l'adresse
	 */
	private Integer numero;

	/**
	 * Complément du numéro
	 */
	private String complement_numero;

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
	private String code_voie;

	/**
	 * Article de la voie
	 */
	private String article_voie;

	/**
	 * Type de voie
	 */
	private String type_voie;

	/**
	 * Nom de la voie
	 */
	private String nom_voie;

	/**
	 * Complément du nom de la voie
	 */
	private String complement_nom;

	/**
	 * Identifiant de la ville
	 */
	private Integer id_ville;

	/**
	 * Code postal
	 */
	private String code_postal;

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
	private String code_pays;

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
	 * @param p_id id
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
	 * @param p_numero numero
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
	 * @param p_numero numero
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
	 * Get complement_numero
	 *
	 * @return String
	 */
	public String getComplementNumero() {
		if (this.complement_numero != null) {
			return complement_numero;
		}
		return "";
	}

	/**
	 * Set complement_numero
	 *
	 * @param p_complement_numero complement_numero
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setComplementNumero(String p_complement_numero) {
		this.complement_numero = p_complement_numero;
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
	 * @param p_etage etage
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
	 * @param p_appartement appartement
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
	 * @param p_id_voie id_voie
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setId_voie(Integer p_id_voie) {
		this.id_voie = p_id_voie;
		return this;
	}

	/**
	 * Get code_voie
	 *
	 * @return String
	 */
	public String getCodeVoie() {
		if (this.code_voie != null) {
			return this.code_voie;
		}
		return "";
	}

	/**
	 * Set code_voie
	 *
	 * @param p_code_voie code_voie
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setCodeVoie(String p_code_voie) {
		this.code_voie = p_code_voie;
		return this;
	}

	/**
	 * Get type_voie
	 *
	 * @return String
	 */
	public String getTypeVoie() {
		if (this.type_voie != null) {
			return this.type_voie;
		}
		return "";
	}

	/**
	 * Set type_voie
	 *
	 * @param p_type_voie type_voie
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setTypeVoie(String p_type_voie) {
		this.type_voie = p_type_voie;
		return this;
	}

	/**
	 * Get article_voie
	 * 
	 * @return String
	 */
	public String getArticleVoie() {
		if (this.article_voie != null) {
			return this.article_voie;
		}
		return "";
	}

	/**
	 * Set article_voie
	 * 
	 * @param p_article_voie article_voie
	 * 
	 * @return AdresseModel
	 */
	public AdresseModel setArticleVoie(String p_article_voie) {
		this.article_voie = p_article_voie;
		return this;
	}

	/**
	 * Get nom_voie
	 *
	 * @return String
	 */
	public String getNomVoie() {
		if (this.nom_voie != null) {
			return nom_voie;
		}
		return "";
	}

	/**
	 * Set nom_voie
	 *
	 * @param p_nom_voie nom_voie
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setNomVoie(String p_nom_voie) {
		this.nom_voie = p_nom_voie;
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
	 * @return AdresseModel
	 */
	public AdresseModel setComplementNom(String p_complement_nom) {
		this.complement_nom = p_complement_nom;
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
	 * @param p_id_ville id_ville
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setId_ville(Integer p_id_ville) {
		this.id_ville = p_id_ville;
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
	 * @return AdresseModel
	 */
	public AdresseModel setCodePostal(String p_code_postal) {
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
			return ville;
		}
		return "";
	}

	/**
	 * Set ville
	 *
	 * @param p_ville ville
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
	 * @param p_id_pays id_pays
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setId_pays(Integer p_id_pays) {
		this.id_pays = p_id_pays;
		return this;
	}

	/**
	 * Get code_pays
	 *
	 * @return String
	 */
	public String getCodePays() {
		if (this.code_pays != null) {
			return this.code_pays;
		}
		return "";
	}

	/**
	 * Set code_pays
	 *
	 * @param p_code_pays code_pays
	 *
	 * @return AdresseModel
	 */
	public AdresseModel setCodePays(String p_code_pays) {
		this.code_pays = p_code_pays;
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
		String[] wordsType = new String[] { "CHEMIN", "IMPASSE", "VOIE", "QUAI", "RUE", "ROUTE", "BOULEVARD", "AVENUE",
				"ALLEE", "AV", "BLD", "BLVD", "IMP", "QUARTIER", "PLACE", "IMP.", "BLVD.", "DOMAINE", "SQUARE",
				"ALLEES", "ANCIEN", "ANCIENNE", "CHEMINS", "ROUTES", "VIEUX", "BD", "HAMEAU", "CITE", "RESIDENCE",
				"RUELLE", "PL", "RTE" };
		List<String> listType = Arrays.asList(wordsType);
		String[] wordsArticle = new String[] { "DE", "LE", "LES", "LA", "DU", "L'", "DES", "D'", "AU", "AUX" };
		List<String> listArticle = Arrays.asList(wordsArticle);
		String work = p_adr1.toUpperCase();
		String[] words = work.split("[\\s\\t]+");
		Boolean added = false;

		this.article_voie = "";
		this.type_voie = "";
		this.nom_voie = "";

		for (String s : words) {
			added = false;
			if (listType.contains(s)) {
				if (this.type_voie == "" && this.nom_voie == "") {
					this.type_voie += " " + s;
					added = true;
				}
			} else {
				if (listArticle.contains(s)) {
					if (this.nom_voie == "") {
						this.article_voie += " " + s;
						added = true;
					}
				} else {
					if (this.type_voie == "" && this.nom_voie == "") {
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
				this.nom_voie += " " + s;
			}
		}

		this.article_voie = this.article_voie.trim();
		this.type_voie = this.type_voie.trim();
		this.nom_voie = this.nom_voie.trim();
		this.complement_nom = p_adr2;

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

		if (this.numero != null && this.numero > 0) {
			ret = this.numero.toString();
		}

		if (this.complement_numero != null && this.complement_numero.trim() != "") {
			ret = ret + (ret != "" ? " " : "") + this.complement_numero.trim();
		}
		if (this.nom_voie != null && this.nom_voie.trim() != "") {
			ret = ret + (ret != "" ? " " : "") + Tools.asString(this.type_voie.trim(), "") + " "
					+ Tools.asString(this.nom_voie.trim(), "");
		}

		if (this.complement_nom != null && this.complement_nom.trim() != "") {
			ret = (ret != "" ? "\n" : "") + this.complement_nom.trim();
		}

		ret = (ret != "" ? "\n" : "") + Tools.asString(this.code_postal.trim(), "") + " "
				+ Tools.asString(this.ville.trim(), "");

		return ret;
	}
}
