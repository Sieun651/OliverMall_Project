package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ItemDTO;
import dto.UsersDTO;

public class ItemDAO {
	public ItemDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

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
		return conn;
	}
	
	public List<ItemDTO> selectAll() {
		String sql = "select * from item order by itemno asc";
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemno(rs.getInt("itemno"));
				dto.setName(rs.getString("name"));
				dto.setCost(rs.getInt("cost"));
				dto.setSale(rs.getInt("sale"));
				dto.setProfit(rs.getInt("profit"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setKind(rs.getString("kind"));
				
				list.add(dto);
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
		return list;
	}
	
	public List<ItemDTO> selectCategory(String kind) {
		String sql = "select * from item where kind like ? order by itemno asc";
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(kind));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemno(rs.getInt("itemno"));
				dto.setName(rs.getString("name"));
				dto.setCost(rs.getInt("cost"));
				dto.setSale(rs.getInt("sale"));
				dto.setProfit(rs.getInt("profit"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setKind(rs.getString("kind"));
				list.add(dto);
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
		return list;
	}
	
	public List<ItemDTO> searchName(String name) {
		String sql = "select * from item where name like ? order by itemno asc";
		List<ItemDTO> list = new ArrayList<ItemDTO>();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ItemDTO dto = new ItemDTO();
				dto.setItemno(rs.getInt("itemno"));
				dto.setName(rs.getString("name"));
				dto.setCost(rs.getInt("cost"));
				dto.setSale(rs.getInt("sale"));
				dto.setProfit(rs.getInt("profit"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setKind(rs.getString("kind"));
				
				list.add(dto);
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
		return list;
	}
	public ItemDTO searchItemNo(int itemno) {
		String sql = "SELECT * FROM item WHERE itemno=?";
		ItemDTO dto = null;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, itemno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new ItemDTO();
				dto.setItemno(rs.getInt("itemno"));
				dto.setName(rs.getString("name"));
				dto.setCost(rs.getInt("cost"));
				dto.setSale(rs.getInt("sale"));
				dto.setProfit(rs.getInt("profit"));
				dto.setDiscount(rs.getInt("discount"));
				dto.setKind(rs.getString("kind"));
				dto.setContent(rs.getString("content"));
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
