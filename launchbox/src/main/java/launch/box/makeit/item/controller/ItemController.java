/*
* �ۼ��� : 2015. 6. 2.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.item.controller;

import java.util.List;

import launch.box.makeit.item.service.ItemService;
import launch.box.makeit.item.vo.ItemVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	ItemService service;
	
	// List<ItemVO>를 가져온다
	@RequestMapping(value="/pullAllItem", method=RequestMethod.GET)
	public List<ItemVO> ItemPullAllItem(){
		return service.pullAllItem();
	}
	
	// 인기 아이템을 가져온다
	@RequestMapping(value="/pullPopularItem", method=RequestMethod.GET)
	public List<ItemVO> ItemPullPopularItem(){
		return service.pullPopularItem();
	}
}
