/*
* �ۼ��� : 2015. 6. 2.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.item.dao;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;

public interface ItemDao {
	List<ItemVO> pullAllItem();		// List<ItemVO>를 가져온다
	int pullItemPrice(int srl);		// itemSrl을 입력하면 해당 price를 가져온다
	ItemVO pullItemInfo(int srl);	// itemSrl을 입력하면 ItemVO를 가져온다
	List<ItemVO> pullPopularItem();	// 인기 아이템
}
