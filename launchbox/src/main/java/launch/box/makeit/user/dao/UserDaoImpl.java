/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.dao;

import launch.box.makeit.user.vo.UserVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{

	@Override
	public int join(UserVO user) {
		return getSqlSession().insert("user.join2", user);
	}

	@Override
	public int alter(UserVO user) {
		return getSqlSession().update("user.update", user);
	}

	@Override
	public int dropout(int srl) {
		return getSqlSession().delete("user.dropout", srl);
	}

	@Override
	public UserVO login(UserVO user) {
		return (UserVO) getSqlSession().selectOne("user.login", user);
	}

	@Override
	public int inputPushKey(UserVO user) {
		return getSqlSession().update("user.inputPushKey", user);
	}

	@Override
	public String checkEmail(UserVO user) {
		return (String) getSqlSession().selectOne("user.checkEmail", user);
	}

	@Override
	public String checkNickname(UserVO user) {
		return (String) getSqlSession().selectOne("user.checkNickname", user);
	}

}
