package com.example.Hack.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Hack.model.Book;
public interface BookRepository extends JpaRepository<Book, Long> {

}