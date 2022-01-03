package com.chat.demo.Component;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Log4j2
public class WebSocketHandler extends TextWebSocketHandler {

}
