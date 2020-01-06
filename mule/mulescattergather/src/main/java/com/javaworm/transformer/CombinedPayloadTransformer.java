package com.javaworm.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class CombinedPayloadTransformer extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub
		 String payload = (String) message.getPayload();
		 message.setPayload(payload + " transformation applied.");
		return message;
	}

}
