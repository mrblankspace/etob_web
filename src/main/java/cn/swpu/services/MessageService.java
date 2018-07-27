package cn.swpu.services;

import cn.swpu.beans.Message;
import cn.swpu.beans.PageBean;
import org.springframework.ui.Model;

import java.util.ArrayList;

public interface MessageService {
    //保存消息方法
    public  void save(Message message);

    void delete(long id);

    PageBean<Message> findPage(PageBean pageBean);

    ArrayList<Message> getNewTenMessage();
}
