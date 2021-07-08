package com.laonstory.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class NoteVO {

	private int noteid;
	private String sendnick;
	private String receinick;
	private String content;
	
	public int getNoteid() {
		return noteid;
	}
	public void setNoteid(int noteid) {
		this.noteid = noteid;
	}
	public String getSendnick() {
		return sendnick;
	}
	public void setSendnick(String sendnick) {
		this.sendnick = sendnick;
	}
	public String getRecenick() {
		return receinick;
	}
	public void setRecenick(String recenick) {
		this.receinick = recenick;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "NoteVO [noteid=" + noteid + ", sendnick=" + sendnick + ", receinick=" + receinick + ", content=" + content
				+ "]";
	}
	
}
