/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.dao;

import java.util.List;

import launch.box.makeit.orders.vo.OrdersVO;

public interface OrdersDao {
	int input(OrdersVO order);
	int pullRecentInputSrl();
	int plusInput(OrdersVO order);
	int changePhase2();
	int changePhase3();
	List<String> pullAllSort();
	OrdersVO pullOrder(String sort);
	List<OrdersVO> pullUserBuyList(int userSrl);
	int alterAllPhase0to1();
	int alterPhase(int phase, int srl);
	List<String> pullPayedSort();
	List<String> pullPhase(int phase);
}