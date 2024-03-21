package com.jsp.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.bookstore.dao.BookDao;
import com.jsp.bookstore.entity.Book;

@Service
public class BookService {

	@Autowired
	private BookDao dao;
	
	public void saveBook(Book book) {
		dao.saveBook(book);
	}
	
	public List<Book> getBooks(){
		return dao.getallBooks();
	}
	public Book getById(int id) {
		return dao.getBookById(id);
	}
	public void updateBook(Book b) {
		dao.updateBook(b);
	}
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}
	
	public List<Book> getByName(String name) {
		return dao.getByName(name);
	}
	public List<Book> getByAuthor(String name) {
		return dao.getByAuthor(name);
	}
	
	
}
