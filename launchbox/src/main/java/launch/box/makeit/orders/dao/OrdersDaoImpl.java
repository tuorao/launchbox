/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import launch.box.makeit.orders.vo.OrdersVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl extends SqlSessionDaoSupport implements OrdersDao{

	@Override
	public int input(OrdersVO order) {
		return getSqlSession().insert("order.input", order);
	}

	@Override
	public int pullRecentInputSrl() {
		return (Integer) getSqlSession().selectOne("order.pullRecentInputSrl");
	}

	@Override
	public int plusInput(OrdersVO order) {
		return getSqlSession().update("order.plusInput", order);
	}

	@Override
	public int changePhase2() {
		return getSqlSession().update("order.changePhase2");
	}

	@Override
	public int changePhase3() {
		return getSqlSession().update("order.changePhase3");
	}

	@Override
	public List<String> pullAllSort() {
		return getSqlSession().selectList("order.pullALlSort");
	}

	@Override
	public OrdersVO pullOrder(String sort) {
		return (OrdersVO) getSqlSession().selectOne("order.pullOrder", sort);
	}

	@Override
	public List<OrdersVO> pullUserBuyList(int userSrl) {
		return getSqlSession().selectList("order.pullUserBuyList", userSrl);
	}

	@Override
	public int alterAllPhase0to1() {
		return getSqlSession().update("order.alterAllPhase0to1");
	}

	@Override
	public int alterPhase(int phase, int srl) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("phase", phase);
		map.put("srl", srl);
		return getSqlSession().update("order.alterPhase", map);
	}

	@Override
	public List<String> pullPayedSort() {
		return getSqlSession().selectList("order.pullPayedSort");
	}

	@Override
	public List<String> pullPhase(int phase) {
		return getSqlSession().selectList("order.pullPhase", phase);
	}

	@Override
	public int pullUserSrl(int srl) {
		return (Integer) getSqlSession().selectOne("order.pullUserSrl", srl);
	}

	@Override
	public OrdersVO pullOrderInfo(int srl) {
		return (OrdersVO) getSqlSession().selectOne("order.pullOrderInfo", srl);
	}
	


}
