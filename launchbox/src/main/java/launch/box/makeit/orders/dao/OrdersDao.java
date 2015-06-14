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
	int input(OrdersVO order);					// 주문 입력
	int pullRecentInputSrl();					// 최근 입력한 주문의 srl 호출
	int plusInput(OrdersVO order);				// 주문 정보 update
	int changePhase2();							// phase를 2로 변경 (무쓸모)
	int changePhase3();							// phase를 3으로 변경 (무쓸모)
	List<String> pullAllSort();					// 분류 고유번호 리스트를 호출
	OrdersVO pullOrder(String sort);			// 고유번호를 입력해서 주문 호출
	List<OrdersVO> pullUserBuyList(int userSrl);// 유저가 구입했던 주문 리스트
	int alterAllPhase0to1();					// phase가 0인 주문을 모두 1로 변경
	int alterPhase(int phase, int srl);			// phase 변경
	List<String> pullPayedSort();				// 이미 지불완료된 고유번호 리스트 호출
	List<String> pullPhase(int phase);			// phase에 해당하는 고유번호 리스트 호출
	int pullUserSrl(int srl);					// orderSrl로 userSrl 호출
	OrdersVO pullOrderInfo(int srl);			// orderSrl로 OrdersVO 호출
}