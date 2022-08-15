package com.charan.bookclub.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.bookclub.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	
	List<Book> findAll();
	
	// Find books that a user has borrowed
	List<Book> findByBorrowerId(Long borrowerID);
	
}
