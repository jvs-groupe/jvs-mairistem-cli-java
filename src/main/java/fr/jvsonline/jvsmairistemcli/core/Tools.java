package fr.jvsonline.jvsmairistemcli.core;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Random;

/**
 * Omega Tools
 * 
 * @author jeromeklam
 * @package Tool
 */
public class Tools {

  /**
   * Return a Resource
   * 
   * @param String p_rsc
   * 
   * @return InputStream
   */
  public static InputStream getResource(String p_rsc) {
    InputStream i = null;
    try {
      ClassLoader cLoader = Tools.class.getClassLoader();
      i = cLoader.getResourceAsStream(p_rsc);
    } catch (Exception e) {
      //System.out.println(e);
      // @todo
    }
    return i;
  }

  /**
   * Get random String
   * 
   * @param int p_maxLength
   * 
   * @return String
   */
  public static String randomString(final int p_maxLength) {
    String alphabet = new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");
    int n = alphabet.length();
    String result = new String();
    Random r = new Random();
    for (int i = 0; i < p_maxLength; i++) {
      result = result + alphabet.charAt(r.nextInt(n));
    }
    return result;
  }
  
  /**
   * Get String
   * 
   * @param String p_prefered
   * @param String p_default
   * 
   * @return String
   */
  public static String asString(String p_prefered, String p_default) {
    String ret = p_prefered;
    if (ret == null) {
      ret = p_default;
    }
    if (ret == null) {
      ret = "";
    }
    return ret;
  }
  
  /**
   * Vérify if field is present in object
   * 
   * @param String p_object
   * @param String p_fieldName
   * 
   * @return boolean
   */
  public static boolean doesObjectContainField(Object p_object, String p_fieldName) {
    Class<?> objectClass = p_object.getClass();
    Field[] fields = objectClass.getDeclaredFields();
    for (Field field : fields) {
      if (field.getName() == p_fieldName) {
        return true;
      }
    }
    return false;
  }
}
