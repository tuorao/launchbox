/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.orders.vo;

import java.sql.Date;
import java.util.List;

import launch.box.makeit.itemlist.vo.ItemListVO;

public class OrdersVO {

	private int srl; 
	private int userSrl;
	private int phase; 
	private int setSrl; 
	private int price; 
	private Date startTime; 
	private Date endTime; 
	private List<ItemListVO> itemList;
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
	}
	public int getSetSrl() {
		return setSrl;
	}
	public void setSetSrl(int setSrl) {
		this.setSrl = setSrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getUserSrl() {
		return userSrl;
	}
	public void setUserSrl(int userSrl) {
		this.userSrl = userSrl;
	}
	public List<ItemListVO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemListVO> itemList) {
		this.itemList = itemList;
	}
	@Override
	public String toString() {
		return "OrdersVO [srl=" + srl + ", userSrl=" + userSrl + ", phase="
				+ phase + ", setSrl=" + setSrl + ", price=" + price
				+ ", startTime=" + startTime + ", endTime=" + endTime
				+ ", itemList=" + itemList + "]";
	}
	
}
