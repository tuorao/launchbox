/*
* �ۼ��� : 2015. 6. 1.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.set.vo;

public class SetVO {
	
	private int srl; // ��Ʈ ���� ��ȣ
	private String category; // ī�װ� .. �̰� �ʿ��Ѱ�?
	private String title; // ��Ʈ ���� .. �̰͵� �ʿ��Ѱ�?
	private int price; // ����, ������ ����Ʈ���� ����
	private int orderCount; // �̰͵� �ʿ��Ѱ� ..?
	private String content; // ����.. �̰͵� �ʿ��Ѱ�?
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "SetVO [srl=" + srl + ", category=" + category + ", title="
				+ title + ", price=" + price + ", orderCount=" + orderCount
				+ ", content=" + content + "]";
	}

}
