/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.controller;

import java.util.List;

import launch.box.makeit.orders.service.OrdersService;
import launch.box.makeit.orders.vo.OrdersVO;

import org.springframework.beans.factory.annotation.Autowired;
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
	public int OrderInput(@RequestParam int userSrl, @RequestParam List<Integer> itemSrl){
		OrdersVO order = new OrdersVO();
		order.setUserSrl(userSrl);
		order.setPhase(1);
		return service.input(order,itemSrl);
	}
	
	@RequestMapping(value="/pullPhase1", method=RequestMethod.GET)
	public List<OrdersVO> OrderPullPhase1(){
		return service.pullPhase1();
	}
	
	
	
	
	
}
