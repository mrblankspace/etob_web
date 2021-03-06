package cn.swpu.services;

import cn.swpu.beans.Message;

import java.util.ArrayList;

//Stomp消息服务接口
public interface StompMessageService {
    //转发stomp消息给代理
    public void sendMessageToProxy(Message message);
    public void sendMessageToProxy(ArrayList<Message> list);
}
