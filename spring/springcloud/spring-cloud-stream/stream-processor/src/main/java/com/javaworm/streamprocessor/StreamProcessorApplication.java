package com.javaworm.streamprocessor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@SpringBootApplication
@EnableBinding(Processor.class)
public class StreamProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamProcessorApplication.class, args);
	}
	
	@Transformer(inputChannel = Processor.INPUT, outputChannel = Processor.OUTPUT)
	public Object transformMessage(Long date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		return dateFormat.format(date);
	}
}
