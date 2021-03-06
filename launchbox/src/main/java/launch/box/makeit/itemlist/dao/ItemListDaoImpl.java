/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.itemlist.dao;

import java.util.List;

import launch.box.makeit.itemlist.vo.ItemListVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class ItemListDaoImpl extends SqlSessionDaoSupport implements ItemListDao{

	@Override
	public int input(ItemListVO itemList) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("itemlist.input", itemList);
	}

	@Override
	public List<Integer> pullItemSrl(int setSrl) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("itemlist.pullItemSrl", setSrl);
	}

}
