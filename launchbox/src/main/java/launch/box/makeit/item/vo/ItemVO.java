/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.item.vo;

public class ItemVO {
	
	private int itemSrl; // 아이템 고유 번호
	private String category; // 카테고리 ex)밥류,국류.. 
	private String title; // 제목 ex) 김치
	private int price; // 가격 ex) 김치 : 300
	private String photo; // 음식 사진
	private String content; // 음식 설명
	
	public int getItemSrl() {
		return itemSrl;
	}
	public void setItemSrl(int itemSrl) {
		this.itemSrl = itemSrl;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "ItemVO [itemSrl=" + itemSrl + ", category=" + category
				+ ", title=" + title + ", price=" + price + ", photo=" + photo
				+ ", content=" + content + "]";
	}
	
}
