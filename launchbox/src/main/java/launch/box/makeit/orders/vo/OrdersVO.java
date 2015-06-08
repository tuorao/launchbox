/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.orders.vo;

import java.util.Date;


public class OrdersVO {

	private int srl; // 주문 번호
	private int userSrl; // 고객 번호
	private int phase; // 페이즈
	private int price; // 가격
	private Date startTime; // 시작시간
	private Date endTime;  // 끝 시간
	private String sort; // 고유번호
	private int amount; // 수량
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getUserSrl() {
		return userSrl;
	}
	public void setUserSrl(int userSrl) {
		this.userSrl = userSrl;
	}
	public int getPhase() {
		return phase;
	}
	public void setPhase(int phase) {
		this.phase = phase;
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
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "OrdersVO [srl=" + srl + ", userSrl=" + userSrl + ", phase="
				+ phase + ", price=" + price + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", sort=" + sort + ", amount="
				+ amount + "]";
	}
	
}
