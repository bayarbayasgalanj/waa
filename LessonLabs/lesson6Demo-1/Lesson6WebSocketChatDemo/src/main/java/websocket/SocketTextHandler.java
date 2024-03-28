package websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.ArrayList;
import java.util.List;

@Component
public class SocketTextHandler extends TextWebSocketHandler {

	List<WebSocketSession> sessions = new ArrayList<WebSocketSession>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
			throws Exception {
		System.out.println("got message"+ message);
		for (WebSocketSession theSession : sessions){
			if (theSession.isOpen())
			    theSession.sendMessage(new TextMessage(message.getPayload()));
		}
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("Connected");
		sessions.add(session);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		sessions.remove(session);
		System.out.println("Closed");
	}

}