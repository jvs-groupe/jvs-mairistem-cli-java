package fr.jvsonline.jvsmairistemcli.omega.model;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanToIntSerializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;

import com.github.jasminb.jsonapi.annotations.Type;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.annotations.Relationship;
import com.github.jasminb.jsonapi.IntegerIdHandler;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * ContratModel
 */
@Type("POGRC_Contrat")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContratModel extends BaseModel {

	/**
	 * Identifiant du contrat
	 */
	@Id(IntegerIdHandler.class)
	@JsonProperty("contrat_id")
	private Integer id;

	/**
	 * Identifiant du point de consommation
	 */
	@JsonProperty("pconso_id")
	private Integer id_pconso; // sera affecté via la relationships 'pconso'

	/**
	 * Numéro de contrat
	 */
	@JsonProperty("numcontrat")
	private String numero_contrat; // via getNumero 

	/**
	 * Contrat actif
	 */
	@JsonProperty("actif")
	@JsonDeserialize(using = CustomBooleanDeserializer.class) // nécessaire car on reçoit 'actif': 1
	@JsonSerialize(using = CustomBooleanToIntSerializer.class) // nécessaire pour avoir 'actif': 1 si true. 0 dans le cas contraire.
	private Boolean actif;

	/**
	 * Contrat principal
	 */
	@JsonProperty("principal")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	@JsonSerialize(using = CustomBooleanToIntSerializer.class)
	private Boolean principal;

	/**
	 * Contrat suspendu
	 */
	@JsonProperty("suspendu")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	@JsonSerialize(using = CustomBooleanToIntSerializer.class)
	private Boolean suspendu;

	/**
	 * Contrat à facturer
	 */
	@JsonProperty("facturer")
	@JsonDeserialize(using = CustomBooleanDeserializer.class)
	@JsonSerialize(using = CustomBooleanToIntSerializer.class)
	private Boolean facturer;

	/**
	 * Abo1
	 */
	@JsonProperty("abo1")
	private Integer abo1; // via getGroupe1

	/**
	 * Abo2
	 */
	@JsonProperty("abo2")
	private Integer abo2; // via getGroupe2

	/**
	 * Nombre
	 */
	@JsonProperty("nombre")
	private Integer nombre;

	/**
	 * Type de contrat
	 */
	@JsonProperty("enum_tcon")
	private String type_contrat;

	/**
	 * Nature de contrat
	 */
	@JsonProperty("enum_natcont")
	private String nature_contrat;

	/**
	 * Sous-type de contrat
	 */
	@JsonProperty("enum_stcont")
	private String sous_type_contrat;

	/**
	 * Date de début
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("datedeb")
	private Date date_debut;

	/**
	 * Date de fin
	 */
	@JsonDeserialize(using = CustomDateDeserializer.class)
	@JsonProperty("datefin")
	private Date date_fin;

	/**
	 * Identifiant de la nature d'abonné
	 */
	@JsonProperty("natabo_id")
	private Integer id_nature_abonne;

	// DECLARATIONS RELATIONSHIPS ///////////////////////////

	/**
	 * Point de consommation
	 */
	@Relationship("pconso")
	private PointDeConsommationModel pconso;

	/**
	 * Occupant
	 */
	@Relationship("occupant")
	private PersonneModel occupant;

	/**
	 * Redevable
	 */
	@Relationship("redevable")
	private PersonneModel redevable;

	/**
	 * Nature d'abonné
	 */
	@Relationship("natabo")
	private NatureAbonneModel natabo;

	/**
	 * Consommes
	 */
	@Relationship("consommes")
	private List<ConsommeModel> consommes = null;

	/**
	 * Constructor
	 */
	public ContratModel() {
	}

	/**
	 * Get id
	 * 
	 * @return Integer
	 */
	public Integer getId() {
		return this.id;
	}

	/**
	 * Set id
	 * 
	 * @param p_id id
	 * 
	 * @return ContratModel
	 */
	public ContratModel setId(Integer p_id) {
		this.id = p_id;
		return this;
	}

	/**
	 * Get numero_contrat
	 * 
	 * @return String
	 */
	public String getNumero() {
		return this.numero_contrat;
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
	 * Get principal
	 * 
	 * @return Boolean
	 */
	public Boolean getPrincipal() {
		return this.principal;
	}

	/**
	 * Get principal
	 * 
	 * @return Boolean
	 */
	public Boolean isPrincipal() {
		return this.principal;
	}

	/**
	 * Get suspendu
	 * 
	 * @return Boolean
	 */
	public Boolean getSuspendu() {
		return this.suspendu;
	}

	/**
	 * Get suspendu
	 * 
	 * @return Boolean
	 */
	public Boolean isSuspendu() {
		return this.suspendu;
	}

	/**
	 * Get facturer
	 * 
	 * @return Boolean
	 */
	public Boolean getAFacturer() {
		return this.facturer;
	}

	/**
	 * Get facturer
	 * 
	 * @return Boolean
	 */
	public Boolean isAFacturer() {
		return this.facturer;
	}

	/**
	 * get abo1
	 * 
	 * @return Integer
	 */
	public Integer getGroupe1() {
		return this.abo1;
	}

	/**
	 * get abo2
	 * 
	 * @return Integer
	 */
	public Integer getGroupe2() {
		return this.abo2;
	}

	/**
	 * get nombre
	 * 
	 * @return Integer
	 */
	public Integer getNombre() {
		return this.nombre;
	}

	// RELATIONSHIPS ////////////////////////////////////////

	/**
	 * Get occupant
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel getOccupant() {
		return this.occupant;
	}

	/**
	 * Get redevable
	 * 
	 * @return PersonneModel
	 */
	public PersonneModel getRedevable() {
		return this.redevable;
	}

	/**
	 * Retourne la nature d'abonné
	 * 
	 * @return NatureAbonneModel
	 */
	public NatureAbonneModel getNatureAbonne() {
		return this.natabo;
	}

	/**
	 * Retourne les consommations
	 * 
	 * @return Consommes
	 */
	public List<ConsommeModel> getConsommes() {
		if (this.consommes == null) {
			this.consommes = new ArrayList<ConsommeModel>();
		}
		return this.consommes;
	}

	/**
	 * Retourne la dernière consommation relevée
	 * 
	 * @return Integer
	 */
	public Integer getDerniereConsommationRelevee() {
		if (this.consommes.size() > 0) {
			return this.consommes.get(0).getConsommationRelevee();
		}
		return 0;
	}

	/**
	 * Retourne la dernière consommation facturée
	 * 
	 * @return Integer
	 */
	public Integer getDerniereConsommationFacturee() {
		if (this.consommes.size() > 0) {
			return this.consommes.get(0).getConsommationFacturee();
		}
		return 0;
	}
}
