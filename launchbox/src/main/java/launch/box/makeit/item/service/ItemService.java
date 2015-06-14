/*
* �ۼ��� : 2015. 6. 2.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.item.service;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;


public interface ItemService {
	List<ItemVO> pullAllItem();		// List<ItemVO> 를 가져온다
	List<ItemVO> pullPopularItem();	// 인기아이템을 가져온다
}

