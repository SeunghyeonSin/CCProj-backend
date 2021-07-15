package com.laonstory.vo;

public class LiketoVO {

	private int liketonum;
	private int boardid;
	private int memId;
	private boolean like_check;
	
	public int getLiketonum() {
		return liketonum;
	}
	public void setLiketonum(int liketonum) {
		this.liketonum = liketonum;
	}
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
	public boolean isLike_check() {
		return like_check;
	}
	public void setLike_check(boolean like_check) {
		this.like_check = like_check;
	}
	@Override
	public String toString() {
		return "LiketoVO [liketonum=" + liketonum + ", boardid=" + boardid + ", memId=" + memId + ", like_check="
				+ like_check + "]";
	}
}
