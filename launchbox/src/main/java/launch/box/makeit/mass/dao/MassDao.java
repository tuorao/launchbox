package launch.box.makeit.mass.dao;

import launch.box.makeit.mass.vo.MassVO;

public interface MassDao {
	int firstInput(MassVO mass);	// mass 정보를 처음 입력할떄
	int input(MassVO mass);			// mass 정보를 입력할때
	String existCheck(String phone);// mass에 이미 phone 값이 들어있는지 체크
	int pull(String phone);			// phone값으로  num값을 가져온다
}
