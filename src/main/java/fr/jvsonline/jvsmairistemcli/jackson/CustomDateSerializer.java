package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

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
	 * Constructor
	 */
	public CustomDateSerializer() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param p_c Class
	 */
	public CustomDateSerializer(Class p_c) {
		super(p_c);
	}

	/**
	 * Serialize
	 *  
	 * @Param p_value Date
	 * @param p_jsonGenerator JsonGenerator
	 * @param p_serializerProvider SerializerProvider
	 * 
	 * @return writeString(String)
	 */
	@Override
	public void serialize(Date p_value, JsonGenerator p_jsonGenerator, SerializerProvider p_serializerProvider)
			throws IOException, JsonProcessingException {
		p_jsonGenerator.writeString(formatter.format(p_value));
	}
}