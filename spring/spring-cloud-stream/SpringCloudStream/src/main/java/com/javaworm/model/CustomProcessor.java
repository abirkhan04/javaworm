package com.javaworm.model;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface CustomProcessor {
	String INPUT = "myInput";
	
	@Input()
	public SubscribableChannel myInput();
	
	@Output("firstOutput")
	public MessageChannel firstOutput();
	
	@Output("secondOutput")
	public MessageChannel secondOuptput();

}
