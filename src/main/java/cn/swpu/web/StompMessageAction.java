package cn.swpu.web;

import cn.swpu.beans.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.WebSocketSession;


/**
 * Stomp消息控制类
 */
@Controller
public class StompMessageAction {
    private static final Logger logger = LoggerFactory.getLogger(StompMessageAction.class);

    @MessageMapping("/api/charRoom/getNewMessage")    //注意隐含的  /app 前缀   请求要带/app
    @SendTo("/topic/chatRoom")   //重載发布消息地址
    public Message sendMessage(Message message){
        return message;
    }

}
