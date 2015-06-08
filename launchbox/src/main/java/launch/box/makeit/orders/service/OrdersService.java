/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.service;

import java.util.List;

import launch.box.makeit.orders.vo.OrdersVO;

public interface OrdersService {
	int setPrice(int setSrl);
	int input(OrdersVO order, List<Integer> itemSrl);
	List<OrdersVO> pullPhase1();
	List<OrdersVO> pullPhase2();
	List<OrdersVO> pullPhase3();
	int changePhase2();
	int changePhase3();
	List<OrdersVO> pullAllOrder();

}
