package com.dch.tutorial.cloud.eureka.book.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dch.tutorial.cloud.eureka.book.entity.BookEntity;
import com.dch.tutorial.cloud.eureka.book.repository.BookRepository;
import com.dch.tutorial.cloud.eureka.book.service.BookService;

/**
 * Classes are used to provide various {@link BookEntity} services. This class
 * implements from {@link BookService}.
 * 
 * @author David.Christianto
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookEntity save(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}

	@Override
	public Page<BookEntity> findByAuthorOrTitle(String author, String title, Pageable pageable) {
		return bookRepository.findByAuthorContainingOrTitleContaining(author, title, pageable);
	}
}
