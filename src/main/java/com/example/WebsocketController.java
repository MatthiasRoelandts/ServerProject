package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by matth on 7/10/2016.
 */
@Configuration
@EnableWebSocket
public class WebsocketController implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new QuestionHandler(), "/questions");
    }

    //We can handle text or binary -> define text websocket handler
    class QuestionHandler extends TextWebSocketHandler {

        private List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            //super.afterConnectionEstablished(session);
            sessions.add(session);
            System.out.println("Connection established with " + session.getId());
        }

        @Override
        public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) {
            for (WebSocketSession s : sessions) {
                try {
                    System.out.println("Id: " + session.getId() + " sended: " + message.toString());
                    s.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
