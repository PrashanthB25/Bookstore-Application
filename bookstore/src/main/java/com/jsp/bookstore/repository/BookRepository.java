package com.jsp.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.bookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	public List<Book> findByName(String name);
	
	public List<Book> findByAuthor(String author);
	
	public List<Book> findByPriceGreaterThan(long price);
	
	public List<Book> findByPrice(long price);
	
	public List<Book> findByPriceLessThan(long price);
	
	@Query("from Book where name=?1 order by name")
	public List<Book>finByNameSortde(String name);
	
}
