package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class SameNumDAO {
	
	Random rd= new Random();
	
	Connection conn = null;
	PreparedStatement psmt=null;
	ResultSet rs = null;
	
	// 동적로딩, 권한확인
	public void dbOpen() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String id = "campus_24SW_BIG_p1_2";
			String pw = "smhrd2";
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1524:xe";
			
			conn=DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("동적 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("권한 확인 실패");
			e.printStackTrace();
		}
	}
	
	// 자원 반납
	public void dbClose() {
		try {
			if(rs!=null)
				rs.close();
			if(psmt!=null)
				psmt.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 가변배열에 데이터 저장
//	public static ArrayList<Integer> getList() {
//		ArrayList<Integer> list = new ArrayList<>();
//		for(int i=0; i<12; i++) {
//			list.add(i+1);
//		}
//		return list;
//	}
	
	public int SameNumMain() {
		
		int problem=rd.nextInt(56)+1;
		dbOpen();
		
		
		try {
			String sql="SELECT CARD FROM GAME2 WHERE NUM=?";
			psmt=conn.prepareStatement(sql);
			
			psmt.setInt(1, problem);
			
			rs=psmt.executeQuery();
			
			if (rs.next()) {
	            
	            problem = rs.getInt("CARD");
	        }
			
		} catch (SQLException e) {
			System.out.println("sql 실행 에러");
			e.printStackTrace();
		}finally {
			dbClose();
		}
		return problem;
		
	}
	
}
