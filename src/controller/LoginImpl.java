package controller;

import java.util.List;

import dao.UsersDAO;
import dto.UsersDTO;
import service.Login;

public class LoginImpl implements Login{
	UsersDAO dao = new UsersDAO();
	
	@Override
	public String inputLogin(UsersDTO dto) {
		List<UsersDTO> list = dao.selectAll();
		for (int i = 0; i < list.size(); i++) {
			UsersDTO login = list.get(i);
			if (login.getId().equals(dto.getId())) {

				if(login.getPw().equals(dto.getPw())) {
					return "환영합니다";
				} 
			} 

		}
		return "아이디 또는 비밀번호가 틀렸습니다. 다시 입력하세요";
	}

}
