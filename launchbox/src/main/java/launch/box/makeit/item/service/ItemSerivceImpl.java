/*
* �ۼ��� : 2015. 6. 2.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.item.service;

import java.util.List;

import launch.box.makeit.item.dao.ItemDao;
import launch.box.makeit.item.vo.ItemVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemSerivceImpl implements ItemService{
	
	@Autowired
	ItemDao dao;

	@Override
	public List<ItemVO> pullAllItem() {
		return dao.pullAllItem();
	}

	@Override
	public List<ItemVO> pullPopularItem() {
		return dao.pullPopularItem();
	}

}
