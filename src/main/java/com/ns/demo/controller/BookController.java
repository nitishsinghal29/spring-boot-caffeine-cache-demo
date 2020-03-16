package com.ns.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ns.demo.model.Book;
import com.ns.demo.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(path = "/{ISBN}", produces = "application/json")
	public Book getBookByISBN(@PathVariable String ISBN) {
		return bookService.getBookByISBN(ISBN);
	}

}
