package com.juliuskrah.keycloak.provider;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.enterprise.concurrent.ManagedExecutorService;
import javax.enterprise.concurrent.ManagedTaskListener;

import org.apache.kafka.clients.producer.RecordMetadata;

import lombok.extern.slf4j.Slf4j;

/**
 * A listener class for lifecycle events of an Executor
 * 
 * @author Julius Krah
 *
 */
@Slf4j
public class KeycloakManagedTaskListener implements ManagedTaskListener {

	@Override
	public void taskSubmitted(Future<?> future, ManagedExecutorService executor, Object task) {
		log.debug("Task is submitted");
	}

	@Override
	public void taskAborted(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		log.debug("Task is aborted");
	}

	@Override
	public void taskDone(Future<?> future, ManagedExecutorService executor, Object task, Throwable exception) {
		log.debug("Task is done");
		try {
			RecordMetadata metadata = (RecordMetadata) future.get();
			log.info("Topic '{}' updated", metadata.topic());
		} catch (InterruptedException | ExecutionException e) {
			log.error("Error while listening for done event", e);
		}
	}

	@Override
	public void taskStarting(Future<?> future, ManagedExecutorService executor, Object task) {
		log.debug("Task is starting");
	}

}
