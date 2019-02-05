package com.javaworm;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;
import java.util.logging.Logger;

@ServerEndpoint("/websocketendpoint")
public class WebSocketServer {

	Logger logger = Logger.getLogger(WebSocketServer.class.getName());

	@OnOpen
	public void onOpen() {
		logger.info("Open Connection ...");
	}

	@OnClose
	public void onClose() {
		logger.info("Close Connection ...");
	}

	@OnMessage
	public String onMessage(String message) {
		logger.info("Message from the client: " + message);
		String echoMessage = "Hi " + message;
		return echoMessage;
	}

	@OnError
	public void onError(Throwable e) {
		e.printStackTrace();
	}

}
