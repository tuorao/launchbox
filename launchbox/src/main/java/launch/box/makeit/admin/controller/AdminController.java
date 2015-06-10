/*
* 작성일 : 2015. 6. 10.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminHome() {
		return "adminMain";
	}
}