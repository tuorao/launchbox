/*
* 작성일 : 2015. 6. 4.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.itemlist.dao;

import java.util.List;

import launch.box.makeit.itemlist.vo.ItemListVO;

public interface ItemListDao {
	int input(ItemListVO itemList);					// ItemList를 추가한다
	List<Integer> pullItemSrl(String sort);			// sort에 해당하는 아이템리스트의 srl들을 가져온다
	List<ItemListVO> pullItemList(String sort);		// sort에 해당하는 아이템리스트를 가져온다
}
