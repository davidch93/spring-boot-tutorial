package com.dch.tutorial.thymeleaf.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dch.tutorial.thymeleaf.entity.CityEntity;
import com.dch.tutorial.thymeleaf.enums.DataStatus;

/**
 * Repository of {@link CityEntity}.
 * 
 * @author David.Christianto
 */
public interface CityRepository extends JpaRepository<CityEntity, Long> {

	/**
	 * Method used to get {@link CityEntity} by name.
	 * 
	 * @param pageable
	 *            {@link Pageable} Pagination information.
	 * @param name
	 *            City name.
	 * @return {@link Page}&lt;{@link CityEntity}&gt; List of city.
	 */
	Page<CityEntity> findByNameIgnoreCaseContainingAndStatus(Pageable pageable, String name, DataStatus status);
}
