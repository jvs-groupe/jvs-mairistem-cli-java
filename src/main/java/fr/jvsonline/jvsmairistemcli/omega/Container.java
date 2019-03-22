package fr.jvsonline.jvsmairistemcli.omega;

import java.util.List;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationType;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;

/**
 * Container
 * 
 * @author jeromeklam
 */
public class Container {
  
  /**
   * Enumérations
   */
  List<EnumerationModel> enums;
  
  /**
   * Enumération 1
   */
  EnumerationModel primaryEnum = null;
  
  /**
   * Constructor
   */
  public Container() {
  }

  /**
   * Set énumérations
   * 
   * @param p_enums Enumérations
   * 
   * @return Container
   */
  public Container setEnums(List<EnumerationModel> p_enums) {
    this.enums = p_enums;
    for (EnumerationModel item : this.enums) {
      if (item.getId() == 1) {
        this.primaryEnum = item;
        break;
      }
    }
    return this;
  }
  
  /**
   * Get enums
   * 
   * @return List
   */
  public List<EnumerationModel> getEnums() {
    return this.enums;
  }
  
  /**
   * Get libellé pour une énumération
   * 
   * @param p_codeEnumeration Code de l'énumération
   * @param p_value Valeur
   * 
   * @return LigneEnumerationModel
   */
  public LigneEnumerationModel getLigneEnumeration(EnumerationType p_codeEnumeration, String p_value) {
    LigneEnumerationModel ligenum = null;
    if (p_value != null) {
      String codeEnum = p_codeEnumeration.getCode();
      Integer id = 0;
      if (this.primaryEnum != null) {
        for (LigneEnumerationModel itemL : this.primaryEnum.getLignes()) {
          if (itemL.getCode().equals(codeEnum)) {
            String libc = itemL.getLibelleCourt();
            libc = libc.replace("T_ENUM(", "").replace(")", "");
            id = Integer.valueOf(libc);
            break;
          }
        }
      }
      if (id > 0) {
        for (EnumerationModel itemE : this.enums) {
          if (itemE.getId() == id) {
            for (LigneEnumerationModel itemL : itemE.getLignes()) {
              if (itemL.getCode().equals(p_value)) {
                ligenum = itemL;
                break;
              }
            }
            break;
          }
        }
      }
    }
    return ligenum;
  }
}
