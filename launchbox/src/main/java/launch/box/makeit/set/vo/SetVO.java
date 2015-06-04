/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.set.vo;

public class SetVO {
	
	private int srl;
	private int orderSrl;
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
	@Override
	public String toString() {
		return "SetVO [srl=" + srl + ", orderSrl=" + orderSrl + "]";
	}

}
