package com.javaworm;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class MessageTransformer extends AbstractMessageTransformer{

	public void MessageTransormer() {
		
	}
	
	@Override
	public Object transformMessage(MuleMessage message, String encoding) throws TransformerException {
		try {
			System.out.println("Message Payload-->" + message.getPayloadAsString());
			message.setPayload("Payload Transformed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return message;
	}
}
