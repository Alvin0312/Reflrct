package com.coderising.reflection.dynamicproxy;

import com.coderising.reflection.Book;

public class BookDAOImpl implements BookDAO{

	@Override
	public void addBook(String id , String name) {
		System.out.println("�����鼮   name="+name);
	}
	@Override
	public Book getBook(String id) {		
		return new Book(id,"�����鼮");
	}
	
}
