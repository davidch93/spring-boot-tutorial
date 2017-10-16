package com.dch.tutorial.cloud.eureka.rating.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dch.tutorial.cloud.eureka.rating.entity.RatingEntity;
import com.dch.tutorial.cloud.eureka.rating.repository.RatingRepository;
import com.dch.tutorial.cloud.eureka.rating.service.RatingService;

/**
 * Classes are used to provide various {@link RatingEntity} services. This class
 * implements from {@link RatingService}.
 * 
 * @author David.Christianto
 */
@Service("ratingService")
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingEntity save(RatingEntity ratingEntity) {
		return ratingRepository.save(ratingEntity);
	}

	@Override
	public Page<RatingEntity> getByBookId(Long bookId, Pageable pageable) {
		return ratingRepository.findByBookId(bookId, pageable);
	}

}
