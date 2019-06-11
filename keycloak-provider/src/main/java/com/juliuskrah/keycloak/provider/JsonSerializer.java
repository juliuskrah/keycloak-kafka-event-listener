package com.juliuskrah.keycloak.provider;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer<T> implements Serializer<T> {
	protected final ObjectMapper objectMapper;

	public JsonSerializer() {
		this(new ObjectMapper());
	}

	public JsonSerializer(ObjectMapper objectMapper) {
		Objects.requireNonNull(objectMapper, "'objectMapper' must not be null.");
		this.objectMapper = objectMapper;
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// NO-OP
	}

	@Override
	public byte[] serialize(String topic, T data) {
		if (data == null) {
			return null;
		}
		try {
			return this.objectMapper.writeValueAsBytes(data);
		} catch (IOException ex) {
			throw new SerializationException("Can't serialize data [" + data + "] for topic [" + topic + "]", ex);
		}
	}

	@Override
	public void close() {
		// NO-OP
	}

}
