package fr.jvsonline.jvsmairistemcli.core;

import java.net.URI;
import java.util.Base64;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.client.ClientRequestContext;
import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.AuthType;
import fr.jvsonline.jvsmairistemcli.core.Tools;

/**
 * Hawk
 * 
 * @author jeromeklam
 * @package Auth
 */
public class Hawk extends Loggable {

  /**
   * Hawk Id
   * @var String
   */
  private final String id;
  
  /**
   * Hawk Key
   * @var String
   */
  private final String key;

  /**
   * Constructor
   * 
   * @param String p_id
   * @param String p_key
   */
  public Hawk(String p_id, String p_key) {
    this.id = p_id;
    this.key = p_key;
  }

  /**
   * Obtain the port of an URI
   * 
   * @param URI p_uri
   * 
   * @return int
   */
  private static int getPort(final URI p_uri) {
    int port = p_uri.getPort();
    if (port < 0) {
      if ("http".equals(p_uri.getScheme())) {
        port = 80;
      } else {
        if ("https".equals(p_uri.getScheme())) {
          port = 443;
        } else {
          port = 443;
        }
      }
    }
    return port;
  }

  /**
   * Calculate HMAC
   * 
   * @param AuthType p_authType
   * @param Long     p_timestamp
   * @param URI      p_uri
   * @param String   p_nonce
   * @param String   p_method
   * @param String   p_hash
   * @param String   p_ext
   * @param String   p_app
   * @param String   p_dlg
   * 
   * @return String
   */
  private static String calculateMAC(final AuthType p_authType, final Long p_timestamp, 
      final URI p_uri, final String p_nonce, final String p_method, final String p_hash,
      final String p_ext, final String p_app, final String p_dlg) {
    final StringBuilder sb = new StringBuilder(1024);
    sb.append("hawk.");
    sb.append("1");
    sb.append('.');
    sb.append(p_authType.toString());
    sb.append('\n');
    sb.append(p_timestamp);
    sb.append('\n');
    sb.append(p_nonce);
    sb.append('\n');
    sb.append(p_method.toUpperCase());
    sb.append('\n');
    sb.append(p_uri.getRawPath());
    if (p_uri.getQuery() != null) {
      sb.append('?');
      sb.append(p_uri.getRawQuery());
    }
    sb.append('\n');
    sb.append(p_uri.getHost().toLowerCase());
    sb.append('\n');
    sb.append(getPort(p_uri));
    sb.append('\n');
    sb.append(p_hash);
    sb.append('\n');
    sb.append(p_ext.replace("\\", "\\\\").replace("\n", "\\n"));
    sb.append('\n');
    if (p_app != null && p_app != "") {
      sb.append(p_app);
      sb.append('\n');
      sb.append(p_dlg);
      sb.append('\n');
    }
    return sb.toString();
  }

  /**
   * Get Full Hawk Header
   * 
   * @param ClientRequestContext p_requestContext
   * @param String               p_hash
   * @param String               p_ext
   * 
   * @return String
   */
  private String generateHawkHeader(ClientRequestContext p_requestContext, String p_hash, String p_ext) {
    // generate timestamp and nonce
    long timestamp = System.currentTimeMillis() / 1000L;
    final String nonce = Tools.randomString(6);
    // Get request as string
    String input = Hawk.calculateMAC(
      AuthType.HEADER,
      timestamp,
      p_requestContext.getUri(),
      nonce,
      p_requestContext.getMethod(),
      "",
      "",
      "",
      ""
    );
    // Encode hmac SHA256
    String output = "";
    try {
      Mac sha256_HMAC = Mac.getInstance("HMACSHA256");
      SecretKeySpec secret_key = new SecretKeySpec(this.key.getBytes("UTF-8"), "HMACSHA256");
      sha256_HMAC.init(secret_key);
      output = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(input.getBytes("UTF-8")));
    } catch (Exception ex) {
      this.logger.error(ex.getMessage());
    }
    // Generate Authorization string
    final StringBuilder sb = new StringBuilder(1024);
    sb.append("Hawk id=\"");
    sb.append(this.id);
    sb.append("\", ts=\"");
    sb.append(timestamp);
    sb.append("\", nonce=\"");
    sb.append(nonce);
    if (p_hash != null) {
      sb.append("\", hash=\"");
      sb.append(p_hash);
    }
    if ((p_ext != null) && (!"".equals(p_ext))) {
      sb.append("\", ext=\"");
      sb.append(p_ext);
    }
    sb.append("\", mac=\"");
    sb.append(output);
    sb.append('"');
    // End
    return sb.toString();
  }

  /**
   * Get Hask Header
   * 
   * @param ClientRequestContext p_requestContext
   * 
   * @return String
   */
  public String getHawkHeader(ClientRequestContext p_requestContext) {
    String header = this.generateHawkHeader(p_requestContext, "", "");
    this.logger.debug(header);
    return header;
  }
}
