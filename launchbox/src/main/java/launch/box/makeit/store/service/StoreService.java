/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.store.service;

import java.sql.Date;

import launch.box.makeit.store.vo.StoreVO;

public interface StoreService {
	int join(StoreVO store);
	int alter(StoreVO store);
	int dropout(String email, String emailDomain);
	int checkDuplicatedEmail(String email, String emailDomain);
	StoreVO pullStoreInfo(String email, String emailDomain);
	StoreVO login(String email, String emailDomain, String password);
	int inputLastLoginDate(Date lastLoginDate, String email, String emailDomain);
}
