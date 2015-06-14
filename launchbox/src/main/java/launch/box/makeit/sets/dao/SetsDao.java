/*
* 작성일 : 2015. 6. 6.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.sets.dao;


public interface SetsDao {
	int input(String sort);		// set 입력
	int pullRecentPullSrl();	// 최근 입력한 srl 값 호출
}
