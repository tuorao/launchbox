/*
* 작성일 : 2015. 6. 6.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.sets.vo;

import java.util.Date;


public class SetsVO {
	private int srl; // 세트 번호
	private Date inputTime; // 입력시간
	private String sort; // 고유번호
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public Date getInputTime() {
		return inputTime;
	}
	public void setInputTime(Date inputTime) {
		this.inputTime = inputTime;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "SetsVO [srl=" + srl + ", inputTime=" + inputTime + ", sort="
				+ sort + "]";
	}

}
