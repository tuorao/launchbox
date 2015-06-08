/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.dao;

import launch.box.makeit.user.vo.UserVO;

public interface UserDao {
	int join(UserVO user);
	int alter(UserVO user);
	int dropout(int srl);
	UserVO login(UserVO user);
	int inputPushKey(UserVO user);
	String checkEmail(UserVO user);
	String checkNickname(UserVO user);
	UserVO pullUserInfo(int srl);
}
