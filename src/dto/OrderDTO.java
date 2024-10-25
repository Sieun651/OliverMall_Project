package dto;

public class OrderDTO {
	private String orderadate; // 주문일자
	private String name; // 상품이름
	private String orderno; // 주문번호
	private int itemno; // 상품번호
	// private String sale; // 상품가격
	private int id; // 유저 아이디
	private String orderstatus;

	public OrderDTO() {

	}

	public OrderDTO(String orderadate, String name, String orderno, int itemno, int id, String orderstatus) {
		super();
		this.orderadate = orderadate;
		this.name = name;
		this.orderno = orderno;
		this.itemno = itemno;
		this.id = id;
		// this.sale = sale;
		this.orderstatus = orderstatus;
	}

	@Override
	public String toString() {
		String str = "";
		if (itemno < 10) {
			str = String.format("0%s번 제품\n%s\n%s\n%s\n%s", itemno, orderadate, name, orderno, orderstatus);
		} else {
			str = String.format("%s번 제품\n%s\n%s\n%s\n%s", itemno, orderadate, name, orderno, orderstatus);
		}
		return str;

	}

	// getter & setter

	public String getOrderadate() {
		return orderadate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderadate(String orderadate) {
		this.orderadate = orderadate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public int getItemno() {
		return itemno;
	}

	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
//
//	  
//
//	   public String getSale() {
//	      return sale;
//	   }
//
//	   public void setSale(String sale) {
//	      this.sale = sale;
//	   }

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

}
