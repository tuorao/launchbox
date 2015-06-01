/*
* 작성일 : 2015. 6. 1.
* 작성자 : Administrator
*
* 설명
*/
package launch.box.makeit.user.vo;

import java.sql.Date;

public class UserVO {

	private int srl;
	private int storeSrls;
	private String email;
	private String emailDomain;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private String address;
	private Date birthDate;
	private Date joinDate;
	private Date lastLoginDate;
	private String pwQuestion;
	private String pwAnswer;
	private int oAuthProvider;
	private String oAuthKey;
	private String pushKey;
	
	public int getSrl() {
		return srl;
	}
	public void setSrl(int srl) {
		this.srl = srl;
	}
	public int getStoreSrls() {
		return storeSrls;
	}
	public void setStoreSrls(int storeSrls) {
		this.storeSrls = storeSrls;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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
	public String getPwQuestion() {
		return pwQuestion;
	}
	public void setPwQuestion(String pwQuestion) {
		this.pwQuestion = pwQuestion;
	}
	public String getPwAnswer() {
		return pwAnswer;
	}
	public void setPwAnswer(String pwAnswer) {
		this.pwAnswer = pwAnswer;
	}
	public int getoAuthProvider() {
		return oAuthProvider;
	}
	public void setoAuthProvider(int oAuthProvider) {
		this.oAuthProvider = oAuthProvider;
	}
	public String getoAuthKey() {
		return oAuthKey;
	}
	public void setoAuthKey(String oAuthKey) {
		this.oAuthKey = oAuthKey;
	}
	public String getPushKey() {
		return pushKey;
	}
	public void setPushKey(String pushKey) {
		this.pushKey = pushKey;
	}
	
	@Override
	public String toString() {
		return "UserVO [srl=" + srl + ", storeSrls=" + storeSrls + ", email="
				+ email + ", emailDomain=" + emailDomain + ", password="
				+ password + ", name=" + name + ", nickname=" + nickname
				+ ", phone=" + phone + ", address=" + address + ", birthDate="
				+ birthDate + ", joinDate=" + joinDate + ", lastLoginDate="
				+ lastLoginDate + ", pwQuestion=" + pwQuestion + ", pwAnswer="
				+ pwAnswer + ", oAuthProvider=" + oAuthProvider + ", oAuthKey="
				+ oAuthKey + ", pushKey=" + pushKey + "]";
	}
	
}
