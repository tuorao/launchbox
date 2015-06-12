/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.service;

import kr.co.makeit.sms.SmsSender;
import launch.box.makeit.user.dao.UserDao;
import launch.box.makeit.user.vo.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao dao;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	DefaultTransactionDefinition def = null;
	TransactionStatus status = null;

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

	@Override
	public String confirmPhone(int userSrl) {
		int a = (int)(Math.random()*1000000);
		SmsSender sm = new SmsSender();
		String sendNumber = "010-1234-1234";
		String contents = "인증번호는 ["+a+"] 입니다";
		UserVO user = new UserVO();
		try {
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			user = dao.pullUserInfo(userSrl);
			UserVO user1 = new UserVO();
			user1.setRandom(a);
			user1.setSrl(userSrl);
			dao.checkEmail(user1);
			transactionManager.commit(status);
		} catch(Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		} 
		String rcvNumber = user.getPhone();
		
		return sm.sendSms(sendNumber, rcvNumber, contents);
	}

	@Override
	public int confirmCheck(int userSrl, int random) {
		UserVO user = dao.pullUserInfoFromRandom(random);
		if(userSrl==user.getSrl()){
			return 1;
		} else return 0;
	}


}
