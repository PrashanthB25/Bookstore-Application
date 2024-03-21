package com.jsp.bookstore.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.bookstore.entity.MyBookList;
import com.jsp.bookstore.repository.MyBookRepository;
@Repository
public class MyBookListDao {
	
   @Autowired
    private MyBookRepository repository;
   
   public void saveMyBook(MyBookList book) {
	   repository.save(book);
   }
   public List<MyBookList> getall(){
	   return repository.findAll();
   }
   
   public void deleteMyBook(int id) {
	   MyBookList b=repository.findById(id).get();
	   if(b!=null) {
	   repository.deleteById(id);
	   }
   }
   
   
  
}
