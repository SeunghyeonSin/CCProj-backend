package com.laonstory.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class FileVO {

	private int fnum;
	private int bnum;
	private String fileName;
	private String fileOriName;
	private String fileUrl;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileOriName() {
		return fileOriName;
	}
	public void setFileOriName(String fileOriName) {
		this.fileOriName = fileOriName;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	@Override
	public String toString() {
		return "FileVO [fnum=" + fnum + ", bnum=" + bnum + ", fileName=" + fileName + ", fileOriName=" + fileOriName
				+ ", fileUrl=" + fileUrl + "]";
	}
	
}
