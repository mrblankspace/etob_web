package cn.swpu.web;

import cn.swpu.dao.TestDao;
import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageAction {
    private MessageService messageService;
    @Autowired
    private TestDao testDao;

    //返回注册页面
    @RequestMapping(value = {"/"})
    public String RegisterLogin() {
        System.out.println(testDao.findAll().toString());

        return "/";
    }
}




