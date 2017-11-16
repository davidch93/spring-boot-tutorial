package com.dch.tutorial.thymeleaf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dch.tutorial.thymeleaf.common.service.GenericServiceImpl;
import com.dch.tutorial.thymeleaf.entity.CityEntity;
import com.dch.tutorial.thymeleaf.enums.DataStatus;
import com.dch.tutorial.thymeleaf.repository.CityRepository;
import com.dch.tutorial.thymeleaf.service.CityService;

/**
 * Classes are used to provide various {@link CityEntity} services. This class
 * extends {@link GenericServiceImpl} and implements {@link CityService}.
 * 
 * @author David.Christianto
 */
@Service("cityService")
public class CityServiceImpl extends GenericServiceImpl<CityEntity, Long> implements CityService {

	@Autowired
	private CityRepository cityRepository;

	@Override
	public Page<CityEntity> getByName(Pageable pageable, String name) {
		return cityRepository.findByNameIgnoreCaseContainingAndStatus(pageable, name, DataStatus.ACTIVATED);
	}
}
