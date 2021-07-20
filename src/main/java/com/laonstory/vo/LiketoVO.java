package com.laonstory.vo;

public class LiketoVO {

	private int boardid;
	private int memId;
	
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getMemId() {
		return memId;
	}
	public void setMemId(int memId) {
		this.memId = memId;
	}
	@Override
	public String toString() {
		return "LiketoVO [boardid=" + boardid + ", memId=" + memId + "]";
	}

	
}
