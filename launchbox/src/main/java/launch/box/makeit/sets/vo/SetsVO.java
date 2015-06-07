/*
* 작성일 : 2015. 6. 6.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.sets.vo;

import java.sql.Date;

public class SetsVO {
	private int srl;
	private int orderSrl;
	private Date inputTime;
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getOrderSrl() {
		return orderSrl;
	}
	public void setOrderSrl(int orderSrl) {
		this.orderSrl = orderSrl;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	@Override
	public String toString() {
		return "SetVO [srl=" + srl + ", orderSrl=" + orderSrl + ", inputTime="
				+ inputTime + "]";
	}
}
