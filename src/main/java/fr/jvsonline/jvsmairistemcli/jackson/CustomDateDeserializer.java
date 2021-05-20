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
 */
public class CustomDateDeserializer extends StdDeserializer<Date> {

	/**
	 * Serial version
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * SimpleDateFormat
	 */
	private static SimpleDateFormat simpleDateFormat_fuseau = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); // "2016-09-20T00:00:00+02:00"
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); // "2018-04-09 00:00:00"

	/**
	 * Constructor
	 */
	public CustomDateDeserializer() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param p_c Class
	 */
	public CustomDateDeserializer(Class<?> p_c) {
		super(p_c);
	}

	/**
	 * Deserialize
	 * 
	 * @param p_jsonParser JsonParser
	 * @param p_deserializationContext DeserializationContext
	 * 
	 * @return Date
	 */
	@Override
	public Date deserialize(JsonParser p_jsonParser, DeserializationContext p_deserializationContext)
			throws IOException, JsonProcessingException {

		String date = p_jsonParser.getText();

		try {
			return simpleDateFormat.parse(date); // "2018-04-09 00:00:00"
		} catch (ParseException e) {
//      	throw new RuntimeException(e);
		}

		try {
			return simpleDateFormat_fuseau.parse(date); // "2016-09-20T00:00:00+02:00"
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
