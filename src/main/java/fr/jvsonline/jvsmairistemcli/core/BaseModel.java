package fr.jvsonline.jvsmairistemcli.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.regex.Pattern;

import fr.jvsonline.jvsmairistemcli.core.Loggable;
import fr.jvsonline.jvsmairistemcli.core.BaseModelInterface;
import fr.jvsonline.jvsmairistemcli.core.RequestParameters;

/**
 * BaseModel
 * 
 * @author jeromeklam
 */
public class BaseModel extends Loggable {

  
  /**
   * Constructor
   */
  public BaseModel() {
  }
  
  /**
   * Get filter
   * 
   * @param p_fieldName Nom du champ
   * 
   * @return String
   */
  public String getWSFieldName(String p_fieldName) {
    String ret = "";
    if (!p_fieldName.equals("")) {
      String fieldName = p_fieldName;
      String fieldEnd  = "";
      if (fieldName.contains(".")) {
        String[] items = fieldName.split(Pattern.quote("."));
        fieldName = items[0];
        items = Arrays.copyOfRange(items, 1, items.length);
        fieldEnd = String.join(".", items);
      }
      Class<?> objectClass = this.getClass();
      Field[] fields = objectClass.getDeclaredFields();
      //Annotation[] annots = objectClass.getAnnotations();
      /*for (Annotation annot : annots) {
        System.out.println(annot.toString());
      }*/
      Object value = null;
      for (Field field : fields) {
        if (field.getName().equals(fieldName)) {
          Annotation[] annotsF = field.getAnnotations();
          for (Annotation annot : annotsF) {
            Class<? extends Annotation> type = annot.annotationType();
            boolean relation = false;
            if (type.getName().equals("com.github.jasminb.jsonapi.annotations.Relationship")) {
              try {
                Method method = type.getMethod("value");
                value = method.invoke(annot, (Object[]) null);
                relation = true;
              } catch (Exception e) {
                this.logger.error(e.getMessage());
              }
            } else {
              if (type.getName().equals("com.fasterxml.jackson.annotation.JsonProperty")) {
                try {
                  Method method = type.getMethod("value");
                  value = method.invoke(annot, (Object[]) null);
                } catch (Exception e) {
                  this.logger.error(e.getMessage());
                }
              }
            }
            if (value != null) {
              if (relation) {
                Class<?> myClass = field.getType();
                try {
                  BaseModelInterface myObject = (BaseModelInterface) myClass.getConstructor().newInstance();
                  ret = value.toString() + '.' + myObject.getWSFieldName(fieldEnd);
                } catch (Exception e) {
                  this.logger.error(e.getMessage());
                }
              } else {
                ret = value.toString();
              }
              break;
            }
          }
          if (value != null) {
            break;
          }
        }
      }
    }
    if (ret == "") {
      throw new InvalidParameterException("Paramètre incorrect : " + p_fieldName + " !");
    }
    return ret;
  }
}
