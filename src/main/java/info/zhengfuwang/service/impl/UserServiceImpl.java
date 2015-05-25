package info.zhengfuwang.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import info.zhengfuwang.dao.UserMapper;
import info.zhengfuwang.pojo.User;
import info.zhengfuwang.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserById(int id) {
		return userMapper.selectByPrimaryKey(id);
	}

}
