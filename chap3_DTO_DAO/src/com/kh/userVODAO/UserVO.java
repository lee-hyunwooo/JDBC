package com.kh.userVODAO;

import java.util.Date;

/*
 * USER_ID USERNAME EMAIL REG_DATE
*/
public class UserVO {
	private int userId;       //사용자 ID
	private String userName; //사용자 이름
	private String email;	 //이메일
	private Date regDate;    //등록 날짜
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}