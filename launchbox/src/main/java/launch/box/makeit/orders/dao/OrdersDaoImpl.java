/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.dao;

import java.util.List;

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
	public List<OrdersVO> pullPhase1() {
		return getSqlSession().selectList("order.pullPhase1");
	}

	@Override
	public List<OrdersVO> pullPhase2() {
		return getSqlSession().selectList("order.pullPhase2");
	}

	@Override
	public List<OrdersVO> pullPhase3() {
		return getSqlSession().selectList("order.pullPhase3");
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
	public List<OrdersVO> pullAllOrder() {
		return getSqlSession().selectList("order.pullAllOrder");
	}

}
