package space;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EX3 {
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
			
			// ※ PreparedStatement의 기능
			// - PlaceHolder를 배치하기
			// - SQL쿼리문에서 값의 자리에만 배치할 수 있음
			// - "SQL Injection" 공격을 예방하는 구조를 가지고 있음
			Scanner sc = new Scanner(System.in);
			System.out.print("region id >> ");
			String value = sc.nextLine();
			
			// 1) 쿼리문에 PlaceHolder를 배치함 - ?로 대응됨
			//    ★ 쿼리문은 입력받은 것을 바로 직접 조립하시면 위험함
			String query = "SELECT * FROM countries WHERE region_id = ?";
			PreparedStatement psmt = conn.prepareStatement(query);

			// 2) 준비된 PreparedStatement 객체의 setSting/setInt 메서드로 값을 배치함
			//    ?는 좌측부터 1, 2, 3, ... 순으로 대응됨
			//    ※ 쿼리문/필드명에는 넣을 수 없는 구조
			psmt.setString(1, value);
			// -> 변환과정을 거치기 때문에 올바르지 않은 값일 경우 대응자체가 안됨
			
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.printf("%s %s %d\n",
						rs.getString("country_id"),
						rs.getString("country_name"),
						rs.getInt("region_id"));
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
