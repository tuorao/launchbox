/*
* 작성일 : 2015. 6. 3.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.user.service;

import launch.box.makeit.user.vo.UserVO;

public interface UserService {
	int join(UserVO user);
	int alter(UserVO user);
	int dropout(int srl);
	UserVO login(UserVO user);
	int inputPushKey(UserVO user);
	int checkEmail(UserVO user);
	int checkNickname(UserVO user);
}
