package com.javaworm;

import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.processor.MessageProcessor;

public class AppendPayload implements MessageProcessor {

	@Override
	public MuleEvent process(MuleEvent event) throws MuleException {
		// TODO Auto-generated method stub
		event.getMessage().setPayload(event.getMessage().getPayload() + "appended");
		return event;
	}

}
