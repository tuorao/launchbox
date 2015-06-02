/*
* 작성일 : 2015. 6. 3.
* 작성자 : Administrator
*
* 설명
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


// 아직 oAuth 관련 작업, push 관련 작업이 필요함
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	// 회원정보 변경
	@RequestMapping(value="/alter.do", method=RequestMethod.POST)
	public int UserAlter(@ModelAttribute UserVO user){
		return service.alter(user);
	}
	
	// 회원탈퇴
	@RequestMapping(value="/dropout.do", method=RequestMethod.POST)
	public int UserDropout(@RequestParam int srl){
		return service.dropout(srl);
	}
	
	// 로그인
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public UserVO UserLogin(@ModelAttribute UserVO user){
		return service.login(user);
	}
	
	// 가입
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public int UserJoin(@ModelAttribute UserVO user){
		return service.join(user);
	}
	
	// 아이디 중복체크
	@RequestMapping(value="/checkEmail.do", method=RequestMethod.POST)
	public int UserCheckEmail(@ModelAttribute UserVO user){
		return service.checkEmail(user);
	}
	
	// 닉네임 중복체크
	@RequestMapping(value="/checkNickname.do", method=RequestMethod.POST)
	public int UserCheckNickname(@ModelAttribute UserVO user){
		return service.checkNickname(user);
	}
}
