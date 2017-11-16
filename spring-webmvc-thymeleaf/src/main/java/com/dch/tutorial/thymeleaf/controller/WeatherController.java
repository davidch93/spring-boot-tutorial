package com.dch.tutorial.thymeleaf.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.dch.tutorial.thymeleaf.common.pagination.PageWrapper;
import com.dch.tutorial.thymeleaf.common.validator.UpdateValidationGroup;
import com.dch.tutorial.thymeleaf.config.OpenWeatherMapSetting;
import com.dch.tutorial.thymeleaf.dto.CityDto;
import com.dch.tutorial.thymeleaf.dto.OpenWeatherMapDto;
import com.dch.tutorial.thymeleaf.entity.WeatherEntity;
import com.dch.tutorial.thymeleaf.service.CityService;
import com.dch.tutorial.thymeleaf.service.WeatherService;

/**
 * Controller that manage weather view.
 * 
 * @author David.Christianto
 */
@Controller
@RequestMapping(value = "/weather")
public class WeatherController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CityService cityService;

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private OpenWeatherMapSetting openWeatherMapSetting;

	@GetMapping(value = "/create")
	public ModelAndView createPage(ModelAndView mav, CityDto cityDto) {
		mav.addObject("cities", cityService.getAll());
		mav.addObject("activeTab", "weather");
		mav.setViewName("weather/weather-form");
		return mav;
	}

	@PostMapping(value = "/search-by-city")
	public ModelAndView searchByCity(ModelAndView mav, @Validated(UpdateValidationGroup.class) CityDto cityDto,
			BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			// @formatter:off
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherMapSetting.getApi())
				.queryParam("q", cityDto.getName())
				.queryParam("appid", openWeatherMapSetting.getAppId());
			// @formatter:on

			RestTemplate restTemplate = new RestTemplate();
			OpenWeatherMapDto openWeatherMapDto = restTemplate.getForObject(builder.toUriString(),
					OpenWeatherMapDto.class);

			mav.addObject("cities", cityService.getAll());
			mav.addObject("cityDto", cityDto);
			mav.addObject("openWeatherMap", openWeatherMapDto);
			mav.setViewName("weather/weather-form");
		} else {
			mav.addObject("cities", cityService.getAll());
			mav.setViewName("weather/weather-form");
		}
		
		mav.addObject("activeTab", "weather");
		return mav;
	}

	@PostMapping(value = "/create")
	public ModelAndView createWeather(ModelAndView mav, @Validated(UpdateValidationGroup.class) CityDto cityDto,
			BindingResult bindingResult, Locale locale) {
		if (!bindingResult.hasErrors()) {
			// @formatter:off
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(openWeatherMapSetting.getApi())
				.queryParam("q", cityDto.getName())
				.queryParam("appid", openWeatherMapSetting.getAppId());
			// @formatter:on

			RestTemplate restTemplate = new RestTemplate();
			OpenWeatherMapDto openWeatherMapDto = restTemplate.getForObject(builder.toUriString(),
					OpenWeatherMapDto.class);

			for (OpenWeatherMapDto.Weather weather : openWeatherMapDto.getWeather()) {
				WeatherEntity weatherEntity = new WeatherEntity();
				weatherEntity.setCityName(openWeatherMapDto.getName());
				weatherEntity.setCountry(openWeatherMapDto.getSys().getCountry());
				weatherEntity.setIcon(weather.getIcon());
				weatherEntity.setDescription(weather.getDescription());
				weatherEntity.setTemp(openWeatherMapDto.getMain().getTemp());
				weatherEntity.setTempMin(openWeatherMapDto.getMain().getTemp_min());
				weatherEntity.setTempMax(openWeatherMapDto.getMain().getTemp_max());
				weatherEntity.setWindSpeed(openWeatherMapDto.getWind().getSpeed());
				weatherEntity.setCloud(openWeatherMapDto.getClouds().getAll());
				weatherEntity.setPressure(openWeatherMapDto.getMain().getPressure());
				weatherEntity.setLat(openWeatherMapDto.getCoord().getLat());
				weatherEntity.setLon(openWeatherMapDto.getCoord().getLon());
				weatherService.save(weatherEntity);
			}

			mav.addObject("message", messageSource.getMessage("msg.success.weather.created",
					new String[] { cityDto.getName() }, locale));
			mav.setViewName("weather/weather");
		} else {
			mav.addObject("cities", cityService.getAll());
			mav.setViewName("weather/weather-form");
		}

		mav.addObject("activeTab", "weather");
		return mav;
	}

	@PostMapping(value = "/search")
	public ModelAndView searchWeathers(ModelAndView mav, Pageable pageable, CityDto cityDto) {
		PageWrapper<WeatherEntity> page = new PageWrapper<>(weatherService.getByCityName(pageable, cityDto.getName()),
				"/weather/get-all");
		mav.addObject("page", page);
		mav.addObject("cityName", cityDto.getName());
		mav.addObject("activeTab", "weather");
		mav.setViewName("weather/weather");
		return mav;
	}

	@GetMapping(value = "/get-all")
	public ModelAndView getAll(ModelAndView mav, Pageable pageable, @RequestParam("cityName") String cityName) {
		PageWrapper<WeatherEntity> page = new PageWrapper<>(weatherService.getByCityName(pageable, cityName),
				"/weather/get-all");
		mav.addObject("page", page);
		mav.addObject("cityName", cityName);
		mav.addObject("activeTab", "weather");
		mav.setViewName("weather/weather");
		return mav;
	}

	@PostMapping(value = "/remove/{id}")
	public ModelAndView removeWeather(ModelAndView mav, @PathVariable("id") Long weatherId, Locale locale) {
		WeatherEntity weatherEntity = weatherService.get(weatherId)
				.orElseThrow(() -> new RuntimeException("Weather with ID " + weatherId + " not found!"));
		weatherService.remove(weatherEntity);

		mav.addObject("message", messageSource.getMessage("msg.success.city.removed",
				new String[] { weatherEntity.getCityName() }, locale));
		mav.setViewName("weather/weather");
		mav.addObject("activeTab", "weather");
		return mav;
	}
}
