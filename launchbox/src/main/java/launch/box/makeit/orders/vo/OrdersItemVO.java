/*
* 작성일 : 2015. 6. 8.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.orders.vo;

import java.util.List;

import launch.box.makeit.item.vo.ItemVO;

public class OrdersItemVO {
	private List<ItemVO> Item;
	private OrdersVO order;
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
	@Override
	public String toString() {
		return "OrdersItemVO [Item=" + Item + ", order=" + order + "]";
	}

}
