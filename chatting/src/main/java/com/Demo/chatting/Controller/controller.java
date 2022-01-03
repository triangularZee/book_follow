package com.Demo.chatting.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
public class controller extends Socket {
    private static final List<Session> session = new ArrayList<Session>();

    @GetMapping("/")
    public String index(){
        return "index.html";
    }

    @OnOpen
    public void open(Session user){
        System.out.println("Connected");
        session.add(user);
        System.out.println(user.getId());
    }

    @OnMessage
    public void getMsg(Session recv, String msg){
        for(int i = 0; i< session.size(); i++){
            if(!recv.getId().equals(session.get(i).getId())){
                try {
                    session.get(i).getBasicRemote().sendText("상대 : " + msg);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    session.get(i).getBasicRemote().sendText("나 : " + msg);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
