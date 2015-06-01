/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.store.dao;

import java.sql.Date;

import launch.box.makeit.store.vo.StoreVO;

public interface StoreDao {
	int join(StoreVO store);
	int alter(StoreVO store);
	int dropout(String email, String emailDomain);
	String checkDuplicatedEmail(String email, String emailDomain);
	StoreVO pullStoreInfo(String email, String emailDomain);
	StoreVO login(String email, String emailDomain, String password);
	int inputLastLoginDate(Date lastLoginDate, String email, String emailDomain);
}
