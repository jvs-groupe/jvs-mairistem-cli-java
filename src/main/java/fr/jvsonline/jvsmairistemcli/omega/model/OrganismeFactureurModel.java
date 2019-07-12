package fr.jvsonline.jvsmairistemcli.omega.model;

import com.github.jasminb.jsonapi.annotations.Type;
import fr.jvsonline.jvsmairistemcli.core.BaseModel;
import fr.jvsonline.jvsmairistemcli.jackson.CustomBooleanDeserializer;
import com.github.jasminb.jsonapi.annotations.Id;
import com.github.jasminb.jsonapi.IntegerIdHandler;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * OrganismeModel
 * 
 * @author jeromeklam
 */
@Type("Partner_Organism")
public class OrganismeFactureurModel extends OrganismeModel {
  
  /**
   * Constructeur
   */
  public OrganismeFactureurModel () {
    super();
  }
}