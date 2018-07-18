package cn.swpu.dao;

import cn.swpu.beans.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {
    @Insert("insert into message(email, username, message, date) values(#{email}, #{username}, #{message}, #{date})")
    public void svaeMessage(Message message);
}
