package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs= null;
	
	
	public void dbOpen() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String id = "campus_24SW_BIG_p1_2";
			String pw = "smhrd2";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			conn = DriverManager.getConnection(url,id,pw);
		}catch (ClassNotFoundException e) {
			System.out.println("동적 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("권한 확인 실패");
			e.printStackTrace();
		}
	}
	public void dbClose() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(psmt!=null)
				psmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public int joinmember(MemberDTO dto) {
			
			int cnt = 0;
			dbOpen();
			String sql ="insert into member values(?,?,0)";
			try {
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, dto.getID());
				psmt.setString(2, dto.getPW());
				
				cnt = psmt.executeUpdate();
				
				
			} catch (SQLException e) {
				System.out.println("SQL 실행 에러");
				e.printStackTrace();
			}finally {
				dbClose();
			}
			return cnt;
		}
	public MemberDTO login(MemberDTO dto) {
		dbOpen();
		String sql = "select * from member where ID = ? and pw = ?";
		try {
			psmt= conn.prepareStatement(sql);
			psmt.setString(1, dto.getID());
			psmt.setString(2, dto.getPW());
			rs = psmt.executeQuery();
			ArrayList<MemberDTO> user = new ArrayList<>();
			while(rs.next()) {
				// get
				String ID =rs.getString("ID");
				int point = rs.getInt("point");
				
			}
		}catch (SQLException e) {
			System.out.println("SQL 실행 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return dto;
	}
	
	}


