package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * CustomBooleanDeserializer
 * 
 * @author jeromeklam
 */
public class CustomBooleanDeserializer extends StdDeserializer<Boolean> {

  /**
   * @var long
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor
   */
  public CustomBooleanDeserializer() {
    this(null);
  }

  /**
   * Constructor
   * 
   * @param p_c Class
   */
  public CustomBooleanDeserializer(Class<?> p_c) {
    super(p_c);
  }

  /**
   * Deserialize
   * 
   * @param p_jsonParser Json Parser
   * @param p_deserializationContext Context
   * 
   * @return Boolean
   */
  @Override
  public Boolean deserialize(JsonParser p_jsonParser, DeserializationContext p_deserializationContext)
      throws IOException, JsonProcessingException {
    String value = p_jsonParser.getText();
    if (value == "1" || value == "true" || value == "O") {
      return true;
    }
    return false;
  }
}
