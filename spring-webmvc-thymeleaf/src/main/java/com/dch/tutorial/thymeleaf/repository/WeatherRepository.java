package com.dch.tutorial.thymeleaf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dch.tutorial.thymeleaf.entity.WeatherEntity;
import com.dch.tutorial.thymeleaf.enums.DataStatus;

/**
 * Repository of {@link WeatherEntity}
 * 
 * @author David.Christianto
 */
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {

	/**
	 * Method used to get {@link WeatherEntity} by city name.
	 * 
	 * @param pageable
	 *            {@link Pageable} Pagination information.
	 * @param cityName
	 *            City name.
	 * @return {@link Page}&lt;{@link WeatherEntity}&gt; List of weather.
	 */
	Page<WeatherEntity> findByCityNameIgnoreCaseContainingAndStatus(Pageable pageable, String cityName,
			DataStatus status);
}
