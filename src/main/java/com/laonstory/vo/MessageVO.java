package com.laonstory.vo;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessageVO {

	private int messagenum;
	private String sendnick;
	private String receinick;
	private String messagetitle;
	private String content;
	private Date date;
	
	public int getMessagenum() {
		return messagenum;
	}
	public void setMessagenum(int messagenum) {
		this.messagenum = messagenum;
	}
	public String getSendnick() {
		return sendnick;
	}
	public void setSendnick(String sendnick) {
		this.sendnick = sendnick;
	}
	public String getReceinick() {
		return receinick;
	}
	public void setReceinick(String receinick) {
		this.receinick = receinick;
	}
	public String getMessagetitle() {
		return messagetitle;
	}
	public void setMessagetitle(String messagetitle) {
		this.messagetitle = messagetitle;
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
		return "MessageVO [messagenum=" + messagenum + ", sendnick=" + sendnick + ", receinick=" + receinick
				+ ", messagetitle=" + messagetitle + ", content=" + content + ", date=" + date + "]";
	}
}
