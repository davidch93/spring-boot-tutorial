package com.dch.tutorial.cloud.consul.rating.rest.controller;

import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.dch.tutorial.cloud.consul.rating.dto.RatingDto;
import com.dch.tutorial.cloud.consul.rating.entity.RatingEntity;
import com.dch.tutorial.cloud.consul.rating.service.RatingService;

/**
 * Controller that manage any API about Rating Service.
 * 
 * @author David.Christianto
 */
@RestController
@RequestMapping(value = "/rating")
public class RatingRestController {

	@Autowired
	private RatingService ratingService;

	/**
	 * API that used to create a new rating of the book.
	 * 
	 * @param ratingDto
	 *            {@link RatingDto}
	 */
	@PostMapping(value = "/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createRate(@RequestBody RatingDto ratingDto) {
		RatingEntity ratingEntity = copyProperties(ratingDto, RatingEntity.class, null);
		ratingService.save(ratingEntity);
	}

	/**
	 * API that used to get all rating by book.
	 * 
	 * @param bookId
	 *            Book ID.
	 * @param pageable
	 *            Pagination information.
	 * @return List of rating.
	 */
	@GetMapping(value = "/get")
	public ResponseServiceDto<RatingDto> getByBookId(@RequestParam("bookId") Long bookId, Pageable pageable) {
		if (bookId == null || bookId == 0L)
			throw new RuntimeException("Book ID not found!");

		Page<RatingEntity> ratingEntities = ratingService.getByBookId(bookId, pageable);
		if (pageable.getPageNumber() > ratingEntities.getTotalPages())
			throw new RuntimeException("Resource not found!");

		ContentListDto<RatingDto> ratingDtos = new ContentListDto<>();
		ratingDtos.setPage(pageable.getPageNumber());
		ratingDtos.setSize(pageable.getPageSize());
		ratingDtos.setActualSize(ratingEntities.getTotalElements());
		ratingDtos.setContentList(ratingEntities.getContent().stream()
				.map(ratingEntity -> copyProperties(ratingEntity, RatingDto.class, null)).collect(Collectors.toList()));

		return new ResponseServiceDto<>(GenericStatus.SUCCESS, ratingDtos);
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
