package com.dch.tutorial.thymeleaf.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.dch.tutorial.thymeleaf.common.service.GenericService;
import com.dch.tutorial.thymeleaf.entity.WeatherEntity;

/**
 * Interface of {@link WeatherEntity} Service. This interface extends
 * {@link GenericService}.
 * 
 * @author David.Christianto
 */
public interface WeatherService extends GenericService<WeatherEntity, Long> {

	/**
	 * Method used to get {@link WeatherEntity} by city name.
	 * 
	 * @param pageable
	 *            {@link Pageable} Pagination information.
	 * @param cityName
	 *            City name.
	 * @return {@link Page}&lt;{@link WeatherEntity}&gt; List of weather.
	 */
	Page<WeatherEntity> getByCityName(Pageable pageable, String cityName);
}
