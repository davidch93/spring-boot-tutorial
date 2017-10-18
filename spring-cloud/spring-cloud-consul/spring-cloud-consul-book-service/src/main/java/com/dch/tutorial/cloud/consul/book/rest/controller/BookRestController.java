package com.dch.tutorial.cloud.consul.book.rest.controller;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dch.cloud.consul.common.dto.ContentListDto;
import com.dch.cloud.consul.common.dto.ErrorDto;
import com.dch.cloud.consul.common.dto.ResponseServiceDto;
import com.dch.cloud.consul.common.enums.GenericStatus;
import com.dch.tutorial.cloud.consul.book.dto.BookDto;
import com.dch.tutorial.cloud.consul.book.entity.BookEntity;
import com.dch.tutorial.cloud.consul.book.service.BookService;

/**
 * Controller that manage any API about Book Service.
 * 
 * @author David.Christianto
 */
@RestController
@RequestMapping(value = "/book")
public class BookRestController {

	@Autowired
	private BookService bookService;

	/**
	 * API that used to create a new book.
	 * 
	 * @param bookDto
	 *            {@link BookDto}
	 */
	@PostMapping(value = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createBook(@RequestBody BookDto bookDto) {
		BookEntity bookEntity = copyProperties(bookDto, BookEntity.class, null);
		bookService.save(bookEntity);
	}

	/**
	 * API that used to get books by author or title with pagination.
	 * 
	 * @param author
	 * @param title
	 * @param pageable
	 *            Pagination parameter.
	 * @return List of book.
	 */
	@GetMapping(value = "/get-all")
	public ResponseServiceDto<BookDto> getAll(@RequestParam("author") String author,
			@RequestParam("title") String title, Pageable pageable) {

		Page<BookEntity> bookEntities = bookService.getByAuthorOrTitle(author, title, pageable);
		if (pageable.getPageNumber() > bookEntities.getTotalPages())
			throw new RuntimeException("Resource not found!");

		ContentListDto<BookDto> bookDtos = new ContentListDto<>();
		bookDtos.setPage(pageable.getPageNumber());
		bookDtos.setSize(pageable.getPageSize());
		bookDtos.setActualSize(bookEntities.getTotalElements());
		bookDtos.setContentList(bookEntities.getContent().stream()
				.map(bookEntity -> copyProperties(bookEntity, BookDto.class, null)).collect(Collectors.toList()));

		return new ResponseServiceDto<>(GenericStatus.SUCCESS, bookDtos);
	}

	/**
	 * API that used to get book with details rating by book ID.
	 * 
	 * @param bookId
	 *            Book ID.
	 * @return {@link BookDto}
	 */
	@GetMapping(value = "/get-with-ratings/{bookId}")
	public ResponseServiceDto<BookDto> getWithRatings(@PathVariable("bookId") Long bookId) {
		if (bookId == null || bookId == 0L)
			throw new RuntimeException("Book ID not found!");

		return new ResponseServiceDto<>(GenericStatus.SUCCESS, bookService.getWithRatingsByBookId(bookId));
	}

	/**
	 * Method used to handle RuntimeException error.
	 * 
	 * @param ex
	 * @return {@link ErrorDto}
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseServiceDto<ErrorDto> handleRuntimeException(RuntimeException ex) {
		return new ResponseServiceDto<>(GenericStatus.FAILED,
				new ErrorDto(ex.getClass().getSimpleName(), ex.getMessage()));
	}

	/**
	 * Method used to Copy bean properties.
	 * 
	 * @param source
	 *            {@link Object} source data.
	 * @param clazz
	 *            {@link Class<T>} class of destination.
	 * @param ignoreProperty
	 *            ignore parameters.
	 * @return {@link T} destination object.
	 * @throws RuntimeException
	 *             if the class or its nullary constructor is not accessible or
	 *             if this Class represents an abstract class, an interface, an
	 *             array class, a primitive type, or void; or if the class has
	 *             no nullary constructor; or if the instantiation fails for
	 *             some other reason.
	 */
	protected <T> T copyProperties(Object source, Class<T> clazz, String[] ignoreProperty) {
		try {
			if (source == null)
				return null;

			T target = clazz.newInstance();
			if (ignoreProperty != null)
				BeanUtils.copyProperties(source, target, ignoreProperty);
			else
				BeanUtils.copyProperties(source, target);

			return target;
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
}
