/*
* 작성일 : 2015. 6. 6.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.sets.dao;

import launch.box.makeit.sets.vo.SetsVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SetsDaoImpl extends SqlSessionDaoSupport implements SetsDao{

	@Override
	public int input(String sort) {
		SetsVO sets = new SetsVO();
		sets.setSort(sort);
		return getSqlSession().insert("sets.input", sets);
	}

	@Override
	public int pullRecentPullSrl() {
		return (Integer) getSqlSession().selectOne("sets.pullRecentInputSrl");
	}

}
