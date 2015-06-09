/*
* 작성일 : 2015. 6. 3.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.user.controller;

import javax.servlet.http.HttpSession;

import launch.box.makeit.user.service.UserService;
import launch.box.makeit.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping(value="/alter", method=RequestMethod.POST)
	public int UserAlter(@ModelAttribute UserVO user){
		return service.alter(user);
	}
	
	@RequestMapping(value="/dropout", method=RequestMethod.POST)
	public int UserDropout(@RequestParam int srl){
		return service.dropout(srl);
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public UserVO UserLogin(@ModelAttribute UserVO user){
		return service.login(user);
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public int UserJoin(@ModelAttribute UserVO user){
		return service.join(user);
	}
	
	@RequestMapping(value="/checkEmail", method=RequestMethod.POST)
	public int UserCheckEmail(@ModelAttribute UserVO user){
		return service.checkEmail(user);
	}
	
	@RequestMapping(value="/checkNickname.", method=RequestMethod.POST)
	public int UserCheckNickname(@ModelAttribute UserVO user){
		return service.checkNickname(user);
	}
	
	
}
