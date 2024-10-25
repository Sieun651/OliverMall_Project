package service;
import java.util.List;

import dto.ItemDTO;

public interface Item {
	public String read();
	public String searchName(String name);
	public String readCategory(String category);
	public ItemDTO searchItemNo(int itemno);
}
