package com.coderising.reflection.dynamicproxy;

import com.coderising.reflection.Book;

public interface BookDAO {  
    public void addBook(String id , String name);  
    
    public Book getBook(String id);
}