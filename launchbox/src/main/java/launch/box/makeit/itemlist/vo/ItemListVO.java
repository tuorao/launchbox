/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.itemlist.vo;

public class ItemListVO {
	
	private int srl; // itemlist 고유번호
	private int itemSrl; // 아이템 번호
	private int amount;
	private String sort; // 고유번호
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getItemSrl() {
		return itemSrl;
	}
	public void setItemSrl(int itemSrl) {
		this.itemSrl = itemSrl;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "ItemListVO [srl=" + srl + ", itemSrl=" + itemSrl + ", amount="
				+ amount + ", sort=" + sort + "]";
	}

}
