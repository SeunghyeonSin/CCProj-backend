package com.laonstory.vo;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BoardVO {

	private int bnum;
	private String btype;
	private String memId;
	private String writer;
	private String title;
	private String content;
	//private String file;
	private Date date;
	private int cnt;
	private int anonymous;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBtype() {
		return btype;
	}
	public void setBtype(String btype) {
		this.btype = btype;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/*public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}*/
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(int anonymous) {
		this.anonymous = anonymous;
	}
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", btype=" + btype + ", memId=" + memId + ", writer=" + writer + ", title="
				+ title + ", content=" + content + ", date=" + date + ", cnt=" + cnt + ", anonymous=" + anonymous + "]";
	}
	
	
}
