/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.orders.vo;

import java.sql.Date;

public class OrdersVO {

	private int srl; // �ֹ� ���� ��ȣ
	private int userSrl;
	private int storeSrl; // ���� ��ȣ
	private int phase; // �ֹ� ���� ex) 1.����, 2.������, 3.�Ϸ�
	private int setSrl; // ��Ʈ ��ȣ 
	private int price; // ����
	private Date startTime; // ���� ���� �ð�
	private Date endTime; // ���� �� �ð�
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getStoreSrl() {
		return storeSrl;
	}
	public void setStoreSrl(int storeSrl) {
		this.storeSrl = storeSrl;
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
	@Override
	public String toString() {
		return "OrderVO [srl=" + srl + ", storeSrl=" + storeSrl + ", phase="
				+ phase + ", setSrl=" + setSrl
				+ ", price=" + price + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	public int getUserSrl() {
		return userSrl;
	}
	public void setUserSrl(int userSrl) {
		this.userSrl = userSrl;
	}
	
}
