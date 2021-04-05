package fr.jvsonline.jvsmairistemcli.omega;

import java.util.List;

import fr.jvsonline.jvsmairistemcli.core.JsonApiWS;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.omega.manager.ArticleManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.CodificationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.EnumerationManager;
import fr.jvsonline.jvsmairistemcli.omega.manager.OrganismeFactureurManager;
import fr.jvsonline.jvsmairistemcli.omega.model.ArticleModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CodificationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.CodificationType;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.EnumerationType;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneCodificationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.LigneEnumerationModel;
import fr.jvsonline.jvsmairistemcli.omega.model.OrganismeFactureurModel;

/**
 * Container
 * 
 * @author jeromeklam
 */
public class Container extends Loggable {

  /**
   * Enumérations
   */
  List<EnumerationModel> enums = null;

  /**
   * Codifications
   */
  List<CodificationModel> codifs = null;

  /**
   * Articles
   */
  List<ArticleModel> articles = null;

  /**
   * Organisme factureur principal
   */
  OrganismeFactureurModel organisme_factureur = null;

  /**
   * Enumération 1
   */
  EnumerationModel primaryEnum = null;

  /**
   * Instance
   */
  private static Container INSTANCE = null;

  /**
   * Get singleton
   * 
   * @return Container
   */
  public static Container getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new Container();
    }
    return INSTANCE;
  }

  /**
   * Constructor
   */
  public Container() {
  }

  /**
   * Affectation des articles
   * 
   * @param p_articles Articles
   * 
   * @return Container
   */
  public Container setArticles(List<ArticleModel> p_articles) {
    this.articles = p_articles;
    return this;
  }

  /**
   * Retourne les articles
   * 
   * @return List
   */
  public List<ArticleModel> getArticles() {
    return this.articles;
  }
  
  /**
   * Affectation de l'organisme factureur
   * 
   * @param p_ofact Organisme factureur
   * 
   * @return Container
   */
  public Container setOrganismeFactureur(OrganismeFactureurModel p_ofact) {
    this.organisme_factureur = p_ofact;
    return this;
  }
  
  /**
   * Retourne l'organisme factureur principal
   * 
   * @return OrganismeFactureurModel
   */
  public OrganismeFactureurModel getOrganismeFactureur() {
    return this.organisme_factureur;
  }

  /**
   * Affectation des énumérations
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
   * Retourne les énumération
   * 
   * @return List
   */
  public List<EnumerationModel> getEnums() {
    return this.enums;
  }

  /**
   * Affectation des codifications
   * 
   * @param p_codifs Codifications
   * 
   * @return Container
   */
  public Container setCodifs(List<CodificationModel> p_codifs) {
    this.codifs = p_codifs;
    return this;
  }

  /**
   * Retourne les codifications
   * 
   * @return List
   */
  public List<CodificationModel> getCodifs() {
    return this.codifs;
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
            List<LigneEnumerationModel> lignes = itemE.getLignes();
            if (lignes != null) {
              for (LigneEnumerationModel itemL : lignes) {
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
    }
    return ligenum;
  }

  /**
   * Retourne une ligne de codification
   * 
   * @param p_code  Code codification
   * @param p_value Valeur à rechercher
   * 
   * @return LigneCodificationModel
   */
  public LigneCodificationModel getLigneCodification(CodificationType p_code, String p_value) {
    LigneCodificationModel ligne = null;
    if (this.codifs != null) {
      for (CodificationModel codif : this.codifs) {
        if (codif.getCodeListe().equals(p_code.getCode())) {
          List<LigneCodificationModel> lignes = codif.getLignes();
          if (lignes != null) {
            for (LigneCodificationModel lCodif : lignes) {
              if (lCodif.getCode().equals(p_value)) {
                ligne = lCodif;
                break;
              }
            }
            break;
          }
        }
      }
    }
    return ligne;
  }

  /**
   * Libellé de la civilité
   * 
   * @param p_value Valeur
   * 
   * @return String
   */
  public String getLibelleCivilite(String p_value) {
    LigneEnumerationModel ligenum = this.getLigneEnumeration(EnumerationType.CIVILITE, p_value);
    if (ligenum != null) {
      return ligenum.getLibelle();
    }
    return "";
  }

  /**
   * Libellé de la nature juridique
   * 
   * @param p_value Valeur
   * 
   * @return String
   */
  public String getLibelleNatureJuridique(String p_value) {
    LigneCodificationModel ligCodif = this.getLigneCodification(CodificationType.NATURE_JURIDIQUE, p_value);
    if (ligCodif != null) {
      return ligCodif.getLibelle();
    }
    return "";
  }

  /**
   * Libellé de la catégorie de tiers
   * 
   * @param p_value Valeur
   * 
   * @return String
   */
  public String getLibelleCategorieTiers(String p_value) {
    LigneCodificationModel ligCodif = this.getLigneCodification(CodificationType.CATEGORIE_TIERS, p_value);
    if (ligCodif != null) {
      return ligCodif.getLibelle();
    }
    return "";
  }
  
  /**
   * Initialisation des listes
   * 
   * @param p_wsClient Client API
   * 
   * @return Container
   */
  public Container init(JsonApiWS p_wsClient) {
    ArticleManager artManager = new ArticleManager(p_wsClient);
    CodificationManager codifManager = new CodificationManager(p_wsClient);
    EnumerationManager enumManager = new EnumerationManager(p_wsClient);
    OrganismeFactureurManager ofactManager = new OrganismeFactureurManager(p_wsClient);
    logger.info("   Récupération des codifications...");
    List<CodificationModel> myListC = codifManager.find();
    if (myListC == null) {
      logger.info("Empty result...");
    }
    this.setCodifs(myListC);
    logger.info("----------------------------------------------------------");
    logger.info("   Récupération des énumération...");
    List<EnumerationModel> myListE = enumManager.find();
    if (myListE == null) {
      logger.info("Empty result...");
    }
    this.setEnums(myListE);
    logger.info("----------------------------------------------------------");
    logger.info("   Récupération des articles...");
    artManager.setPage(1);
    artManager.setPageLimit(100);
    artManager.addRequestParameter("actif", "1");
    List<ArticleModel> myListArts = artManager.find();
    if (myListArts == null) {
      logger.info("Empty result...");
    }
    this.setArticles(myListArts);
    //omegaContainer.setEnums(myListE);
    logger.info("----------------------------------------------------------");
    logger.info("   Récupération des organismes factureurs...");
    ofactManager.setPage(1);
    ofactManager.setPageLimit(100);
    List<OrganismeFactureurModel> myListOfacts = ofactManager.find();
    if (myListOfacts == null) {
      logger.info("Empty result...");
    } else {
      for (OrganismeFactureurModel item : myListOfacts) {
        logger.info("Ofact " + item.getNom());
        this.setOrganismeFactureur(item);
        break;
      }
    }
    logger.info("----------------------------------------------------------");
    return this;
  }
}
