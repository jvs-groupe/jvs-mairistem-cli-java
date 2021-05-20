package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
	 * true states
	 */
	private final static Set<String> trueStateSet = new HashSet<>(Arrays.asList("true", "1")); // , "o", "on", "enabled"));

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
	 * @param p_jsonParser JsonParser
	 * @param p_deserializationContext DeserializationContext
	 * 
	 * @return Boolean
	 */
	@Override
	public Boolean deserialize(JsonParser p_jsonParser, DeserializationContext p_deserializationContext)
			throws IOException, JsonProcessingException {
		
		String value = p_jsonParser.getText();;
		
		if (value == null) {
			// pour le moment, un null = false.
		} else {
			value = value.toLowerCase();
			return trueStateSet.contains(value);
		}

		return false;
	}
}
