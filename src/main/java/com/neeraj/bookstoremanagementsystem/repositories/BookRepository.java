package com.neeraj.bookstoremanagementsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neeraj.bookstoremanagementsystem.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

@Query("SELECT b FROM Book b WHERE LOWER(TRIM(b.title)) = LOWER(TRIM(:title))")
List<Book> findByTitleOne(@Param("title") String title);

//@Query("select b from Book b where b.author.name=?")
//public List<Book> findByAutherName(String AutherName);

//@Query("select b from Book b where b.author.name = :authorName")
//List<Book> findByAuthorName(@Param("authorName") String authorName);

@Query("SELECT b FROM Book b WHERE b.author.name = ?1")
List<Book> findByAuthorName(String authorName);

@Query("select b from Book b join b.categories c where LOWER(TRIM(c.name)) = LOWER(TRIM(:category))")
List<Book> findBooksByCategoryName(@Param("category") String category);
}
