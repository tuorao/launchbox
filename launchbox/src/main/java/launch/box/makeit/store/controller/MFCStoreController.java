/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.store.controller;

import javax.servlet.http.HttpSession;

import launch.box.makeit.store.service.StoreService;
import launch.box.makeit.store.vo.StoreVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/store")
public class MFCStoreController {

	//crud니까 자세한 설명은 생략한다
	@Autowired
	StoreService service;
	
	/** 기능 : Store 회원가입
	 * 
	 * @param store
	 * @return 1 성공 , 0 실패
	 */
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String StoreJoin(@ModelAttribute StoreVO store, Model model){
		model.addAttribute("storeJoinCheck", service.join(store));
		return "";
	}
	
	/** 기능 : Store 탈퇴
	 * 
	 * @param store
	 * @return 1 성공, 0 실패
	 */
	@RequestMapping(value="/dropout", method=RequestMethod.POST)
	public String StoreDropout(@ModelAttribute StoreVO store, Model model){
		model.addAttribute("storeDropoutCheck", service.dropout(store.getEmail(), store.getEmainDoamin()));
		return "";
	}
	
	/** 기능 : email 중복 체크
	 * 
	 * @param store
	 * @return 1 중복아님, 0 중복
	 */
	@RequestMapping(value="/checkDuplicatedEmail", method=RequestMethod.POST)
	public String StoreCheckDuplicatedEmail(@ModelAttribute StoreVO store, Model model){
		model.addAttribute("storeDupCheck", service.checkDuplicatedEmail(store.getEmail(), store.getEmainDoamin()));
		return "";
	}
	
	/** 기능 : 로그인 
	 * 
	 * @param store
	 * @return StoreVO 성공 , null 실패
	 */
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String StoreLogin(@ModelAttribute StoreVO store, HttpSession session){
		session.setAttribute("store", service.login(store.getEmail(), store.getEmainDoamin(), store.getPassword()));
		return "";
	}
	
	/** 기능 : 매장정보 호출
	 * 
	 * @param store
	 * @return StoreVO 성공 , null 실패
	 */
	@RequestMapping(value="/pullStoreInfo", method=RequestMethod.POST)
	public StoreVO StorePullStoreInfo(@ModelAttribute StoreVO store){
		return service.pullStoreInfo(store.getEmail(), store.getEmainDoamin());
	}
	
	/**	기능 : 로그아웃
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/logout")
	public String StoreLogout(HttpSession session){
		session.invalidate();
		return "";
	}
	
	/** 기능 : 회원정보 변경
	 * 
	 * @param store
	 * @return 1 성공, 0 실패
	 */
	@RequestMapping(value="/alter", method=RequestMethod.POST)
	public int StoreAlter(@ModelAttribute StoreVO store){
		return service.alter(store);
	}
}
