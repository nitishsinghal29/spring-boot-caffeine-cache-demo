package com.ns.demo.service;

import com.ns.demo.model.Book;

public interface BookService {
	
	Book getBookByISBN(String ISBN);

}
