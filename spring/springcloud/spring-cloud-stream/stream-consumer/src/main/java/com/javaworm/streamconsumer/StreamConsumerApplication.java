package com.javaworm.streamconsumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
@SpringBootApplication
public class StreamConsumerApplication {

	public static Log logger =  LogFactory.getLog(StreamConsumerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StreamConsumerApplication.class, args);
	}

	@StreamListener(Sink.INPUT)
	public void handle(String message) {
		logger.info("Received: " + message);
	}
}
