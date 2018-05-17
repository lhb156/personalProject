package board.model;

import java.util.Date;

public class ReplyVO {
	private int reply_seq;
	private int re_board_seq;
	private String re_mem_id;
	private String re_cont;
	private Date re_date;
	private String re_yn;
	
	
	public int getReply_seq() {
		return reply_seq;
	}
	public void setReply_seq(int reply_seq) {
		this.reply_seq = reply_seq;
	}
	public int getRe_board_seq() {
		return re_board_seq;
	}
	public void setRe_board_seq(int re_board_seq) {
		this.re_board_seq = re_board_seq;
	}
	public String getRe_mem_id() {
		return re_mem_id;
	}
	public void setRe_mem_id(String re_mem_id) {
		this.re_mem_id = re_mem_id;
	}
	public String getRe_cont() {
		return re_cont;
	}
	public void setRe_cont(String re_cont) {
		this.re_cont = re_cont;
	}
	public Date getRe_date() {
		return re_date;
	}
	public void setRe_date(Date re_date) {
		this.re_date = re_date;
	}
	public String getRe_yn() {
		return re_yn;
	}
	public void setRe_yn(String re_yn) {
		this.re_yn = re_yn;
	}
	
	
}
