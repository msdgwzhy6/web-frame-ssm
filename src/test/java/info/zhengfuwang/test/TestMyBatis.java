package info.zhengfuwang.test;

import info.zhengfuwang.pojo.User;
import info.zhengfuwang.service.UserService;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * MyBatis测试
 * @author zhengfuwang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-mybatis.xml"})
public class TestMyBatis {
	
	private static Logger logger = Logger.getLogger(TestMyBatis.class);
	
	@Resource
	private UserService userService;
	
	@Test
	public void test(){
		User user = userService.getUserById(1);
		logger.info(user.getName());
	}
}
