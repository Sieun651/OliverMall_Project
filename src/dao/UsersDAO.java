package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dto.UsersDTO;

public class UsersDAO {
	// 데이터베이스 드라이버 로딩은 한 번만 수행되도록 변경
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 데이터베이스 연결 객체를 반환하는 메서드
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##dbexam";
		String password = "m1234";

		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 접속 성공 : Connection 객체, 접속 실패 : null
		return conn;
	}

	// insert 메서드 개선
	public int insert(UsersDTO dto) {
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, ?, ?)";
		int result = 0;

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPw());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getGender());
			pstmt.setString(6, dto.getBirth());
			pstmt.setString(7, dto.getEmail());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			return 0;
		}
		return result;
	}

	// selectAll 메서드 개선
	public List<UsersDTO> selectAll() {
		String sql = "SELECT * FROM users";
		List<UsersDTO> list = new ArrayList<>();

		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String tel = rs.getString("tel");
				String gender = rs.getString("gender");
				String birth = rs.getString("birth");
				String email = rs.getString("email");
				UsersDTO dto = new UsersDTO(name, id, pw, tel, gender, birth, email);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// searchID 메서드 개선
	public UsersDTO searchId(String id) {
		String sql = "SELECT * FROM users WHERE id=?";
		UsersDTO dto = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new UsersDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
}
