/*
* 작성일 : 2015. 6. 2.
* 작성자 : Administrator
*
* 설명
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
	
	@RequestMapping(value="/pullAllItem", method=RequestMethod.GET)
	public List<ItemVO> ItemPullAllItem(){
		return service.pullAllItem();
	}
}
