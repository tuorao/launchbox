/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.itemlist.vo;

public class ItemListVO {
	
	private int itemListSrl;
	private int setSrl;
	private int itemSrl;
	private int isFlush;
	
	public int getItemListSrl() {
		return itemListSrl;
	}
	public void setItemListSrl(int itemListSrl) {
		this.itemListSrl = itemListSrl;
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
	public int getIsFlush() {
		return isFlush;
	}
	public void setIsFlush(int isFlush) {
		this.isFlush = isFlush;
	}
	
	@Override
	public String toString() {
		return "ItemListVO [itemListSrl=" + itemListSrl + ", setSrl=" + setSrl
				+ ", itemSrl=" + itemSrl + ", isFlush=" + isFlush + "]";
	}
	
}
