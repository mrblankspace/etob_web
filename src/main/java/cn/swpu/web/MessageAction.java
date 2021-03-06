package cn.swpu.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.swpu.beans.Message;
import cn.swpu.beans.PageBean;
import cn.swpu.services.MessageService;
import cn.swpu.services.StompMessageService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Controller
public class MessageAction {
    @Autowired
    private MessageService messageService;

    @Autowired
    private StompMessageService  stompMessageService;
    /**
     * 消息保存方法 底层websocket实现   暂时保留
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = {"/api/charRoom/addMessage"}, method = RequestMethod.POST)
    public JSONPObject save(@RequestBody Message message) {
        Date date = new Date();
        message.setDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        try{
            messageService.save(message);
            //返回最新 10 条 给前端
          ArrayList<Message> list = messageService.getNewTenMessage();
            stompMessageService.sendMessageToProxy(list);     //这里保存消息的同时发送消息给代理
        }catch (Exception e){
           e.printStackTrace();
            JSONPObject state = new JSONPObject("states","false");
            return state;
        }
        JSONPObject state = new JSONPObject("states","true");
        //视图名?
        //
        return state;
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
  @ResponseBody
  @RequestMapping(value = {"/api/charRoom/getNewTenMessage"}, method = RequestMethod.GET)
  public ArrayList<Message> getNewTenMessage() {
    return messageService.getNewTenMessage();
  }
}




