package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.impl.LentDAOImpl;
import com.member.lib.service.LentService;


public class LentServiceImpl implements LentService {

	private LentDAO lentDAO = new LentDAOImpl();
	
	@Override
	public Map<String, Object> insertLent(Map<String, Object> lent) {
		int result = lentDAO.insertLent(lent);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "대여 완료");
		if(result != 1) {
			rMap.put("msg", "대여 불가");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> lent) {
		int result = lentDAO.updateLent(lent);
		Map<String, Object> rMap = new HashMap<>();
		rMap.put("msg", "대여 정보 업데이트 성공");
		if(result != 1) {
			rMap.put("msg", "대여 정보 업데이트 실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteLent(int lNum) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> lent) {
		return null;
	}

	@Override
	public Map<String, Object> selectLent(int lNum) {
		return null;
	}
	
	public static void main(String[] args) {
		LentService lentService = new LentServiceImpl();
		Map<String, Object> lent = new HashMap<>();
		lent.put("m_num",44);
		lent.put("b_num",23);
		System.out.println(lentService.insertLent(lent));
//		System.out.println(lentService.updateLent(lent));
	}

	@Override
	public List<Map<String, Object>> selectNoLentBookList() {
		return lentDAO.selectNoLentBookList();
	}

}
