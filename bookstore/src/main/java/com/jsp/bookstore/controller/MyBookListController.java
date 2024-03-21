package com.jsp.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.bookstore.entity.Book;
import com.jsp.bookstore.entity.MyBookList;
import com.jsp.bookstore.service.BookService;
import com.jsp.bookstore.service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService bookListService;
	@Autowired
	private BookService bookService;
	
	
    //get book
	@GetMapping("/my_book")
	public ModelAndView getMyBooks() {
	List<MyBookList> l=	bookListService.getallMyBooks();
		return new ModelAndView("mybooks","mybook",l);
	}
	
	//adding book
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable ("id") int id) {
		Book b=bookService.getById(id);
		MyBookList book=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		bookListService.savMyBook(book);
		return "redirect:/my_book";
	}
	
	//delete book
	@GetMapping("/delete/my_book/{id}")
	public String deleteMyBook(@PathVariable int id) {
		bookListService.deleteMyBook(id);
		return "redirect:/my_book";
	}
	
}
