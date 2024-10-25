package dto;

public class ReviewDTO {
	private int reviewno;
	private String title;
	private String content;
	private String id;
	private String regDate;
	private int itemno;
	
	public ReviewDTO() {
		
	}
	public ReviewDTO(int reviewno, String title, String content, String id, String regDate) {
		super();
		this.reviewno = reviewno;
		this.title = title;
		this.content = content;
		this.id = id;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		String str = "";
		str = String.format("%s\n%s\n%s\n%s", id, title, content, regDate);
		return str;
	}
	public int getReviewno() {
		return reviewno;
	}
	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	
	
	
}
