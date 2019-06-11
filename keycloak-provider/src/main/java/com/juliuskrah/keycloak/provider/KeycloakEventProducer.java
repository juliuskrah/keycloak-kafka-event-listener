package com.juliuskrah.keycloak.provider;

import static java.util.Objects.isNull;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KeycloakEventProducer {

	private static Producer<String, Object> INSTANCE;

	static public Producer<String, Object> create(Properties props) {
		if (isNull(INSTANCE))
			INSTANCE = new KafkaProducer<>(props);
		return INSTANCE;
	}

	static public Producer<String, Object> get() {
		return INSTANCE;
	}

}
