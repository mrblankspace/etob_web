package cn.swpu.services.impl;

import cn.swpu.beans.Message;
import cn.swpu.services.StompMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class StompMessageServiceImpl implements StompMessageService {
    @Autowired
    SimpMessageSendingOperations simpMessageSendingOperations;

    //发送消息到话题    
    public void sendMessageToProxy(Message message) {
        simpMessageSendingOperations.convertAndSend("/topic/chatRoom");
    }


}
