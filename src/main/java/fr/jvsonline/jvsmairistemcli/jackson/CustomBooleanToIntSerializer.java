package fr.jvsonline.jvsmairistemcli.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

/**
 * CustomBooleanToIntSerializer
 */
public class CustomBooleanToIntSerializer extends StdSerializer<Boolean> {

	/**
	 * Constructor
	 */
	public CustomBooleanToIntSerializer() {
		this(null);
	}

	/**
	 * Constructor
	 * 
	 * @param p_c Class
	 */
	public CustomBooleanToIntSerializer(Class p_c) {
		super(p_c);
	}

	/**
	 * Serialize
	 * 
	 * @Param p_value Boolean
	 * @param p_jsonGenerator JsonGenerator
	 * @param p_serializerProvider SerializerProvider
	 * 
	 * @return writeNumber(int)
	 */
	@Override
	public void serialize(Boolean p_value, JsonGenerator p_jsonGenerator, SerializerProvider p_serializerProvider)
			throws IOException, JsonProcessingException {
		p_jsonGenerator.writeNumber((int) (p_value ? 1 : 0));
	}
}