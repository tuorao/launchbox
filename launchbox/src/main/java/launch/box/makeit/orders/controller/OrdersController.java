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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	OrdersService service;
	
	/**  기능 : 주문 입력
	 *  파라미터 : userSrl - 유저 srl, amount - 도시락의 수량, itemSrl - 도시락에 구성된 아이템srl 리스트, itemAmount - 도시락에 구성된 아이템들의 수량
	 *  sort = userSrl + . + 현재시간(ssSSS)
	 *  phase 초기 값은 0
	 */
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public int OrderInput(@RequestParam int userSrl, @RequestParam int amount, @RequestParam List<Integer> itemSrl, @RequestParam List<Integer> itemAmount, @RequestParam String title, @RequestParam String content){
		OrdersVO order = new OrdersVO();
		order.setUserSrl(userSrl);
		order.setPhase(0);
		order.setSort(new DateFormatting().setSort(userSrl));
		order.setAmount(amount);
		order.setTitle(title);
		order.setContent(content);
		List<ItemListVO> itemList = new ArrayList<ItemListVO>();
		for(int i=0; i<itemSrl.size(); i++){
			ItemListVO item  = new ItemListVO();
			item.setItemSrl(itemSrl.get(i));
			item.setAmount(itemAmount.get(i));
			itemList.add(item);
		}
		return service.input(order,itemList);
	}

	/**	기능 : 주문 리스트 호출
	 * 	BundleVO는 List<Item>, OrdersVO, UserVO로 구성되어 있다
	 */
	@RequestMapping(value="/callOrderList", method=RequestMethod.GET)
	public List<BundleVO> OrderCallOrderList(){
		return service.callOrderList();
	}
	
	/**	기능 : 고객이 구매했던 아이템들의 리스트 호출
	 * 	파라미터 : userSrl - 유저 srl
	 */
	@RequestMapping(value="/UserBuyList", method=RequestMethod.POST)
	public List<OrdersItemVO> OrderUserBuyList(@RequestParam int userSrl){
		return service.UserBuyList(userSrl);
	}
	
	/**	기능 : 구매완료가 확정된 주문의 리스트 호출
	 * 	
	 */
	@RequestMapping(value="/callPayedOrderList", method=RequestMethod.GET)
	public List<BundleVO> OrderCallPayedOrderList(){
		return service.callPayedOrderList();
	}
	
	/**	기능 : phase 변경 
	 * 	파라미터 : phase - 주문 단계, orderSrl - 주문 번호
	 */
	@RequestMapping(value="/alterPhase", method=RequestMethod.GET)
	public int OrderAlterPhase(@RequestParam int phase,@RequestParam int orderSrl){
		return service.alterPhase(phase, orderSrl);
	}

	/**	기능 : phase 별로 주문 리스트 호출
	 * 
	 */
	@RequestMapping(value="/pullPhase", method=RequestMethod.GET)
	public List<BundleVO> OrderPullPhase(@RequestParam int phase){
		return service.pullPhase(phase);
	}
	
	/**	기능 : orderSrl에 해당하는 주문이 완료되면 안드로이드 push 실행
	 * 	파라미터 : orderSrl - 주문번호
	 */
	@RequestMapping(value="/pushInput", method=RequestMethod.GET)
	public int OrderPushInput(@RequestParam int orderSrl){
		return service.pushInput(orderSrl);
	}
	/** 기능 : 공지사항 푸쉬 , 매장에 등록된 모든 회원에게 보낸다
	 * 
	 * @param notice
	 * @return
	 */
	@RequestMapping(value="/noticePush", method=RequestMethod.GET)
	public int OrderNoticePush(@RequestParam String notice){
		return service.noticePush(notice);
	}
	
}
