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
public class CustomDateToIntegerDeserializer extends StdDeserializer<Integer> {

	/**
	 * long
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 */
	public CustomDateToIntegerDeserializer() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param p_c Class
	 */
	public CustomDateToIntegerDeserializer(Class<?> p_c) {
		super(p_c);
	}

	/**
	 * Deserialize Date to integer
	 * 
	 * @param p_jsonParser JsonParser
	 * @param p_deserializationContext DeserializationContext
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
