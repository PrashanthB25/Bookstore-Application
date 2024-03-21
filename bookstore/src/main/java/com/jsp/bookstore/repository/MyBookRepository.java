package com.jsp.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.jsp.bookstore.entity.MyBookList;

public interface MyBookRepository extends JpaRepository<MyBookList, Integer>{


	

}
