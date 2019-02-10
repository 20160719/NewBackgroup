package com.myself.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = -5353981471088865387L;

	public CustomObjectMapper() {
//		BeanSerializerFactory factory = new BeanSerializerFactory(null);
//		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
//			@Override
//			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider)
//					throws IOException, JsonProcessingException {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//				jsonGenerator.writeString(sdf.format(value));
//			}
//		});
//		this.setSerializerFactory(factory);
	}
}
