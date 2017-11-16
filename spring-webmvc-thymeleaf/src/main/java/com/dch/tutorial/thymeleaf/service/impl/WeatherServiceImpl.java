package com.dch.tutorial.thymeleaf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dch.tutorial.thymeleaf.common.service.GenericServiceImpl;
import com.dch.tutorial.thymeleaf.entity.WeatherEntity;
import com.dch.tutorial.thymeleaf.enums.DataStatus;
import com.dch.tutorial.thymeleaf.repository.WeatherRepository;
import com.dch.tutorial.thymeleaf.service.WeatherService;

/**
 * Classes are used to provide various {@link WeatherEntity} services. This
 * class extends {@link GenericServiceImpl} and implements
 * {@link WeatherService}.
 * 
 * @author David.Christianto
 */
@Service("weatherService")
public class WeatherServiceImpl extends GenericServiceImpl<WeatherEntity, Long> implements WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	@Override
	public Page<WeatherEntity> getByCityName(Pageable pageable, String cityName) {
		return weatherRepository.findByCityNameIgnoreCaseContainingAndStatus(pageable, cityName, DataStatus.ACTIVATED);
	}

}
