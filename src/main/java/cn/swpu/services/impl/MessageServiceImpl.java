package cn.swpu.services.impl;

import cn.swpu.beans.Message;
import cn.swpu.beans.PageBean;
import cn.swpu.dao.MessageDao;
import cn.swpu.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.util.List;

/**
 * 消息服务实现类
 * @author zb
 */
@Component
public class MessageServiceImpl implements MessageService{
    @Autowired
    private MessageDao messageDao;

    @Override
    public void save(Message message) {
        messageDao.svaeMessage(message);
    }

    @Override
    public void delete(long id) {
        messageDao.delete(id);
    }

    @Override
    public PageBean<Message> findPage(PageBean pageBean) {
        Integer count = messageDao.count();
        pageBean.setTotal(count);
        Double totalPage = Math.ceil(count.doubleValue()/pageBean.getPageSize());   //计算页数
        pageBean.setTotalPage(totalPage.intValue());
        Integer begin = (pageBean.getCurrentPage()-1)*pageBean.getPageSize();        //计算数据库中索引
        List<Message> list = messageDao.findPage(pageBean.getCurrentPage(), pageBean.getPageSize());
        pageBean.setList(list);
        return pageBean;
    }
}
