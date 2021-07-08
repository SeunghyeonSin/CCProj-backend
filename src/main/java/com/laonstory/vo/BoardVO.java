package com.laonstory.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class BoardVO {

	private int bnum;
	private String nickname;
	private String title;
	private String content;
	//private String file;
	private Date date;
	private int cnt;
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	@Override
	public String toString() {
		return "BoardVO [bnum=" + bnum + ", nickname=" + nickname + ", title=" + title + ", content=" + content
				 + ", date=" + date + ", cnt=" + cnt + "]";
	}
	
	
}
