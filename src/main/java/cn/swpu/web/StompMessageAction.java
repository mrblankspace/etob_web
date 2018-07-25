package cn.swpu.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;


/**
 * Stomp消息控制类
 */
@Controller
public class StompMessageAction {
    private static final Logger logger = LoggerFactory.getLogger(StompMessageAction.class);

    @MessageMapping("/api/charRoom/getStompMessage")
    public Message sendMessage( Message message){
        System.out.println(message);
        return message;
    }
}
