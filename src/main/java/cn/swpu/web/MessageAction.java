package cn.swpu.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.swpu.beans.Message;
import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageAction {
    @Autowired
    private MessageService messageService;

    /**
     * 消息保存方法
     * @param message
     * @return
     */
    @RequestMapping(value = {"/"})
    public String save(Message message) {
        messageService.save(message);
        return "list";
    }
}




