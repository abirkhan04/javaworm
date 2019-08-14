package com.javaworm.listener;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import com.google.gson.Gson;

@Component
public class Listener {

	Log logger = LogFactory.getLog(Listener.class);

	@JmsListener(destination = "inbound.queue")
	@SendTo("outbound.queue")
	public String messageReceiver(final Message jsonMessage) throws JMSException {
		logger.info("Received message " + jsonMessage);
		String response = null;
		if (jsonMessage instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) jsonMessage;
			String message = textMessage.getText();
			Map map = new Gson().fromJson(message, Map.class);
			response = "Hello " + map.get("name");
		}
		return response;
	}
}
