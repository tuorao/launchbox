/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.store.dao;

import launch.box.makeit.store.vo.StoreVO;

public interface StoreDao {
	int join(StoreVO store);
	int alter(StoreVO store);
	int dropout(String email, String emailDomain);
	String checkDuplicatedEmail(String email, String emailDomain);
	StoreVO pullStoreInfo(String email, String emailDomain);
	StoreVO login(String email, String emailDomain, String password);
	int inputLastLoginDate(String email, String emailDomain);
}
