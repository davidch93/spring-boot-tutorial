package com.dch.tutorial.thymeleaf.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dch.tutorial.thymeleaf.common.service.GenericService;
import com.dch.tutorial.thymeleaf.entity.CityEntity;

/**
 * Interface of {@link CityEntity} Service. This interface extends
 * {@link GenericService}.
 * 
 * @author David.Christianto
 */
public interface CityService extends GenericService<CityEntity, Long> {

	/**
	 * Method used to get {@link CityEntity} by name.
	 * 
	 * @param pageable
	 *            {@link Pageable} Pagination information.
	 * @param name
	 *            City name.
	 * @return {@link Page}&lt;{@link CityEntity}&gt; List of city.
	 */
	Page<CityEntity> getByName(Pageable pageable, String name);
}
