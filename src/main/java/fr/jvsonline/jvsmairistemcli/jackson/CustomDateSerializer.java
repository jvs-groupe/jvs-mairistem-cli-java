package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.text.ParseException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CustomDateDeserializer
 * 
 * @author jeromeklam
 */
public class CustomDateSerializer extends StdSerializer<Date> {
  
  /**
   * Formatter
   */
  private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
 
  /**
   * Serializer
   */
  public CustomDateSerializer() {
    this(null);
  }
 
  /**
   * Custom date serailisation
   * 
   * @param t object
   */
  public CustomDateSerializer(Class t) {
    super(t);
  }
  
  /**
   * Serialize
   */
  @Override
  public void serialize (Date value, JsonGenerator gen, SerializerProvider arg2)
    throws IOException, JsonProcessingException {
      gen.writeString(formatter.format(value));
    }
}