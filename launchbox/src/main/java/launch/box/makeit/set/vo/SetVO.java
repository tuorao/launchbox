/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.set.vo;

public class SetVO {
	
	private int srl; // 세트 고유 번호
	private String category; // 카테고리 .. 이게 필요한가?
	private String title; // 세트 제목 .. 이것도 필요한가?
	private int price; // 가격, 아이템 리스트들의 가격
	private int orderCount; // 이것도 필요한가 ..?
	private String content; // 설명.. 이것도 필요한가?
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
