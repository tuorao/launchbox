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

	// 주문한것의 가격 합계
	@Override
	public int setPrice(int setSrl) {
		List<ItemListVO> t = dao.pullItemSrl(setSrl);
		int a = 0;
		for(int i=0; i<t.size(); i++){
			a += itemDao.pullItemPrice(t.get(i).getItemSrl());
		}
		return a;
	}

	@Override
	public int input(OrdersVO order) {
		int a = orderDao.input(order);
		
		return a;
	}
}
