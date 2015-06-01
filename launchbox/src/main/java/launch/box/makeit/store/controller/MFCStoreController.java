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
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public int StoreJoin(@ModelAttribute StoreVO store){
		return service.join(store);
	}
}
