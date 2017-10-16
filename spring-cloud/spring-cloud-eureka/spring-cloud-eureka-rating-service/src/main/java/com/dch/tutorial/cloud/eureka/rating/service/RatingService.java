package com.dch.tutorial.cloud.eureka.rating.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dch.tutorial.cloud.eureka.rating.entity.RatingEntity;

/**
 * Interface of {@link RatingEntity} Service.
 * 
 * @author David.Christianto
 */
public interface RatingService {

	/**
	 * Method used to save a new rating.
	 * 
	 * @param ratingEntity
	 *            The rating to save.
	 * @return The updated rating.
	 */
	RatingEntity save(RatingEntity ratingEntity);

	/**
	 * Method used to get all rating by book.
	 * 
	 * @param bookId
	 *            Book ID.
	 * @param pageable
	 *            Pagination information.
	 * @return List of rating.
	 */
	Page<RatingEntity> getByBookId(Long bookId, Pageable pageable);
}
