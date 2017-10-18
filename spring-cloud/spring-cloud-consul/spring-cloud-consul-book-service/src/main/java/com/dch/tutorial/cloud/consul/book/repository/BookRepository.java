package com.dch.tutorial.cloud.consul.book.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dch.tutorial.cloud.consul.book.entity.BookEntity;

/**
 * Repository of {@link BookEntity}. This interface extends
 * {@link JpaRepository}.
 * 
 * @author David.Christianto
 */
public interface BookRepository extends JpaRepository<BookEntity, Long> {

	/**
	 * Method used to get list of {@link BookEntity} by author or title.
	 * 
	 * @param author
	 * @param title
	 * @param pageable
	 *            Pagination information.
	 * @return {@link Page}&lt;{@link BookEntity}&gt; List of book.
	 */
	Page<BookEntity> findByAuthorContainingOrTitleContaining(String author, String title, Pageable pageable);
}
