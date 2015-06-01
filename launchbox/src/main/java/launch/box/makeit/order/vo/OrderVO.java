/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.order.vo;

import java.sql.Date;

public class OrderVO {

	private int srl; // 주문 고유 번호
	private int storeSrl; // 매장 번호
	private int phase; // 주문 상태 ex) 1.착수, 2.조리중, 3.완료
	private int isFlush; // 쓸데없음
	private int setSrl; // 세트 번호 
	private int price; // 가격
	private Date startTime; // 조리 시작 시간
	private Date endTime; // 조리 끝 시간
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
	public int getIsFlush() {
		return isFlush;
	}
	public void setIsFlush(int isFlush) {
		this.isFlush = isFlush;
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
				+ phase + ", isFlush=" + isFlush + ", setSrl=" + setSrl
				+ ", price=" + price + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
	
}
