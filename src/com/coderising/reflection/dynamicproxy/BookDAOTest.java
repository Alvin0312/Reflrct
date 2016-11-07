package com.coderising.reflection.dynamicproxy;

import com.coderising.reflection.Book;

public class BookDAOTest {
	public static void main(String [] args){
		BookDAO dao = new BookDAOImpl();
	//	dao.addBook("1","Head First Java");
		
		BookDAOProxy proxy = new BookDAOProxy(); 
		
        BookDAO bookProxy = (BookDAO) proxy.bind(dao);  
        bookProxy.addBook("1","Head First Java");  
        
     //   Book book = bookProxy.getBook("100");
	}
}
