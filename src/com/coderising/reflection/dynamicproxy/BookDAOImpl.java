package com.coderising.reflection.dynamicproxy;

import com.coderising.reflection.Book;

public class BookDAOImpl implements BookDAO{

	@Override
	public void addBook(String id , String name) {
		System.out.println("增加书籍   name="+name);
	}
	@Override
	public Book getBook(String id) {		
		return new Book(id,"测试书籍");
	}
	
}
