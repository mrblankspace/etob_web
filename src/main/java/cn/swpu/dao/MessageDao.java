package cn.swpu.dao;

import cn.swpu.beans.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageDao {
    @Insert("insert into message(email, username, message, date) values(#{email}, #{username}, #{message}, #{date})")
    public void svaeMessage(Message message);
    @Delete("delete  from message where id = #{id}")
    void delete(long id);
    @Select("select count(*) from message")
    Integer count();
    //需要加注解
    @Select("select * from message limit #{currentPage}, #{pageSize}")
    List<Message> findPage(@Param("currentPage")int currentPage, @Param("pageSize")int pageSize);

    @Select("select * from(select username, date, email, message from message order by date desc limit 13)as a order by date")
    List<Message> getNewTenMessage();
}
