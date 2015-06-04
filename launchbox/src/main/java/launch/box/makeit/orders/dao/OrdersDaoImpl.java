/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.dao;

import launch.box.makeit.orders.vo.OrdersVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDaoImpl extends SqlSessionDaoSupport implements OrdersDao{

	@Override
	public int input(OrdersVO order) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("order.input", order);
	}

}
