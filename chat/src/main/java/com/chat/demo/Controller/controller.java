package com.chat.demo.Controller;


import com.chat.demo.DTO.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import javax.websocket.server.ServerEndpoint;

@Controller
@ServerEndpoint(web)
public class controller {

    @MessageMapping("/chat.register")
    @SendTo("topic/public")
    public Message register(
            @Payload Message msg,
            SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", msg.getSender());
        return msg;
    }

    @MessageMapping("/chat.send")
    @SendTo("topic/public")
    public Message sendMessage(@Payload Message msg){
        return msg;
    }

}
