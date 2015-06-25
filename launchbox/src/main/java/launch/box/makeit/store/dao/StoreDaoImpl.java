/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.store.dao;

import java.util.HashMap;
import java.util.Map;

import launch.box.makeit.store.vo.StoreVO;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StoreDaoImpl extends SqlSessionDaoSupport implements StoreDao{

	@Override
	public int inputLastLoginDate( String email,
			String emailDomain) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("emailDomain", emailDomain);
		return getSqlSession().update("store.inputLastLoginDate", map);
	}

	@Override
	public int join(StoreVO store) {
		return getSqlSession().insert("store.join", store);
	}

	@Override
	public int alter(StoreVO store) {
		return getSqlSession().update("store.alter", store);
	}

	@Override
	public int dropout(String email, String emailDomain) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("emailDomain", emailDomain);
		return getSqlSession().delete("store.delete", map);
	}

	@Override
	public String checkDuplicatedEmail(String email, String emailDomain) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("emailDomain", emailDomain);
		return (String) getSqlSession().selectOne("store.checkDuplicatedEmail", map);
	}

	@Override
	public StoreVO pullStoreInfo(String email, String emailDomain) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("emailDomain", emailDomain);
		return (StoreVO) getSqlSession().selectOne("store.pullStoreInfo", map);
	}

	@Override
	public StoreVO login(String email, String emailDomain, String password) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", email);
		map.put("emailDomain", emailDomain);
		map.put("password", password);
		return (StoreVO) getSqlSession().selectOne("store.login", map);
	}

}
