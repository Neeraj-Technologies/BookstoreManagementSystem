package com.neeraj.bookstoremanagementsystem.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long book_id;
@Column(name = "title",nullable = false)
private String title;

@ManyToOne /* (fetch = FetchType.LAZY) */
@JoinColumn(name="author_id")
private Author author;

@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@JoinTable(name = "book_category", joinColumns = @JoinColumn(name="book_id"), 
inverseJoinColumns = @JoinColumn(name="category_id"))
private Set<Category> categories = new HashSet<>();

}
