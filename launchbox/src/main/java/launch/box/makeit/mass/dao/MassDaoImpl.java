package launch.box.makeit.mass.dao;

import launch.box.makeit.mass.vo.MassVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MassDaoImpl extends SqlSessionDaoSupport implements MassDao{

	@Override
	public int firstInput(MassVO mass) {
		return getSqlSession().insert("mass.firstInput", mass);
	}

	@Override
	public int input(MassVO mass) {
		return getSqlSession().update("mass.input", mass);
	}

	@Override
	public String existCheck(String phone) {
		return (String) getSqlSession().selectOne("mass.existCheck", phone);
	}

	@Override
	public int pull(String phone) {
		return (Integer) getSqlSession().selectOne("mass.pull", phone);
	}

}
