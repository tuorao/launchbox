/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.service;

import launch.box.makeit.orders.vo.OrdersVO;

public interface OrdersService {
	int setPrice(int setSrl);
	int input(OrdersVO order);
}
