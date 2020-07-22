package com.member.lib.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.lib.service.BookService;
import com.member.lib.service.impl.BookServiceImpl;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BookService bookService = new BookServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if("/book/list".equals(uri)) {
			request.setAttribute("bookList", bookService.selectBookList(null));
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-list");
			rd.forward(request, response);
			return;
		}
		if("/book/view".equals(uri)) {
			int bNum = Integer.parseInt(request.getParameter(uri));
			request.setAttribute("bookList", bookService.selectBook(bNum));
			RequestDispatcher rd = request.getRequestDispatcher("/views/book/book-view");
			rd.forward(request, response);
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}