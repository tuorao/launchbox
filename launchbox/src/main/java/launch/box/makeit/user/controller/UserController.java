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


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService service;
	
	/**	기능 : 회원정보 변경
	 * 	파라미터 : user - UserVO
	 */
	@RequestMapping(value="/alter", method=RequestMethod.POST)
	public int UserAlter(@ModelAttribute UserVO user){
		return service.alter(user);
	}
	
	/**	기능 : 회원탈퇴
	 * 	파라미터 : srl - 유저 srl
	 */
	@RequestMapping(value="/dropout", method=RequestMethod.POST)
	public int UserDropout(@RequestParam int srl){
		return service.dropout(srl);
	}
	
	/**	기능 : 로그인
	 * 	파라미터 : user - UserVO
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public UserVO UserLogin(@ModelAttribute UserVO user){
		return service.login(user);
	}
	
	/**	기능 : 유저 회원가입
	 * 	파라미터 : user - UserVO
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public int UserJoin(@ModelAttribute UserVO user){
		return service.join(user);
	}
	
	/**	기능 : 이메일 중복 여부 체크
	 * 	파라미터 : user - UserVO
	 */
	@RequestMapping(value="/checkEmail", method=RequestMethod.POST)
	public int UserCheckEmail(@ModelAttribute UserVO user){
		return service.checkEmail(user);
	}
	
	/**	기능 : 전화번호를 입력받고 해당 번호로 문자 메시지 난수 6자리값 전송
	 * 	파라미터 : phone - 전화번호
	 * 	"error" 리턴시 전송 실패
	 */
	@RequestMapping(value="/confirmPhone", method=RequestMethod.POST)
	public String UserConfirmPhone(@RequestParam String phone){
		String result = service.confirmPhone(phone);
		return result;
	}
	
	/**	기능 : 난수값 
	 * 	파라미터 : phone - 전화번호, num - 문자로 전송 된  난수 6자리 값
	 */
	@RequestMapping(value="/confirmCheck", method=RequestMethod.POST)
	public int UserConfirmCheck(@RequestParam String phone,@RequestParam int num){
		return service.confirmCheck(phone,num);
	}

	
}
