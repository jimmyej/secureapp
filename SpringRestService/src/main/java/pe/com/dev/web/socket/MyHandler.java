package pe.com.dev.web.socket;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler{
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // ...
    }
}
