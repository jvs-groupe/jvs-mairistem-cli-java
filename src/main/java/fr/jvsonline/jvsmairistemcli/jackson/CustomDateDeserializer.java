package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.text.ParseException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CustomDateDeserializer
 * 
 * @author jeromeklam
 * @package Json
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {
  
  /**
   * @var long
   */
  private static final long serialVersionUID = 1L;
  
  /**
   * @var SimpleDateFormat
   */
  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

  /**
   * Constructor
   */
  public CustomDateDeserializer() {
    this(null);
  }

  /**
   * Constructor
   * 
   * @param Class p_c
   */
  public CustomDateDeserializer(Class<?> p_c) {
    super(p_c);
  }

  /**
   * Deserialize
   * 
   * @param JsonParser             p_jsonParser
   * @param DeserializationContext p_deserializationContext
   * 
   * @return Date
   */
  @Override
  public Date deserialize(JsonParser p_jsonParser, DeserializationContext p_deserializationContext)
      throws IOException, JsonProcessingException {
    String date = p_jsonParser.getText();
    try {
      return simpleDateFormat.parse(date);
    } catch (ParseException e) {
      throw new RuntimeException(e);
    }
  }
}
