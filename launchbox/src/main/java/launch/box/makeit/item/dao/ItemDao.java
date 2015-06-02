/*
* 작성일 : 2015. 6. 2.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.item.dao;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;

public interface ItemDao {
	List<ItemVO> pullAllItem();
}
