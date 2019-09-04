package com.javaworm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import com.javaworm.model.CustomProcessor;

@SpringBootApplication
@EnableBinding(value = { Processor.class, CustomProcessor.class })
public class SpringCloudStreamApplication {

	@Autowired
	CustomProcessor cProcessor;
	
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamApplication.class, args);
	}
	
    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
	public String enrichLogMessage(String inputMessage) {
    	System.out.println(inputMessage);
        return "Converted Message: "+ inputMessage;
    }
    
    
    @StreamListener(CustomProcessor.INPUT)
    public void redirectValueOnCondition(Integer value) {
    	if(value>20) {
    		cProcessor.firstOutput().send(message("Value is greated than 20"));
    	} else {
    		cProcessor.secondOuptput().send(message("value is less than 20"));
    	}
    }
    
    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val).build();
    }

}

