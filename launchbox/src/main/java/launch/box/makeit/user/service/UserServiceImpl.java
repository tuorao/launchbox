/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.service;

import launch.box.makeit.user.dao.UserDao;
import launch.box.makeit.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;

	@Override
	public int join(UserVO user) {
		return dao.join(user);
	}

	@Override
	public int alter(UserVO user) {
		return dao.alter(user);
	}

	@Override
	public int dropout(int srl) {
		return dao.dropout(srl);
	}

	@Override
	public UserVO login(UserVO user) {
		return dao.login(user);
	}

	@Override
	public int inputPushKey(UserVO user) {
		return dao.inputPushKey(user);
	}

	@Override
	public int checkEmail(UserVO user) {
		if(dao.checkEmail(user)!=null) return 1;
		else return 0;
	}


}
