package cn.swpu.chat;

import cn.swpu.dao.MessageDao;
import cn.swpu.dao.TestDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChatApplicationTests {
	@Autowired
	private TestDao testDao;
	@Test
	public void contextLoads() {
		System.out.println(testDao.findAll());
	}

}
