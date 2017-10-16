package com.dch.tutorial.cloud.eureka.rating.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dch.tutorial.cloud.eureka.rating.entity.RatingEntity;

/**
 * Repository of {@link RatingEntity}. This interface extends
 * {@link JpaRepository}.
 * 
 * @author David.Christianto
 */
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {

	/**
	 * Method used to get all rating by book.
	 * 
	 * @param bookId
	 *            Book ID.
	 * @param pageable
	 *            Pagination information.
	 * @return List of rating.
	 */
	Page<RatingEntity> findByBookId(Long bookId, Pageable pageable);
}
