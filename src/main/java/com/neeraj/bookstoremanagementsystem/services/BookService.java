package com.neeraj.bookstoremanagementsystem.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraj.bookstoremanagementsystem.entities.Author;
import com.neeraj.bookstoremanagementsystem.entities.Book;
import com.neeraj.bookstoremanagementsystem.repositories.AuthorRepository;
import com.neeraj.bookstoremanagementsystem.repositories.BookRepository;
import com.neeraj.bookstoremanagementsystem.repositories.CategoryRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	//private CategoryRepository categoryRepository;

	@Transactional
	public List<Book> getBooksByTitle(String title) {
		return bookRepository.findByTitleOne(title);
//	List<Book> books = bookRepository.findByTitle(title);
//	log.info("books :------{}",books);
//	return books.stream()
//            .map(BookDTO::new)
//            .collect(Collectors.toList());
	}

	@Transactional
	public List<Book> getBooksByAutherName(String AutherName) {
		return bookRepository.findByAuthorName(AutherName);
	}

	@Transactional
	public List<Book> getBooksByCategory(String category) {
		return bookRepository.findBooksByCategoryName(category);
	}

	public Book addNewBook(String authorName, String title, List<Category> categories) {
		Book book = new Book();
		Author author = authorRepository.findByName(authorName).orElseGet(() -> {
			Author newAuthor = new Author();
			newAuthor.setName(authorName);
			return authorRepository.save(newAuthor);
		});
//	 Author author = authorRepository.findByName(authorName)
//             .orElseGet(() -> {
//                 Author newAuthor = new Author();
//                 newAuthor.setName(authorName);
//                 return authorRepository.save(newAuthor); // Save new author to DB
//             });
//	for(Category category : categories) {
		return book;

//	}
	}
}
