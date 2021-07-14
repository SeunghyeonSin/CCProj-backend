package com.laonstory.vo;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CommentVO {

	private int commentid;
	private int boardid;
	private String memId;
	private String writer;
	private String content;
	private Date date;
	private int anonymous;
	
	public int getCommentid() {
		return commentid;
	}
	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
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
	public int getAnonymous() {
		return anonymous;
	}
	public void setAnonymous(int anonymous) {
		this.anonymous = anonymous;
	}
	@Override
	public String toString() {
		return "CommentVO [commentid=" + commentid + ", boardid=" + boardid + ", memId=" + memId + ", writer=" + writer
				+ ", content=" + content + ", date=" + date + ", anonymous=" + anonymous + "]";
	}
	
}
