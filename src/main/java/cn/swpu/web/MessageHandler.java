package cn.swpu.web;

import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.ArrayList;

public class MessageHandler extends AbstractWebSocketHandler {
    private ArrayList<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
    @Autowired
    private MessageService messageService;
    /**
     * 建立连接时连接对象加入list
     * @param session
     * @throws Exception
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessionList.add(session);
    }



    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        sessionList.add(session);
        for(WebSocketSession eachSession : sessionList) {//转发给每个连接
            session.sendMessage(message);   //这里的message存储是前端js往/api/charRoom/getNewMessage发送的 新插入的message对象json字符串
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessionList.remove(session);
    }
}
