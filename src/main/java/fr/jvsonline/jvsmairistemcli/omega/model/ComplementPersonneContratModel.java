package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import fr.jvsonline.jvsmairistemcli.jackson.CustomDateDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Complément de personne
 * 
 * @author jeromeklam
 */
@Type("Partner_Perscont")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComplementPersonneContratModel extends BaseModel implements BaseModelInterface {

  /**
   * Identifiant
   */
  @Id(IntegerIdHandler.class)
  @JsonProperty("perscont_id")
  private Integer id;
  
  /**
   * Date de début
   */
  @JsonProperty("datearr")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateArrivee;
  
  /**
   * Date de départ
   */
  @JsonProperty("datedep")
  @JsonDeserialize(using = CustomDateDeserializer.class)
  private Date dateDepart;
  
  /**
   * Constructor
   */
  public ComplementPersonneContratModel() {
  }
  
  /**
   * Retourne la date d'arrivée
   * 
   * @return Date
   */
  public Date getDateArrivee() {
    return this.dateArrivee;
  }
  
  /**
   * Retourne la date de départ
   * 
   * @return Date
   */
  public Date getDateDepart() {
    return this.dateDepart;
  }
}