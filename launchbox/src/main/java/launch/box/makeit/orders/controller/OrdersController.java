/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.controller;

import java.util.ArrayList;
import java.util.List;

import launch.box.makeit.itemlist.vo.ItemListVO;
import launch.box.makeit.orders.service.OrdersService;
import launch.box.makeit.orders.vo.BundleVO;
import launch.box.makeit.orders.vo.OrdersItemVO;
import launch.box.makeit.orders.vo.OrdersVO;
import launch.box.makeit.util.DateFormatting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	OrdersService service;
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public int OrderInput(@RequestParam int userSrl, @RequestParam int amount, @RequestParam List<Integer> itemSrl, @RequestParam List<Integer> itemAmount){
		OrdersVO order = new OrdersVO();
		order.setUserSrl(userSrl);
		order.setPhase(0);
		order.setSort(new DateFormatting().setSort(userSrl));
		order.setAmount(amount);
		List<ItemListVO> itemList = new ArrayList<ItemListVO>();
		for(int i=0; i<itemSrl.size(); i++){
			ItemListVO item  = new ItemListVO();
			item.setItemSrl(itemSrl.get(i));
			item.setAmount(itemAmount.get(i));
			itemList.add(item);
		}
		return service.input(order,itemList);
	}

	
	@RequestMapping(value="/callOrderList", method=RequestMethod.GET)
	public List<BundleVO> OrderCallOrderList(){
		return service.callOrderList();
	}
	
	@RequestMapping(value="/UserBuyList", method=RequestMethod.POST)
	public List<OrdersItemVO> OrderUserBuyList(@RequestParam int userSrl){
		return service.UserBuyList(userSrl);
	}
	
	@RequestMapping(value="/callPayedOrderList", method=RequestMethod.GET)
	public List<BundleVO> OrderCallPayedOrderList(){
		return service.callPayedOrderList();
	}
	
	@RequestMapping(value="/alterPhase", method=RequestMethod.GET)
	public int OrderAlterPhase(@RequestParam int phase,@RequestParam int orderSrl){
		return service.alterPhase(phase, orderSrl);
	}

	// 페이즈 별로 호출
	@RequestMapping(value="/pullPhase", method=RequestMethod.GET)
	public List<BundleVO> OrderPullPhase(@RequestParam int phase){
		return service.pullPhase(phase);
	}
	
	@RequestMapping(value="/pushInput", method=RequestMethod.GET)
	public int OrderPushInput(@RequestParam int orderSrl){
		return service.pushInput(orderSrl);
	}
	
	
	
}
