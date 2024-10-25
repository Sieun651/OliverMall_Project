package controller;
import java.util.List;

import dao.OrderDAO;
import dto.OrderDTO;
import service.Order;



public class OrderImpl implements Order{
	OrderDAO dao = new OrderDAO();
	@Override
	public String readId(String id) {
		List<OrderDTO> list = dao.searchId(id);
	     String result = "";
	      for(int i=0; i<list.size(); i++) {
	         OrderDTO dto = list.get(i);
	         result += dto.toString() + "\t";
	      }
	      return result;
	}

}
