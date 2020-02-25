package com.javaworm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;
import com.javaworm.configuration.Events;
import com.javaworm.configuration.States;

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	public static void main(String args[]) {
		SpringApplication.run(StateMachineApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		stateMachine.sendEvent(Events.Event1);
		stateMachine.sendEvent(Events.Event2);
	}
}
