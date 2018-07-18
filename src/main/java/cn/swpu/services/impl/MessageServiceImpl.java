package cn.swpu.services.impl;

import cn.swpu.beans.Message;
import cn.swpu.dao.MessageDao;
import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * 消息服务实现类
 * @author zb
 */
@Component
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageDao messageDao;

    @Override
    public void save( Message message) {
        messageDao.svaeMessage(message);
    }
}
