package fr.jvsonline.jvsmairistemcli.core;

import java.util.Locale;

/**
 * AuthType
 * 
 * @author jeromeklam
 * @package Auth
 */
public enum AuthType {
  /**
   * Authentication via an Authentication HTTP header
   */
  HEADER,
  /**
   * Authentication via a bewit query parameter
   */
  BEWIT;

  @Override
  public String toString() {
    return super.toString().toLowerCase(Locale.ENGLISH);
  }

  /**
   * @param String authType
   * 
   * @throws Exception
   * 
   * @return AuthType
   */
  public static AuthType parse(final String authType) throws Exception {
    try {
      return valueOf(authType.toUpperCase(Locale.ENGLISH));
    } catch (IllegalArgumentException ex) {
      throw new Exception("Hawk authentication type \"" + authType + "\" is invalid");
    }
  }
}
