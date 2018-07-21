package cn.swpu.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.swpu.beans.Message;
import cn.swpu.beans.PageBean;
import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
public class MessageAction {
    @Autowired
    private MessageService messageService;

    /**
     * 消息保存方法
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/api/charRoom/addMessage"})
    public String save(@Valid  Message message) {
        Date date = new Date();
        message.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        messageService.save(message);
        //视图名?
        return "";
    }

    /**
     * 消息删除方法
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/api/charRoom/deleteMessage"})
    public String delete(@Valid Message message){
        messageService.delete(message.getId());
        return "";
    }

    @ResponseBody
    @RequestMapping(value = {"/api/charRoom/listMessage"})
    public PageBean<Message> listMessage(@Valid PageBean<Message> pageBean){
            return messageService.findPage(pageBean);
    }
}




