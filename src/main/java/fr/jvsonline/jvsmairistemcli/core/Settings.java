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
   * @var String
   */
  String version = "";

  /**
   * Artifact Id
   * @var String
   */
  String artifactId = "";

  /**
   * Group Id
   * @var String
   */
  String groupId = "";

  /**
   * WS End-Point
   * @var String
   */
  String wsEndpoint = "";

  /**
   * Application Id
   * @var String
   */
  String wsApiId = "";

  /**
   * Hawk Auth Id
   * @var String
   */
  String wsHawkId = "";

  /**
   * Hawk Auth Key
   * @var String
   */
  String wsHawkKey = "";
  
  /**
   * Instance
   * @var Settings
   */
  private static Settings instance = null;

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
        throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
      }
    } catch (Exception e) {
      System.out.println(e);
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
   * @throws NullPointerException
   * @return the wsEndpoint
   */
  public String getWsEndpoint() {
    if (this.wsEndpoint == null) {
      throw new NullPointerException("ws.endpoint property cannot be null !");
    }
    return this.wsEndpoint;
  }

  /**
   * @return the version
   */
  public String getVersion() {
    if (this.version == null) {
      throw new NullPointerException("version property cannot be null !");
    }
    return this.version;
  }

  /**
   * @return the wsApiId
   */
  public String getWsApiId() {
    return this.wsApiId;
  }

  /**
   * @return the wsHawkId
   */
  public String getWsHawkId() {
    return this.wsHawkId;
  }

  /**
   * @return the wsHawkKey
   */
  public String getWsHawkKey() {
    return this.wsHawkKey;
  }
}
