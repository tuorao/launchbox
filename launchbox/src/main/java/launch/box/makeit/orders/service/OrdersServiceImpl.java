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
	
	/*
	 * (non-Javadoc)
	 * @see launch.box.makeit.orders.service.OrdersService#input(launch.box.makeit.orders.vo.OrdersVO, java.util.List)
	 * 	db 호출을 여러번하기 때문에 트랜잭션 사용
	 * 	주문 input
	 */
	@Override
	public int input(OrdersVO order, List<ItemListVO> itemSrl) {
		OrdersVO orders = new OrdersVO();
		int d = 0;
		try {
			
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			orderDao.input(order);
			// 먼저 order를 입력 (userSrl,phase,startTime,sort,amount)
			setsDao.input(order.getSort());
			// OrderController에서 생성한 sort와 현재시간 입력
			
			for(int i=0; i<itemSrl.size(); i++){
				ItemListVO itemList = new ItemListVO();

				itemList.setItemSrl(itemSrl.get(i).getItemSrl());
				itemList.setSort(order.getSort());
				itemList.setAmount(itemSrl.get(i).getAmount());
				dao.input(itemList);
			} // 주문받은 item들의 srl과 그 갯수를 for문을 통해 itemList에 집어넣는다
			orders.setPrice(setPrice(order.getSort())*order.getAmount());
			// 새로 생성한 orders 객체에 price 값을 입력한다
			orders.setSort(order.getSort());
			// 새로 생성한 orders 객체에 sort 값 입력한다
			d = orderDao.plusInput(orders);
			// orderDao.input에 추가로 업데이트를 실행한다
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

			sortList = orderDao.pullAllSort();
			// 분류 고유번호들을 호출한다
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				// 고유값을 통해 order 값을 불러온다
				item = new ArrayList<ItemVO>();
				itemList = dao.pullItemList(sortList.get(i));
				// 고유값을 통해 아이템 리스트를 불러온다
				for(int j=0; j<itemList.size(); j++){
					itemVO = itemDao.pullItemInfo(itemList.get(j).getItemSrl());
					itemVO.setAmount(itemList.get(j).getAmount());
					item.add(itemVO);
				} // 불러온 아이템 리스트를 기반으로 아이템의 가격과 양을 입력한다
				BundleVO bundled = new BundleVO();
				bundled.setUser(userDao.pullUserInfo(order.getUserSrl()));
				bundled.setOrder(order);
				bundled.setItem(item);
				
				bundleList.add(bundled);
				// 생성한 bundle 객체에 값을 집어넣는다
			}
			transactionManager.commit(status);
		}catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		return bundleList;
	}


	// 유저가 이미 구입했던 아이템들을 호출한다
	@Override
	public List<OrdersItemVO> UserBuyList(int userSrl) {
		
		List<OrdersItemVO> orderitem = new ArrayList<OrdersItemVO>();
		
		try {
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			
			List<OrdersVO> order = orderDao.pullUserBuyList(userSrl);
			for(int i=0; i<order.size(); i++) {
				OrdersItemVO oi = new OrdersItemVO();
				oi.setOrder(order.get(i));

				List<ItemListVO> ItemList = new ArrayList<ItemListVO>();
				ItemList = dao.pullItemList(order.get(i).getSort());
				List<ItemVO> item = new ArrayList<ItemVO>();
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


	// 이건 이미 지불된 주문의 목록을 호출하는거고
	@Override
	public List<BundleVO> callPayedOrderList() {
		List<BundleVO> bundleList = new ArrayList<BundleVO>();
		
		OrdersVO order;
		List<ItemListVO> itemList;
		List<String> sortList;
		ItemVO itemVO;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			sortList = orderDao.pullPayedSort();
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				
				itemList = dao.pullItemList(sortList.get(i));
				List<ItemVO> item = new ArrayList<ItemVO>();
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


	// 페이즈 변경
	@Override
	public int alterPhase(int phase, int srl) {
		return orderDao.alterPhase(phase, srl);
	}


	@Override
	public List<BundleVO> pullPhase(int phase) {
		List<BundleVO> bundleList = new ArrayList<BundleVO>();
		
		OrdersVO order;
		List<String> sortList;
		
		ItemVO itemVO;
		try{
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			sortList = orderDao.pullPhase(phase);
			for(int i=0; i<sortList.size(); i++){
				order = orderDao.pullOrder(sortList.get(i));
				List<ItemListVO> itemList = new ArrayList<ItemListVO>();
				itemList = dao.pullItemList(sortList.get(i));
				List<ItemVO> item = new ArrayList<ItemVO>();
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


	// 이거슨 푸쉬
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
		gcm.setMessage("주문완료!", user.getName()+" 님이 주문하신 도시락이 조리 완료되었습니다", "2", null, null); // requestCode=2 제작 완료
		gcm.sendMessage(user.getPushKey());
		
		
		return 0;
	}


	@Override
	public int noticePush(String notice) {
		List<String> AllUserPushKey = userDao.pullAllPushKey();
		GCMSender gcm = new GCMSender();
		gcm.setMessage("공지사항", notice, "1", null, null); // 1 은 공지사항
		gcm.sendMultiMessage(AllUserPushKey);
		return 0;
	}


	


}
