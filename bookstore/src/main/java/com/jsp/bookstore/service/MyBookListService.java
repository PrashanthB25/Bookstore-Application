package com.jsp.bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.bookstore.dao.MyBookListDao;
import com.jsp.bookstore.entity.MyBookList;
@Service
public class MyBookListService {

	@Autowired
	private MyBookListDao dao;
	
	public void savMyBook(MyBookList book) {
		dao.saveMyBook(book);
	}
	public List<MyBookList> getallMyBooks(){
		return dao.getall();
	}
	public void deleteMyBook(int id) {
		dao.deleteMyBook(id);
	}
}
