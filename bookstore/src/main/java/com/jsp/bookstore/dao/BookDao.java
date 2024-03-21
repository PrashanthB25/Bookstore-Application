package com.jsp.bookstore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.bookstore.entity.Book;
import com.jsp.bookstore.repository.BookRepository;

@Repository
public class BookDao {

	@Autowired
	private BookRepository repository;
	
	public void saveBook(Book book) {
		repository.save(book);
	}
	public List<Book> getallBooks(){
		return repository.findAll();
	}
	public Book getBookById(int id) {
		return repository.findById(id).get();
	}
	
	public void updateBook(Book book) {
	Optional<Book> o=	repository.findById(book.getId());
    if(o.isPresent()) {
			repository.save(book);
      }
	}
	public void deleteBook(int id) {
		Book b=repository.findById(id).get();
		if(b!=null) {
			repository.deleteById(id);
		}
	}
	
	public List<Book> getByName(String name) {
		return repository.findByName(name);
	}
	public List<Book> getByAuthor(String name) {
		return repository.findByAuthor(name);
	}
	
	
	

}
