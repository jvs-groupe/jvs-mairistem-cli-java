package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;

/**
 * CustomIntegerDeserializer
 * 
 * @author jeromeklam
 */
public class CustomIntegerDeserializer extends StdDeserializer<Integer> {

  /**
   * long
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor
   */
  public CustomIntegerDeserializer() {
    this(null);
  }

  /**
   * Constructor
   * @param p_c Class
   */
  public CustomIntegerDeserializer(Class<?> p_c) {
    super(p_c);
  }

  /**
   * deserialize
   * 
   * @param p_jsonParser json Parser
   * @param p_deserializationContext Context
   * 
   * @return Integer
   */
  @Override
  public Integer deserialize(JsonParser p_jsonParser, DeserializationContext p_deserializationContext)
      throws IOException, JsonProcessingException {
    String date = p_jsonParser.getText();
    try {
      return Integer.valueOf(date);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
