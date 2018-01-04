package com.dch.tutorial.cloud.eureka.book.service;

import com.dch.tutorial.cloud.eureka.book.dto.BookDto;
import com.dch.tutorial.cloud.eureka.book.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface of {@link BookEntity} Service.
 *
 * @author David.Christianto
 */
public interface BookService {

    /**
     * Method used to save a new book.
     *
     * @param bookEntity The book to save.
     * @return The updated book.
     */
    BookEntity save(BookEntity bookEntity);

    /**
     * Method used to get list of {@link BookEntity} by author and title.
     *
     * @param author
     * @param title
     * @param pageable Pagination information.
     * @return {@link Page}&lt;{@link BookEntity}&gt; List of book.
     */
    Page<BookEntity> getByAuthorOrTitle(String author, String title, Pageable pageable);

    /**
     * Method used to get book with details rate by Book ID.
     *
     * @param bookId Book ID.
     * @return {@link}
     */
    BookDto getWithRatingsByBookId(Long bookId);
}
