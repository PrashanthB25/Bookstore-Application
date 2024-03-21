package com.jsp.bookstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.bookstore.entity.Book;

import com.jsp.bookstore.service.BookService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	//Home
	@GetMapping("/")
	public String home() {
		return "home";
		
	}
	
	//new Book
	@GetMapping("/book_register")
	public String bookRegister() {
		return "bookRegister";
	}
	//save
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		
		List<Book> b=bookService.getByName(book.getName());
		if(b.isEmpty()) {
		bookService.saveBook(book);
		return "redirect:/avalable_books";
		}
		return "demo";
		
	}
	
	//Get Books
	@GetMapping("/avalable_books")
	public ModelAndView getAllBooks() {
    List<Book> l=bookService.getBooks();
	return new ModelAndView("bookList","book",l);
		 
	}
	
	
	//edit
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable int id ,Model model) {
		Book b=bookService.getById(id);
		model.addAttribute("book",b);
		return "editbook";
	}
	//update
	@PostMapping("/update")
	public String updateBook(@ModelAttribute Book b) {
		bookService.updateBook(b);
		return "redirect:/avalable_books";
	}
	
	
   //delete
	@GetMapping("delete_book/{id}")
	public String deleteBook(@PathVariable int id) {
		bookService.deleteBook(id);
		return "redirect:/avalable_books";
	}
	
	
	//search
	@GetMapping("/search")
	public String search() {
		return "search";
	}
	
	
     @GetMapping("/getbook")
	public String getBookByName(HttpServletRequest httpRequest ,Model model) {
    	 String name=httpRequest.getParameter("name");
		List<Book> b=bookService.getByName(name);
		if(b.size()!=0) {
			model.addAttribute("book", b);
			return "bookList";
		}
		return null;
		
	}
     
   //search
 	@GetMapping("/searchAuthor")
 	public String searchAuthor() {
 		return "author";
 	}
 	
     @GetMapping("/author")
     public String getBookByAuthor(HttpServletRequest request ,Model model) {
    	 String author=request.getParameter("author");
		List<Book> b=bookService.getByAuthor(author);
		model.addAttribute("book", b);
		return "bookList";
	}
    
     
     
	
	
	
	

}
