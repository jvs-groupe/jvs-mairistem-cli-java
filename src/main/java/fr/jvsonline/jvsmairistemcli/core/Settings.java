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
 * @package Config
 */
public class Settings {

  /**
   * Version
   * 
   * @var String
   */
  protected String        version    = "v1";

  /**
   * Artifact Id
   * 
   * @var String
   */
  protected String        artifactId = "JvsMairistemCli";

  /**
   * Group Id
   * 
   * @var String
   */
  protected String        groupId    = "fr.jvsonline.jvsmairistemcli";

  /**
   * WS End-Point
   * 
   * @var String
   */
  protected String        wsEndpoint = "";

  /**
   * Application Id
   * 
   * @var String
   */
  protected String        wsApiId    = "";

  /**
   * Hawk Auth Id
   * 
   * @var String
   */
  protected String        wsHawkId   = "";

  /**
   * Hawk Auth Key
   * 
   * @var String
   */
  protected String        wsHawkKey  = "";

  /**
   * Instance
   * 
   * @var Settings
   */
  private static Settings instance   = null;

  /**
   * Constructor
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
   * @param String p_config
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
   * @param String p_config
   * 
   * @return void
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
   * @throws NullPointerException
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
   * @param String p_endpoint
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
   * @param String p_version
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
   * @param String p_api_id
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
   * @param String p_hawk_id
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
   * @param String p_hawk_key
   * 
   * @return Settings
   */
  public Settings setWsHawkKey(String p_hawk_key) {
    this.wsHawkKey = p_hawk_key;
    return this;
  }
}
