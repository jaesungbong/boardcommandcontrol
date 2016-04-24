package com.tacademy.board.vo;

import java.io.Serializable;

public class Board implements Serializable { //data Beans는 Serializable인터페이스

	private static final long serialVersionUID = 5234028455861905543L;
		
	private String seq; //목록
	private String title;
	private String writer;
	private String content;
	private String datetime;
	private int cnt; //조회수
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", datetime="
				+ datetime + ", cnt=" + cnt + "]";
	}
	
}
