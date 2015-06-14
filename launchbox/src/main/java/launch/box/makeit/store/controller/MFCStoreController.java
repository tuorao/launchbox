/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
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

	//crud니까 자세한 설명은 생략한다
	@Autowired
	StoreService service;
	
	// ����
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public int StoreJoin(@ModelAttribute StoreVO store){
		return service.join(store);
	}
	
	// Ż��
	@RequestMapping(value="/dropout", method=RequestMethod.POST)
	public int StoreDropout(@ModelAttribute StoreVO store){
		return service.dropout(store.getEmail(), store.getEmainDoamin());
	}
	
	// �̸��� �ߺ� üũ
	@RequestMapping(value="/checkDuplicatedEmail", method=RequestMethod.POST)
	public int StoreCheckDuplicatedEmail(@ModelAttribute StoreVO store){
		return service.checkDuplicatedEmail(store.getEmail(), store.getEmainDoamin());
	}
	
	// �α���
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public StoreVO StoreLogin(@ModelAttribute StoreVO store){
		return service.login(store.getEmail(), store.getEmainDoamin(), store.getPassword());
	}
	
	// storeInfoPull
	@RequestMapping(value="/pullStoreInfo", method=RequestMethod.POST)
	public StoreVO StorePullStoreInfo(@ModelAttribute StoreVO store){
		return service.pullStoreInfo(store.getEmail(), store.getEmainDoamin());
	}
	
	// ���� ����
	@RequestMapping(value="/alter", method=RequestMethod.POST)
	public int StoreAlter(@ModelAttribute StoreVO store){
		return service.alter(store);
	}
	
	// �ֱ� �α��� ��¥ �Է�
	@RequestMapping(value="/inputLastLoginDate", method=RequestMethod.POST)
	public int StoreInputLastLoginDate(@ModelAttribute StoreVO store){
		return service.inputLastLoginDate(store.getLastLoginDate(), store.getEmail(), store.getEmainDoamin());
	}
}
