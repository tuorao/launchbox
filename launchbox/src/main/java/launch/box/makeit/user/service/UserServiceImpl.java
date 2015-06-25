/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.service;

import kr.co.makeit.sms.SmsSender;
import launch.box.makeit.mass.dao.MassDao;
import launch.box.makeit.mass.vo.MassVO;
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
	MassDao massDao;
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

//	@Override
//	public String confirmPhone(int userSrl) {
//		int a = (int)(Math.random()*1000000);
//		UserVO user = new UserVO();
//		try {
//			def = new DefaultTransactionDefinition();
//			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//			status = transactionManager.getTransaction(def);
//			
//			user = dao.pullUserInfo(userSrl);
//			UserVO user1 = new UserVO();
//			user1.setRandom(a);
//			user1.setSrl(userSrl);
//			dao.createRandom(user1);
//			transactionManager.commit(status);
//		} catch(Exception e) {
//			e.printStackTrace();
//			transactionManager.rollback(status);
//		} 
//////		String rcvNumber = user.getPhone();
//		SmsSender sm = new SmsSender();
//		String sendNumber = "010-7704-3347" ; // 보내는 사람 번호 (업체 전화번호)
//		String rcvNumber = user.getPhone();
//		String atos = String.valueOf(a);
//		String contents = "인증번호는 ["+atos+"] 입니다";
//
//		sm.sendSms(sendNumber,rcvNumber,contents);
//		return "12";
//	}
	
	/*	기능 : 전화번호를 입력받고 해당 번호로 문자 메시지 난수 6자리값 전송
	 * 	파라미터 : phone - 전화번호
	 * 	"error" 리턴시 전송 실패
	 */
	@Override
	public String confirmPhone(String phone) {
		int a = (int)(Math.random()*1000000);
		
		MassVO mass = new MassVO();
		mass.setNum(a);
		mass.setPhone(phone);
		
		try {
			def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
			status = transactionManager.getTransaction(def);
			
			if(massDao.existCheck(phone)!=null){	// 전화번호를 입력해서 기존 정보 존재유무 체크
				massDao.input(mass);				// 기존 입력값이 없을시 신규 입력
			} else {
				massDao.firstInput(mass);			// 기존 입력값이 존재 할 경우 기존 값 수정
			}
			
			transactionManager.commit(status);
		} catch(Exception e){
			e.printStackTrace();
			transactionManager.rollback(status);
		}

		SmsSender sm = new SmsSender();
		String sendNumber = "010-7704-3347" ; // 보내는 사람 번호 (업체 전화번호)
		String rcvNumber = phone;
		String atos = String.valueOf(a);
		String contents = "인증번호는 ["+atos+"] 입니다";

		return sm.sendSms(sendNumber,rcvNumber,contents);
	}

	/*	기능 : 난수값 
	 * 	파라미터 : phone - 전화번호, num - 문자로 전송 된  난수 6자리 값
	 */
	@Override
	public int confirmCheck(String phone, int num) {
		int dbNum = massDao.pull(phone);	// DB에 입력된 난수 값을 호출
		if(dbNum==num){						// DB에 저장된 난수값과 입력받은 난수값을 비교해서 리턴
			return 1;
		} else return 0;
	}

}
