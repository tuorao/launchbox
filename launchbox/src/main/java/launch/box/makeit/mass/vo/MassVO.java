package launch.box.makeit.mass.vo;

public class MassVO {
	
	private int srl;		// mass 고유번호
	private int num;		// SMS 난수 6자리
	private String phone;	// 유저 전화번호
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Mass [srl=" + srl + ", num=" + num + ", phone=" + phone + "]";
	}

}
