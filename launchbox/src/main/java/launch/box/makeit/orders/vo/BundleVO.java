/*
* 작성일 : 2015. 6. 8.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.vo;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;
import launch.box.makeit.user.vo.UserVO;

public class BundleVO {
	private List<ItemVO> Item;
	private OrdersVO order;
	private UserVO user;
	public List<ItemVO> getItem() {
		return Item;
	}
	public void setItem(List<ItemVO> item) {
		Item = item;
	}
	public OrdersVO getOrder() {
		return order;
	}
	public void setOrder(OrdersVO order) {
		this.order = order;
	}
	public UserVO getUser() {
		return user;
	}
	public void setUser(UserVO user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "BundleVO [Item=" + Item + ", order=" + order + ", user=" + user
				+ "]";
	}
	
}
