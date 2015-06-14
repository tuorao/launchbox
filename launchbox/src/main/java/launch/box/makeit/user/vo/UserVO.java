/*
* �ۼ��� : 2015. 6. 3.
* �ۼ��� : Administrator
*
* ����
*/
package launch.box.makeit.user.vo;

import java.util.Date;



public class UserVO {
	private int srl; // 유저 번호
	private int storeSrls; // 매장 번호 - 그냥 1로한다
	private String email; // 이메일
	private String emailDomain; // 이메일도메인
	private String password; // 비밀번호
	private String name; // 이름
	private String phone; // 폰
	private Date joinDate; // 가입일자
	private Date lastLoginDate; // 최근 로그인 날짜
	private String pwQuestion; // 비밀번호 찾기 질문
	private String pwAnswer; // 비밀번호 찾기 답
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
				+ password + ", name=" + name + ", phone=" + phone
				+ ", joinDate=" + joinDate + ", lastLoginDate=" + lastLoginDate
				+ ", pwQuestion=" + pwQuestion + ", pwAnswer=" + pwAnswer
				+ ", oAuthProvider=" + oAuthProvider + ", oAuthKey=" + oAuthKey
				+ ", pushKey=" + pushKey + "]";
	}

	
}
