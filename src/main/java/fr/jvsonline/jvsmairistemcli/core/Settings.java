package fr.jvsonline.jvsmairistemcli.core;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.NullPointerException;
import java.util.Properties;
import fr.jvsonline.jvsmairistemcli.core.Tools;

/**
 * Omega global Settings from omegacli.properties
 * 
 * @author jeromeklam
 */
public class Settings {

  /**
   * Version
   */
  protected String        version    = "v1";

  /**
   * Artifact Id
   */
  protected String        artifactId = "JvsMairistemCli";

  /**
   * Group Id
   */
  protected String        groupId    = "fr.jvsonline.jvsmairistemcli";

  /**
   * WS End-Point
   */
  protected String        wsEndpoint = "";

  /**
   * Application Id
   */
  protected String        wsApiId    = "";

  /**
   * Hawk Auth Id
   */
  protected String        wsHawkId   = "";

  /**
   * Hawk Auth Key
   */
  protected String        wsHawkKey  = "";

  /**
   * Instance
   */
  private static Settings instance   = null;

  /**
   * Constructor 
   * 
   * @param p_config Configuration
   */
  protected Settings(String p_config) {
    if (p_config != null && p_config != "") {
      this.read(p_config);
    }
  }

  /**
   * Get Instance
   * 
   * @return Settings
   */
  public static Settings getInstance() {
    if (instance == null) {
      instance = new Settings("");
    }
    return instance;
  }

  /**
   * Get Instance
   * 
   * @param p_config Configuration
   * 
   * @return Settings
   */
  public static Settings getInstance(String p_config) {
    if (instance == null) {
      instance = new Settings(p_config);
    }
    return instance;
  }

  /**
   * Read config
   * 
   * @param p_config Condiguration
   */
  protected void read(String p_config) {
    InputStream inputStream;
    Properties properties = new Properties();
    String propFileName = p_config;
    inputStream = Tools.getResource(propFileName);
    try {
      if (inputStream != null) {
        properties.load(inputStream);
      } else {
        throw new FileNotFoundException(
            "property file '" + propFileName + "' not found in the classpath");
      }
    } catch (Exception e) {
      // System.out.println(e);
    }
    this.version = properties.getProperty("version");
    this.artifactId = properties.getProperty("artifactId");
    this.groupId = properties.getProperty("groupId");
    this.wsEndpoint = properties.getProperty("wsEndpoint");
    this.wsApiId = properties.getProperty("wsApiId");
    this.wsHawkId = properties.getProperty("wsHawkId");
    this.wsHawkKey = properties.getProperty("wsHawkKey");
  }

  /**
   * Get WS endpoint
   * 
   * @throws NullPointerException Si vide
   * 
   * @return the wsEndpoint
   */
  public String getWsEndpoint() {
    if (this.wsEndpoint == null) {
      throw new NullPointerException("ws.endpoint property cannot be null !");
    }
    return this.wsEndpoint;
  }

  /**
   * Set WS endpoint
   * 
   * @param p_endpoint Url du service web
   * 
   * @return Settings
   */
  public Settings setWsEndpoint(String p_endpoint) {
    this.wsEndpoint = p_endpoint;
    return this;
  }

  /**
   * Get the version
   * 
   * @return the version
   */
  public String getVersion() {
    if (this.version == null) {
      throw new NullPointerException("version property cannot be null !");
    }
    return this.version;
  }

  /**
   * Set version
   * 
   * @param p_version Version
   * 
   * @return Settings
   */
  public Settings setVersion(String p_version) {
    this.version = p_version;
    return this;
  }

  /**
   * @return the wsApiId
   */
  public String getWsApiId() {
    return this.wsApiId;
  }

  /**
   * Set API Id
   * 
   * @param p_api_id Id de l'application (broker)
   * 
   * @return Settings
   */
  public Settings setWsApiId(String p_api_id) {
    this.wsApiId = p_api_id;
    return this;
  }

  /**
   * @return the wsHawkId
   */
  public String getWsHawkId() {
    return this.wsHawkId;
  }

  /**
   * Set HAWK Id
   * 
   * @param p_hawk_id Identifiant Hawk
   * 
   * @return Settings
   */
  public Settings setWsHawkId(String p_hawk_id) {
    this.wsHawkId = p_hawk_id;
    return this;
  }

  /**
   * @return the wsHawkKey
   */
  public String getWsHawkKey() {
    return this.wsHawkKey;
  }

  /**
   * Set WS HAWK Key
   * 
   * @param p_hawk_key Clef Hawk (secret)
   * 
   * @return Settings
   */
  public Settings setWsHawkKey(String p_hawk_key) {
    this.wsHawkKey = p_hawk_key;
    return this;
  }
}
