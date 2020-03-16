package com.ns.demo.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.ns.demo.model.Book;

@Service
@CacheConfig(cacheNames = { "book" })
public class BookServiceImpl implements BookService {

	@Override
	@Cacheable
	public Book getBookByISBN(String ISBN) {
		return getBook(ISBN);
	}

	private Book getBook(String ISBN) {
		return new Book(ISBN, String.format("title%s", ISBN), String.format("author%s", ISBN));
	}

}
