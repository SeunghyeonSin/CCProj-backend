package com.laonstory.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserVO {

	private String memId;
	private String memPassword;
	private String memName;
	private String memNickname;
	private String memEmail;
	private String memRole;
	
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemNickname() {
		return memNickname;
	}
	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemRole() {
		return memRole;
	}
	public void setMemRole(String memRole) {
		this.memRole = memRole;
	}
	@Override
	public String toString() {
		return "UserVO [memId=" + memId + ", memPassword=" + memPassword + ", memName=" + memName + ", memNickname="
				+ memNickname + ", memEmail=" + memEmail + ", memRole=" + memRole + "]";
	}
	
	
}
