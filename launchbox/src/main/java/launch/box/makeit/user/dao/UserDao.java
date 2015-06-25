/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.dao;

import java.util.List;

import launch.box.makeit.user.vo.UserVO;

public interface UserDao {
	int join(UserVO user);						// 유저 회원가입
	int alter(UserVO user);						// 유저 정보 변경
	int dropout(int srl);						// 회원 탈퇴
	UserVO login(UserVO user);					// 유저 로그인
	int inputPushKey(UserVO user);				// 푸쉬키 입력
	UserVO checkEmail(UserVO user);				// 이메일 중복 체크
	UserVO pullUserInfo(int srl);				// 유저 srl을 입력해서 UserVO 리턴
	int createRandom(UserVO user);				// 난수 생성
	UserVO pullUserInfoFromRandom(int random);
	List<String> pullAllPushKey();
}
