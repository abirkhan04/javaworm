package muleflow;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

public class InboundPropertyCheck extends AbstractMessageTransformer{

	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		// TODO Auto-generated method stub
		System.out.println("Inbound Property Check-->" +  message.getInboundProperty("test").toString());	
		return message;
	}

}
