package controller;
import java.util.List;

import dao.ReviewDAO;
import dto.ReviewDTO;
import service.Review;

public class ReviewController implements Review{
	ReviewDAO dao = new ReviewDAO();
	@Override
	public String searchItemNo(int no) {
		List<ReviewDTO> list = dao.searchItemNo(no);
		String result = "";
		for(int i=0; i<list.size(); i++) {
			ReviewDTO dto = list.get(i);
			result += dto.toString() + "\t";
		}
		return result;
	}
	
}
