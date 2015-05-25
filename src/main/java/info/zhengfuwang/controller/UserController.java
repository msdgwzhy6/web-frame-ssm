package info.zhengfuwang.controller;

import info.zhengfuwang.pojo.User;
import info.zhengfuwang.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/showUser")
	public String showUser(int id, HttpServletRequest request){
		User u = userService.getUserById(id);
		request.setAttribute("user", u);
		return "showUser";
	}
}
