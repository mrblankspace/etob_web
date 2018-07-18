package cn.swpu.services;

import cn.swpu.beans.Message;
import org.springframework.ui.Model;

public interface MessageService {
    //保存消息方法
    public  void save(Message message);
}
