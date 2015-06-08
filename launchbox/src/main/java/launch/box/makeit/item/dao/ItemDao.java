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
	List<ItemVO> pullAllItem();
	int pullItemPrice(int srl);
	ItemVO pullItemInfo(int srl);
}
