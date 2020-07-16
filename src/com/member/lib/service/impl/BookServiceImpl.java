package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.BookDAO;
import com.member.lib.dao.impl.BookDAOImpl;
import com.member.lib.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDAO bookDAO = new BookDAOImpl();

	@Override
	public Map<String, Object> insertBook(Map<String, Object> book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.insertBook(book);
//		rMap.put("msg", (result==1)?"도서 입력 성공~":"도서 입력 실패!"); //삼항연산자
		rMap.put("msg", "도서 입력 성공~");
		if (result != 1) {
			rMap.put("msg", "도서 입력 실패!");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateBook(Map<String, Object> book) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.updateBook(book);
		rMap.put("msg", "업데이트 성공");
		if (result != 1) {
			rMap.put("msg", "업데이트 실패");
		}
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> deleteBook(int bNum) {
		Map<String, Object> rMap = new HashMap<>();
		int result = bookDAO.deleteBook(bNum);
		rMap.put("msg", "삭제 성공");
		if (result != 1) {
			rMap.put("msg", "삭제 오류");
		}
		rMap.put("cnt", result);

		return rMap;
	}

	@Override
	public List<Map<String, Object>> selectBookList(Map<String, Object> book) {
		return bookDAO.selectBookList(book);
	}

	@Override
	public Map<String, Object> selectBook(int bNum) {
		return bookDAO.selectBook(bNum);
	}

	public static void main(String[] args) {
		BookService bookService = new BookServiceImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("b_title", "컴퓨터활용능력");
		map.put("b_author", "견본씌");
		map.put("b_desc", "시험볼때 짱이에요");
//		System.out.println(bookService.insertBook(map));

//		map.put("b_num", 41);
//		System.out.println(bookService.updateBook(map));

		
		System.out.println(bookService.deleteBook(41));

//		List<Map<String, Object>> bookList = bookService.selectBookList(map);
//		for(Map<String, Object> bk : bookList) {
//			System.out.println(bk);
//		}

//		System.out.println(bookService.selectBook(25));

	}

}
