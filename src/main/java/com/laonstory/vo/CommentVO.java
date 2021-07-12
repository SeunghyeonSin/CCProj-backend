package com.laonstory.vo;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentVO {

	private int cnum;
	private int bnum;
	private String nickname;
	private String content;
	private Date date;
	
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String writer) {
		this.nickname = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CommentVO [cnum=" + cnum + ", bnum=" + bnum + ", nickname=" + nickname + ", content=" + content + ", date="
				+ date + "]";
	}
	
}
