package com.member.lib.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.common.Connector;
import com.member.lib.dao.BookDAO;
import com.member.lib.dao.MemberDAO;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public int insertMember(Map<String, Object> member) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = Connector.open();
			String sql = "insert into member(m_num, m_name, m_id, m_pwd, m_credat)\r\n"
					+ "values(SEQ_MEMBER_M_NUM.nextval, ?, ?,?,sysdate)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.get("m_name").toString());
			ps.setString(2, member.get("m_id").toString());
			ps.setString(3, member.get("m_pwd").toString());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {

			}
		}

		return result;
	}

	@Override
	public int updateMember(Map<String, Object> member) {
		return 0;
	}

	@Override
	public int deleteMember(int mNum) {
		return 0;
	}

	@Override
	public List<Map<String, Object>> selectMemberList(Map<String, Object> member) {
		return null;
	}

	@Override
	public Map<String, Object> selectMember(int mNum) {
		return null;
	}
	
	
	public static void main(String[] args) {
		MemberDAO mdao = new MemberDAOImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("m_name", "남궁");
		map.put("m_id", "namg17");
		map.put("m_pwd", "12345");
		mdao.insertMember(map);
	}
}
