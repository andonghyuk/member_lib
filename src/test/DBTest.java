package test;

import java.sql.*;

public class DBTest {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##test", "test");
			String sql = "select m_num, m_id, m_pwd from member";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("m_num") + rs.getString("m_id") + rs.getString("m_pwd"));
			}
			
			sql = "insert into member (m_num, m_name, m_id, m_pwd, m_credat)";
			sql += " values(seq_member_m_num.nextval, ?,?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, "ㅅ두42142");
			ps.setString(2, "fdaetewa");
			ps.setString(3, "421");
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
