package cn.swpu.dao;

import cn.swpu.beans.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MessageDao {
    @Insert("insert into message(email, username, message, date) values(#{email}, #{username}, #{message}, #{date})")
    public void svaeMessage(Message message);
    @Delete("delete  from message where id = #{id}")
    void delete(long id);
    @Select("select count(*) from message")
    Integer count();
    @Select("select * from message limit #{currentPage}, #{pageSize}")
    List<Message> findPage(int currentPage, int pageSize);
}
