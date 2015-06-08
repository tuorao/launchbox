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
	int input(ItemListVO itemList);
	List<Integer> pullItemSrl(String sort);
	List<ItemListVO> pullItemList(String sort);
}
