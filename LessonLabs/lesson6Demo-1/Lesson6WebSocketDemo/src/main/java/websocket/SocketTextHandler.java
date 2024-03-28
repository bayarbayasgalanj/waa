package websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		System.out.println("got meesage"+ message);
		session.sendMessage(new TextMessage("Hi " + message.getPayload() + " how may we help you?"));
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("Connected");
		//send message back to the client
		session.sendMessage(new TextMessage("Connected !"));

		MyThread myThread = new MyThread(session);
		Thread t = new Thread(myThread);
		t.start();
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("Closed");
	}

}