/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.store.vo;

import java.sql.Date;

public class StoreVO {
	
	private int srl; 
	private String email; // id로 사용할 email
	private String emainDoamin; // email의 도메인
	private String password; // 비밀번호
	private String phone; // 전화번호
	private String location; // 주소
	private String division; // 업종구분
	private int worker; // 직원 수
	private String crn; // 사업자 등록번호
	private String info; // 매장 정보
	private Date joinDate; // 가입일
	private Date lastLoginDate; // 최근 로그인 날짜
	private Date alterDate; // 사용자 정보 변경 날짜
	
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmainDoamin() {
		return emainDoamin;
	}
	public void setEmainDoamin(String emainDoamin) {
		this.emainDoamin = emainDoamin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public int getWorker() {
		return worker;
	}
	public void setWorker(int worker) {
		this.worker = worker;
	}
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public Date getAlterDate() {
		return alterDate;
	}
	public void setAlterDate(Date alterDate) {
		this.alterDate = alterDate;
	}
	
	@Override
	public String toString() {
		return "StoreVO [srl=" + srl + ", email=" + email + ", emainDoamin="
				+ emainDoamin + ", password=" + password + ", phone=" + phone
				+ ", location=" + location + ", division=" + division
				+ ", worker=" + worker + ", crn=" + crn + ", info=" + info
				+ ", joinDate=" + joinDate + ", lastLoginDate=" + lastLoginDate
				+ ", alterDate=" + alterDate + "]";
	}

}
