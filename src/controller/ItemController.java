package controller;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ItemDAO;
import dto.ItemDTO;
import service.Item;


public class ItemController implements Item{
	ItemDAO dao = new ItemDAO();
	@Override
	public String read() {
		List<ItemDTO> list = dao.selectAll();
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ItemDTO dto = list.get(i);
			result += dto.toString() + "\t";
		}
		return result;
	}
	@Override
	public String searchName(String name) {
		List<ItemDTO> list = dao.searchName(name);
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ItemDTO dto = list.get(i);
			result += dto.toString() + "\t";
		}
		return result;
	}
	@Override
	public String readCategory(String category) {
		List<ItemDTO> list = dao.selectCategory(category);
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ItemDTO dto = list.get(i);
			result += dto.toString() + "\t";
			
		}
		return result;
	}
	@Override
	public ItemDTO searchItemNo(int itemno) {
		ItemDTO dto = new ItemDTO();
		dto = dao.searchItemNo(itemno);
		return dto;
	}
}
