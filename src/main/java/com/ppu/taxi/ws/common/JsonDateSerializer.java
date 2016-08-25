package com.ppu.taxi.ws.common;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * Untuk menyanggupi permintaan eric halim untuk ubah JSON long date ke string format.
 * referensi: 
 * https://dzone.com/articles/how-serialize-javautildate
 * @author Eric
 *
 */
public class JsonDateSerializer extends JsonSerializer<Date>{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	public void serialize(Date date, JsonGenerator gen, SerializerProvider provider) throws IOException, JsonProcessingException {
		String formattedDate = dateFormat.format(date);
		gen.writeString(formattedDate);
	}
}