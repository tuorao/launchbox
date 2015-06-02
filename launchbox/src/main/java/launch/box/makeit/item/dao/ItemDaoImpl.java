/*
* 작성일 : 2015. 6. 2.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.item.dao;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ItemDaoImpl extends SqlSessionDaoSupport implements ItemDao{

	@Override
	public List<ItemVO> pullAllItem() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("item.pullAllItem");
		
	}

	
}
