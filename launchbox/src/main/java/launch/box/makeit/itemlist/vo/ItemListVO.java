/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.itemlist.vo;

public class ItemListVO {
	
	private int srl; // itemlist 고유번호
	private int setSrl; // 세트번호
	private int itemSrl; // 아이템 번호
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getSetSrl() {
		return setSrl;
	}
	public void setSetSrl(int setSrl) {
		this.setSrl = setSrl;
	}
	public int getItemSrl() {
		return itemSrl;
	}
	public void setItemSrl(int itemSrl) {
		this.itemSrl = itemSrl;
	}
	@Override
	public String toString() {
		return "ItemListVO [srl=" + srl + ", setSrl=" + setSrl + ", itemSrl="
				+ itemSrl + "]";
	}
	
	
}
