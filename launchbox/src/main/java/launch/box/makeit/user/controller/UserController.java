/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.controller;

import launch.box.makeit.user.service.UserService;
import launch.box.makeit.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// ���� oAuth ���� �۾�, push ���� �۾��� �ʿ���
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	// ȸ������ ����
	@RequestMapping(value="/alter.do", method=RequestMethod.POST)
	public int UserAlter(@ModelAttribute UserVO user){
		return service.alter(user);
	}
	
	// ȸ��Ż��
	@RequestMapping(value="/dropout.do", method=RequestMethod.POST)
	public int UserDropout(@RequestParam int srl){
		return service.dropout(srl);
	}
	
	// �α���
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public UserVO UserLogin(@ModelAttribute UserVO user){
		return service.login(user);
	}
	
	// ����
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public int UserJoin(@ModelAttribute UserVO user){
		return service.join(user);
	}
	
	// ���̵� �ߺ�üũ
	@RequestMapping(value="/checkEmail.do", method=RequestMethod.POST)
	public int UserCheckEmail(@ModelAttribute UserVO user){
		return service.checkEmail(user);
	}
	
	// �г��� �ߺ�üũ
	@RequestMapping(value="/checkNickname.do", method=RequestMethod.POST)
	public int UserCheckNickname(@ModelAttribute UserVO user){
		return service.checkNickname(user);
	}
}
