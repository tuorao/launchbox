/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.service;

import java.util.List;

import launch.box.makeit.item.dao.ItemDao;
import launch.box.makeit.itemlist.dao.ItemListDao;
import launch.box.makeit.itemlist.vo.ItemListVO;
import launch.box.makeit.orders.dao.OrdersDao;
import launch.box.makeit.orders.vo.OrdersVO;
import launch.box.makeit.sets.dao.SetsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	ItemListDao dao;
	@Autowired
	ItemDao itemDao;
	@Autowired
	OrdersDao orderDao;
	@Autowired
	SetsDao setsDao;
	
	int orderPullRecentInputSrl;
	int setPullRecentInputSrl;

	// 주문한것의 가격 합계
	@Override
	public int setPrice(int setSrl) {
		List<Integer> t = dao.pullItemSrl(setSrl);
		int a = 0;
		for(int i=0; i<t.size(); i++){
			a += itemDao.pullItemPrice(t.get(i));
		}
		return a;
	}

	@Override
	public int input(OrdersVO order,List<Integer> itemSrl) {
		
		OrdersVO orders = new OrdersVO();
		ItemListVO itemList = new ItemListVO();
		
		if(orderDao.input(order)==1){
			orderPullRecentInputSrl = orderDao.pullRecentInputSrl();
			if(setsDao.input(orderPullRecentInputSrl)==1){
				setPullRecentInputSrl = setsDao.pullRecentPullSrl();
				for(int i=0; i<itemSrl.size(); i++){
					itemList.setSetSrl(setPullRecentInputSrl);
					itemList.setItemSrl(itemSrl.get(i));
					dao.input(itemList);
				}
				orders.setSetSrl(setPullRecentInputSrl);
				orders.setPrice(setPrice(setPullRecentInputSrl));
				orders.setSrl(orderPullRecentInputSrl);
				return orderDao.plusInput(orders);
			} return -1;
		} return -1;
	}

	@Override
	public List<OrdersVO> pullPhase1() {
		return orderDao.pullPhase1();
	}

	@Override
	public List<OrdersVO> pullPhase2() {
		return orderDao.pullPhase2();
	}

	@Override
	public List<OrdersVO> pullPhase3() {
		return orderDao.pullPhase3();
	}

	@Override
	public int changePhase2() {
		return orderDao.changePhase2();
	}

	@Override
	public int changePhase3() {
		return orderDao.changePhase3();
	}

	@Override
	public List<OrdersVO> pullAllOrder() {
		return orderDao.pullAllOrder();
	}
}
