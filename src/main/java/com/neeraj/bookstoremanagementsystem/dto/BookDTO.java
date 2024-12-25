package com.neeraj.bookstoremanagementsystem.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.neeraj.bookstoremanagementsystem.entities.Book;
import com.neeraj.bookstoremanagementsystem.entities.Category;

import lombok.Data;

@Data
public class BookDTO {
    private String title  ;
    private String authorName  ;
    private List<String> categoryNames;

    public BookDTO(Book book) {
        this.title = book.getTitle() ;
        this.authorName = book.getAuthor().getName();
        this.categoryNames = book.getCategories().stream()
                                 .map(Category::getName)
                                 .collect(Collectors.toList());
    }
}

