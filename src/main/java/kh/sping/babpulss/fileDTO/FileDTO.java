package kh.sping.babpulss.fileDTO;

public class FileDTO {
	private int seq;
	private int boardSeq;
	private String fileName;
	private String oriFileName;
	
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getBoardSeq() {
		return boardSeq;
	}
	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOriFileName() {
		return oriFileName;
	}
	public void setOriFileName(String oriFileName) {
		this.oriFileName = oriFileName;
	}
	public FileDTO(int seq, int boardSeq, String fileName, String oriFileName) {
		this.seq = seq;
		this.boardSeq = boardSeq;
		this.fileName = fileName;
		this.oriFileName = oriFileName;
	}
	public FileDTO() {
	}
	
	
}
