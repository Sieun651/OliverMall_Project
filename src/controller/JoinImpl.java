package controller;

import java.util.List;

import dao.UsersDAO;
import dto.UsersDTO;
import service.Join;

public class JoinImpl implements Join {
	UsersDAO dao = new UsersDAO();

	@Override
	public String join(UsersDTO dto) {
		// ID 중복 검사
		List<UsersDTO> list = dao.selectAll();
//		for (int i = 0; i < list.size(); i++) {
//			UsersDTO joinDTO = list.get(i);
//			if (joinDTO.getId().equals(dto.getId())) {
//				return dto.getId() + "사용할 수 없는 아이디 입니다.";
//			}
//		}
		// 저장
		int result = dao.insert(dto);
		if (result > 0)
			return "아이디가 생성되었습니다.";
		else
			return "중복된 아이디입니다.";
	}
}
