/*
* �ۼ��� : 2015. 6. 2.
* �ۼ��� : Administrator
*
* ����
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
		return getSqlSession().selectList("item.pullAllItem");
		
	}	

	@Override
	public int pullItemPrice(int srl) {
		return (Integer) getSqlSession().selectOne("item.pullItemPrice", srl);
	}

	@Override
	public ItemVO pullItemInfo(int srl) {
		return (ItemVO) getSqlSession().selectOne("item.pullItemInfo", srl);
	}

	@Override
	public List<ItemVO> pullPopularItem() {
		return getSqlSession().selectList("item.pullPopularItem");
	}

	
}
