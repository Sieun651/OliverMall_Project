package dto;

public class ItemDTO {
	private int itemno; // 상품 번호
	private String name; // 상품 이름
	private int cost; // 원가
	private int sale; // 판매가
	private int profit; // 이익
	private int discount; // 할인
	private String kind; // 상품 종류(1: 스킨케어, 2:포인트메이크업, 3: 베이스메이크업, 4: 선케어)
	private String content; // 상품 내용
	
	public ItemDTO() {
		
	}
	
	public ItemDTO(int itemno, String name, int cost, int sale, int profit, int discount, String kind, String content) {
		super();
		this.itemno = itemno;
		this.name = name;
		this.cost = cost;
		this.sale = sale;
		this.profit = profit;
		this.discount = discount;
		this.kind = kind;
		this.content = content;
	}
	
	
	@Override
	public String toString() {
		String str = "";
		if(itemno<10) {
			str = String.format("\n\n\n0%s번 제품\n%s\n정가: %s원\n판매가: %s원", itemno, name, cost, sale);
		} else {
			str = String.format("\n\n\n%s번 제품\n%s\n정가: %s원\n판매가: %s원", itemno, name, cost, sale);
		}
		return str;
	}
	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getProfit() {
		return profit;
	}
	public void setProfit(int profit) {
		this.profit = profit;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	

}
