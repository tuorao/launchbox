/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.store.service;

import java.sql.Date;

import launch.box.makeit.store.dao.StoreDao;
import launch.box.makeit.store.vo.StoreVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	StoreDao dao;

	@Override
	public int join(StoreVO store) {
		return dao.join(store);
	}

	@Override
	public int alter(StoreVO store) {
		return dao.alter(store);
	}

	@Override
	public int dropout(String email, String emailDomain) {
		return dao.dropout(email, emailDomain);
	}

	@Override
	public int checkDuplicatedEmail(String email, String emailDomain) {
		if(dao.checkDuplicatedEmail(email, emailDomain)!=null) return 1;
		else return 0;
	}

	@Override
	public StoreVO pullStoreInfo(String email, String emailDomain) {
		return dao.pullStoreInfo(email, emailDomain);
	}

	@Override
	public StoreVO login(String email, String emailDomain, String password) {
		return dao.login(email, emailDomain, password);
	}

	@Override
	public int inputLastLoginDate(Date lastLoginDate, String email,
			String emailDomain) {
		return dao.inputLastLoginDate(lastLoginDate, email, emailDomain);
	}

}
