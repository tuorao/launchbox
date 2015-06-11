/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.service;

import java.util.ArrayList;
import java.util.List;

import kr.co.makeit.gcm.GCMSender;
import launch.box.makeit.item.dao.ItemDao;
import launch.box.makeit.item.vo.ItemVO;
import launch.box.makeit.itemlist.dao.ItemListDao;
import launch.box.makeit.itemlist.vo.ItemListVO;
import launch.box.makeit.orders.dao.OrdersDao;
import launch.box.makeit.orders.vo.BundleVO;
import launch.box.makeit.orders.vo.OrdersItemVO;
import launch.box.makeit.orders.vo.OrdersVO;
import launch.box.makeit.sets.dao.SetsDao;
import launch.box.makeit.user.dao.UserDao;
import launch.box.makeit.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

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
	@Autowired
	UserDao userDao;
	@Autowired
	PlatformTransactionManager transactionManager;
	
	DefaultTransactionDefinition def = null;
	TransactionStatus status = null;
	
	@Override
	public int input(OrdersVO order, List<ItemListVO> itemSrl) {
		ItemListVO itemList = new ItemListVO();
		OrdersVO orders = new OrdersVO();
		int d = 0;
		try {
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			orderDao.input(order);
			setsDao.input(order.getSort());

			for(int i=0; i<itemSrl.size(); i++){
				itemList.setItemSrl(itemSrl.get(i).getItemSrl());
				itemList.setSort(order.getSort());
				itemList.setAmount(itemSrl.get(i).getAmount());
				dao.input(itemList);
			}
			orders.setPrice(setPrice(order.getSort())*order.getAmount());
			orders.setSort(order.getSort());
			d = orderDao.plusInput(orders);
			transactionManager.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return d;
	}
	

	// 주문한것의 가격 합계
	@Override
	public int setPrice(String sort) {
		List<ItemListVO> t = dao.pullItemList(sort);
		int a = 0;
		for(int i=0; i<t.size(); i++){
			System.out.println(t.get(i).getItemSrl());
			ItemVO item = itemDao.pullItemInfo(t.get(i).getItemSrl());
			a += item.getPrice()*t.get(i).getAmount();
		}
		return a;
	}
//	@Override
//	public int input(OrdersVO order,List<Integer> itemSrl) {
//		
//		OrdersVO orders = new OrdersVO();
//		ItemListVO itemList = new ItemListVO();
//		
//		if(orderDao.input(order)==1){
//			orderPullRecentInputSrl = orderDao.pullRecentInputSrl();
//			if(setsDao.input(orderPullRecentInputSrl)==1){
//				setPullRecentInputSrl = setsDao.pullRecentPullSrl();
//				for(int i=0; i<itemSrl.size(); i++){
//					itemList.setSetSrl(setPullRecentInputSrl);
//					itemList.setItemSrl(itemSrl.get(i));
//					dao.input(itemList);
//				}
//				orders.setSetSrl(setPullRecentInputSrl);
//				orders.setPrice(setPrice(setPullRecentInputSrl));
//				orders.setSrl(orderPullRecentInputSrl);
//				return orderDao.plusInput(orders);
//			} return -1;
//		} return -1;
//	}


	@Override
	public int changePhase2() {
		return orderDao.changePhase2();
	}

	@Override
	public int changePhase3() {
		return orderDao.changePhase3();
	}


	@Override
	public List<BundleVO> callOrderList() {
		List<BundleVO> bundleList = new ArrayList<BundleVO>();
		
		OrdersVO order;
		List<ItemListVO> itemList;
		List<String> sortList;
		List<ItemVO> item;
		ItemVO itemVO;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
//			orderDao.alterAllPhase0to1();

			sortList = orderDao.pullAllSort();
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				item = new ArrayList<ItemVO>();
				itemList = dao.pullItemList(sortList.get(i));
				for(int j=0; j<itemList.size(); j++){
					itemVO = itemDao.pullItemInfo(itemList.get(j).getItemSrl());
					itemVO.setAmount(itemList.get(j).getAmount());
					item.add(itemVO);
				}
				BundleVO bundled = new BundleVO();
				bundled.setUser(userDao.pullUserInfo(order.getUserSrl()));
				bundled.setOrder(order);
				bundled.setItem(item);
				
				bundleList.add(bundled);
			}
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return bundleList;
	}


	@Override
	public List<OrdersItemVO> UserBuyList(int userSrl) {
		
		List<OrdersItemVO> orderitem = new ArrayList<OrdersItemVO>();
		List<ItemVO> item = new ArrayList<ItemVO>();
		
		try {
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			
			List<OrdersVO> order = orderDao.pullUserBuyList(userSrl);
			for(int i=0; i<order.size(); i++) {
				OrdersItemVO oi = new OrdersItemVO();
				oi.setOrder(order.get(i));

				List<ItemListVO> ItemList = dao.pullItemList(order.get(i).getSort());
				for(int a=0; a<ItemList.size(); a++){
					ItemVO itemVO = itemDao.pullItemInfo(ItemList.get(a).getItemSrl());
					itemVO.setAmount(ItemList.get(a).getAmount());
					item.add(itemVO);
				}
				oi.setItem(item);
				orderitem.add(oi);
			}
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return orderitem;
	}


	@Override
	public List<BundleVO> callPayedOrderList() {
		List<BundleVO> bundleList = new ArrayList<BundleVO>();
		
		OrdersVO order;
		List<ItemListVO> itemList;
		List<String> sortList;
		List<ItemVO> item = new ArrayList<ItemVO>();
		ItemVO itemVO;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			sortList = orderDao.pullPayedSort();
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				
				itemList = dao.pullItemList(sortList.get(i));
				for(int j=0; j<itemList.size(); j++){
					itemVO = itemDao.pullItemInfo(itemList.get(j).getItemSrl());
					itemVO.setAmount(itemList.get(j).getAmount());
					item.add(itemVO);
				}
				BundleVO bundled = new BundleVO();
				bundled.setUser(userDao.pullUserInfo(order.getUserSrl()));
				bundled.setOrder(order);
				bundled.setItem(item);
				
				bundleList.add(bundled);
			}
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return bundleList;
	}


	@Override
	public int alterPhase(int phase, int srl) {
		return orderDao.alterPhase(phase, srl);
	}


	@Override
	public List<BundleVO> pullPhase(int phase) {
		List<BundleVO> bundleList = new ArrayList<BundleVO>();
		
		OrdersVO order;
		List<ItemListVO> itemList;
		List<String> sortList;
		List<ItemVO> item = new ArrayList<ItemVO>();
		ItemVO itemVO;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			sortList = orderDao.pullPhase(phase);
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				
				itemList = dao.pullItemList(sortList.get(i));
				for(int j=0; j<itemList.size(); j++){
					itemVO = itemDao.pullItemInfo(itemList.get(j).getItemSrl());
					itemVO.setAmount(itemList.get(j).getAmount());
					item.add(itemVO);
				}
				BundleVO bundled = new BundleVO();
				bundled.setUser(userDao.pullUserInfo(order.getUserSrl()));
				bundled.setOrder(order);
				bundled.setItem(item);
				
				bundleList.add(bundled);
			}
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return bundleList;
	}


	@Override
	public int pushInput(int orderSrl) {
		
		UserVO user = null;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			OrdersVO order = orderDao.pullOrderInfo(orderSrl);
			user = userDao.pullUserInfo(order.getUserSrl());
			transactionManager.commit(status);

		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		
		GCMSender gcm = new GCMSender();
		gcm.setMessage("시발", "씨벌");
		gcm.sendMessage(user.getPushKey());
		return 0;
	}


	


}
