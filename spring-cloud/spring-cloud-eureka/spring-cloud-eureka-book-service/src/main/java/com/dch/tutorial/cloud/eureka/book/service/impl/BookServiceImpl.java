package com.dch.tutorial.cloud.eureka.book.service.impl;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.dch.tutorial.cloud.eureka.book.dto.BookDto;
import com.dch.tutorial.cloud.eureka.book.dto.ContentListDto;
import com.dch.tutorial.cloud.eureka.book.dto.RatingDto;
import com.dch.tutorial.cloud.eureka.book.entity.BookEntity;
import com.dch.tutorial.cloud.eureka.book.repository.BookRepository;
import com.dch.tutorial.cloud.eureka.book.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * Classes are used to provide various {@link BookEntity} services. This class
 * implements from {@link BookService}.
 * 
 * @author David.Christianto
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private BookRepository bookRepository;

	@Override
	public BookEntity save(BookEntity bookEntity) {
		return bookRepository.save(bookEntity);
	}

	@Override
	public Page<BookEntity> getByAuthorOrTitle(String author, String title, Pageable pageable) {
		return bookRepository.findByAuthorContainingOrTitleContaining(author, title, pageable);
	}

	@HystrixCommand(fallbackMethod = "defaultRatings")
	@Override
	public BookDto getWithRatingsByBookId(Long bookId) {
		// @formatter:off
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("http://rating-service/rating/get")
			.queryParam("bookId", bookId)
			.queryParam("page", 0)
			.queryParam("size", 10);
		// @formatter:on

		@SuppressWarnings("unchecked")
		ContentListDto<RatingDto> ratingDtos = restTemplate.getForObject(builder.toUriString(), ContentListDto.class);

		BookEntity bookEntity = Optional.of(bookRepository.findOne(bookId))
				.orElseThrow(() -> new RuntimeException("Book ID not found!"));

		BookDto bookDto = new BookDto();
		bookDto.setAuthor(bookEntity.getAuthor());
		bookDto.setTitle(bookEntity.getTitle());
		bookDto.setRates(ratingDtos.getContentList());
		return bookDto;
	}

	/**
	 * Fallback method for get rating by book ID.
	 * 
	 * @param bookId
	 *            Book ID.
	 * @return {@link BookDto}
	 */
	protected BookDto defaultRatings(Long bookId) {
		BookEntity bookEntity = Optional.of(bookRepository.findOne(bookId))
				.orElseThrow(() -> new RuntimeException("Book ID not found!"));

		RatingDto ratingDto = new RatingDto();
		ratingDto.setBookId(bookId);
		ratingDto.setStars(0);
		ratingDto.setComment("N/A");

		BookDto bookDto = new BookDto();
		bookDto.setAuthor(bookEntity.getAuthor());
		bookDto.setTitle(bookEntity.getTitle());
		bookDto.setRates(Arrays.asList(ratingDto));

		return bookDto;
	}
}
