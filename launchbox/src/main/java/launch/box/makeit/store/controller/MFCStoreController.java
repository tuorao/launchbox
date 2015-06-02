/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.store.controller;

import launch.box.makeit.store.service.StoreService;
import launch.box.makeit.store.vo.StoreVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class MFCStoreController {

	@Autowired
	StoreService service;
	
	// 가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public int StoreJoin(@ModelAttribute StoreVO store){
		return service.join(store);
	}
	
	// 탈퇴
	@RequestMapping(value="/dropout", method=RequestMethod.POST)
	public int StoreDropout(@ModelAttribute StoreVO store){
		return service.dropout(store.getEmail(), store.getEmainDoamin());
	}
	
	// 이메일 중복 체크
	@RequestMapping(value="/checkDuplicatedEmail", method=RequestMethod.POST)
	public int StoreCheckDuplicatedEmail(@ModelAttribute StoreVO store){
		return service.checkDuplicatedEmail(store.getEmail(), store.getEmainDoamin());
	}
	
	// 로그인
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public StoreVO StoreLogin(@ModelAttribute StoreVO store){
		return service.login(store.getEmail(), store.getEmainDoamin(), store.getPassword());
	}
	
	// storeInfoPull
	@RequestMapping(value="/pullStoreInfo", method=RequestMethod.POST)
	public StoreVO StorePullStoreInfo(@ModelAttribute StoreVO store){
		return service.pullStoreInfo(store.getEmail(), store.getEmainDoamin());
	}
	
	// 내용 변경
	@RequestMapping(value="/alter", method=RequestMethod.POST)
	public int StoreAlter(@ModelAttribute StoreVO store){
		return service.alter(store);
	}
	
	// 최근 로그인 날짜 입력
	@RequestMapping(value="/inputLastLoginDate", method=RequestMethod.POST)
	public int StoreInputLastLoginDate(@ModelAttribute StoreVO store){
		return service.inputLastLoginDate(store.getLastLoginDate(), store.getEmail(), store.getEmainDoamin());
	}
}
