package com.javaworm.transformer;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class PayloadTransformer extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {		
		int i = 0;
		int b = 3/i;
		return message;
	}

}
