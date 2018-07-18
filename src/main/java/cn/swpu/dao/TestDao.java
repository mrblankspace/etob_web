package cn.swpu.dao;

import cn.swpu.beans.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestDao {
    @Select("select * from message")
     List<Message> findAll();
}
