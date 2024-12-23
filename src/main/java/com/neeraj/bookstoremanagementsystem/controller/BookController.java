package com.neeraj.bookstoremanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neeraj.bookstoremanagementsystem.entities.Book;
import com.neeraj.bookstoremanagementsystem.services.BookService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

@Autowired	
private BookService bookService;

@GetMapping("/by-title/{title}")	
public List<Book> getBooksByTitle(@PathVariable String title) {
	log.info("title :-{}",title);
	return bookService.getBooksByTitle(title);
}

@GetMapping("/by-auther/{autherName}")
public List<Book> getBooksByAutherName(@PathVariable String autherName){
	return bookService.getBooksByAutherName(autherName); 
}

@GetMapping("/by-category/{category}")
public List<Book> getBooksByCategory(@PathVariable String category){
	return bookService.getBooksByCategory(category);
}
}
