package com.javaworm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.javaworm.configuration.Events;
import com.javaworm.configuration.States;

@RestController
public class StateMachineController {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@GetMapping(value = "currentState")
	public @ResponseBody String currentState() {
		stateMachine.sendEvent(Events.Event1);
		return stateMachine.getState().toString();
	}

}
