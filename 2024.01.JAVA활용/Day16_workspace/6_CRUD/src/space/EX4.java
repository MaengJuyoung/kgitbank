package space;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EX4 {
	public static Connection getConn() throws SQLException {
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String id = "HR";
			String pw = "1234";
			return DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			throw e;
		}
	}
	public static void main(String[] args) {
		try (Connection conn = getConn()){
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String query1 = "INSERT INTO regions(region_id, region_name) VALUES (?,?)";
			String query2 = "SELECT * FROM regions";
			
			// executeUpdate() - 반환값이 정수값 / "얼마만큼의 레코드가 반영되었나?" 수량을 의미함
			// - WHERE절이 추가된 것들은 반환되는 것이 0이 될 수 있음
			// - 그 외의 문법문제/DB의 제약조건으로 SQLException이 발생하고..
			//   별도로 처리해서 재입력/재시도를 구성하게 됨
			int region_id = 11;
			while (true) {
				try {
					PreparedStatement psmt1 = conn.prepareStatement(query1);
					psmt1.setInt(1, region_id);
					psmt1.setString(2, "APPLE");
					int count = psmt1.executeUpdate();
					System.out.println("반영된 줄 수 : " + count + "줄");
					break;
				} catch (SQLException e) {
					System.out.print("!");
					region_id += 1;
				}
			}
			
			// execute() - 범용이기 때문에 특화구조를 만들기 힘듬
			// - 반환값이 boolean / ResultSet 객체가 생성되었는지를 반환함
			// - 같은 종류의 쿼리가 아닌, 다른 종류의 쿼리를 바꿔가며 실행하게 될 때
			// - CRUD를 독특하게 설계한 것이 아닌 이상, 쿼리가 바뀌어가며 실행될 일은 별로 없음
			PreparedStatement psmt = null;
			psmt = conn.prepareStatement(query1);
			psmt.setInt(1, 101);
			psmt.setString(2, "WOW");
			if (psmt.execute()) {
				System.out.println("결과물이 나왔습니다.");
				ResultSet rs = psmt.getResultSet();
			}
			else {
				System.out.println("결과물이 나오지 않습니다.");
				System.out.println( psmt.getUpdateCount());
			}
			psmt = conn.prepareStatement(query2);
			if (psmt.execute()) {
				System.out.println("결과물이 나왔습니다.");
				ResultSet rs = psmt.getResultSet();
			}
			else {
				System.out.println("결과물이 나오지 않습니다.");
				System.out.println( psmt.getUpdateCount());
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
