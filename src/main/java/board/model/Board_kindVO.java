package board.model;

import java.util.Date;

public class Board_kindVO {

	private int board_kind_seq;
	private String create_id;
	private String board_kind_nm;
	private Date board_kind_date;
	private String board_kind_yn;
	
	
	public int getBoard_kind_seq() {
		return board_kind_seq;
	}
	public void setBoard_kind_seq(int board_kind_seq) {
		this.board_kind_seq = board_kind_seq;
	}
	public String getCreate_id() {
		return create_id;
	}
	public void setCreate_id(String create_id) {
		this.create_id = create_id;
	}
	public String getBoard_kind_nm() {
		return board_kind_nm;
	}
	public void setBoard_kind_nm(String board_kind_nm) {
		this.board_kind_nm = board_kind_nm;
	}
	public String getBoard_kind_yn() {
		return board_kind_yn;
	}
	public void setBoard_kind_yn(String board_kind_yn) {
		this.board_kind_yn = board_kind_yn;
	}
	public Date getBoard_kind_date() {
		return board_kind_date;
	}
	public void setBoard_kind_date(Date board_kind_date) {
		this.board_kind_date = board_kind_date;
	}
	
	
	
}
