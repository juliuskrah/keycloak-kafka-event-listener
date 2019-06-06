package com.juliuskrah.keycloak.provider;

import java.util.Map;
import java.util.concurrent.Callable;

import javax.enterprise.concurrent.ManagedTask;
import javax.enterprise.concurrent.ManagedTaskListener;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.keycloak.events.Event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class KeycloakEventListener implements Callable<RecordMetadata>, ManagedTask {
	private final Event event;

	@Override
	public ManagedTaskListener getManagedTaskListener() {
		return new KeycloakManagedTaskListener();
	}

	@Override
	public Map<String, String> getExecutionProperties() {
		// Do not add any execution properties
		return null;
	}

	@Override
	public RecordMetadata call() throws Exception {
		log.debug("Running task asynchronously");
		RecordMetadata metadata = KeycloakEventProducer.get() //
				.send(new ProducerRecord<String, String>("keycloak.users", //
						"user_id", event.getUserId()))
				.get();
		return metadata;

	}

}
