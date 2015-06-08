/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.service;

import java.util.List;

import launch.box.makeit.orders.vo.BundleVO;
import launch.box.makeit.orders.vo.OrdersItemVO;
import launch.box.makeit.orders.vo.OrdersVO;

public interface OrdersService {
	int setPrice(String sort);
	int input(OrdersVO order, List<Integer> itemSrl);
	int changePhase2();
	int changePhase3();
	List<BundleVO> callOrderList();
	List<OrdersItemVO> UserBuyList(int userSrl);
	List<BundleVO> callPayedOrderList();
	int alterPhase(int phase, int srl);
}
