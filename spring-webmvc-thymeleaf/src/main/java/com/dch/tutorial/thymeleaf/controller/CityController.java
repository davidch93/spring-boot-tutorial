package com.dch.tutorial.thymeleaf.controller;

import com.dch.tutorial.thymeleaf.common.controller.BaseController;
import com.dch.tutorial.thymeleaf.common.pagination.PageWrapper;
import com.dch.tutorial.thymeleaf.common.validator.CreateValidationGroup;
import com.dch.tutorial.thymeleaf.dto.CityDto;
import com.dch.tutorial.thymeleaf.entity.CityEntity;
import com.dch.tutorial.thymeleaf.enums.DataStatus;
import com.dch.tutorial.thymeleaf.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Locale;

/**
 * Controller that manage city view.
 *
 * @author David.Christianto
 */
@Controller
@RequestMapping(value = "/city")
public class CityController extends BaseController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private CityService cityService;

    @PostMapping(value = "/search")
    public ModelAndView searchCities(ModelAndView mav, Pageable pageable, CityDto cityDto) {
        PageWrapper<CityEntity> page = new PageWrapper<>(cityService.getByName(pageable, cityDto.getName()),
                "/city/get-all");
        mav.addObject("page", page);
        mav.addObject("cityName", cityDto.getName());
        mav.addObject("activeTab", "city");
        mav.setViewName("city/city");
        return mav;
    }

    @GetMapping(value = "/get-all")
    public ModelAndView getAll(ModelAndView mav, Pageable pageable, @RequestParam("name") String name) {
        PageWrapper<CityEntity> page = new PageWrapper<>(cityService.getByName(pageable, name), "/city/get-all");
        mav.addObject("page", page);
        mav.addObject("cityName", name);
        mav.addObject("activeTab", "city");
        mav.setViewName("city/city");
        return mav;
    }

    @GetMapping(value = "/create")
    public ModelAndView createPage(ModelAndView mav, CityDto cityDto) {
        mav.addObject("url", "create");
        mav.addObject("activeTab", "city");
        mav.setViewName("city/city-form");
        return mav;
    }

    @PostMapping(value = "/create")
    public ModelAndView createCity(ModelAndView mav, @Validated(CreateValidationGroup.class) CityDto cityDto,
                                   BindingResult bindingResult, Locale locale) {

        if (!bindingResult.hasErrors()) {
            CityEntity cityEntity = copyProperties(cityDto, CityEntity.class);
            cityService.save(cityEntity);

            mav.addObject("message",
                    messageSource.getMessage("msg.success.city.created", new String[]{cityDto.getName()}, locale));
            mav.setViewName("city/city");
        } else {
            mav.addObject("url", "create");
            mav.setViewName("city/city-form");
        }

        mav.addObject("activeTab", "city");
        return mav;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView editPage(ModelAndView mav, @PathVariable("id") Long cityId) {
        CityEntity cityEntity = cityService.get(cityId)
                .orElseThrow(() -> new RuntimeException("City with ID " + cityId + " not found!"));
        mav.addObject("cityDto", copyProperties(cityEntity, CityDto.class));
        mav.addObject("url", "edit");
        mav.addObject("cityId", cityId);
        mav.addObject("activeTab", "city");
        mav.setViewName("city/city-form");
        return mav;
    }

    @PostMapping(value = "/edit/{id}")
    public ModelAndView editCity(ModelAndView mav, @PathVariable("id") Long cityId,
                                 @Validated(CreateValidationGroup.class) CityDto cityDto, BindingResult bindingResult, Locale locale) {

        if (!bindingResult.hasErrors()) {
            CityEntity cityEntity = copyProperties(cityDto, CityEntity.class);
            cityEntity.setCityId(cityId);
            cityEntity.setStatus(DataStatus.ACTIVATED);
            cityService.save(cityEntity);

            mav.addObject("message",
                    messageSource.getMessage("msg.success.city.edited", new String[]{cityDto.getName()}, locale));
            mav.setViewName("city/city");
        } else {
            mav.addObject("url", "edit");
            mav.addObject("cityId", cityId);
            mav.setViewName("city/city-form");
        }

        mav.addObject("activeTab", "city");
        return mav;
    }

    @PostMapping(value = "/remove/{id}")
    public ModelAndView removeCity(ModelAndView mav, @PathVariable("id") Long cityId, Locale locale) {
        CityEntity cityEntity = cityService.get(cityId)
                .orElseThrow(() -> new RuntimeException("City with ID " + cityId + " not found!"));
        cityService.remove(cityEntity);

        mav.addObject("message",
                messageSource.getMessage("msg.success.city.removed", new String[]{cityEntity.getName()}, locale));
        mav.setViewName("city/city");
        mav.addObject("activeTab", "city");
        return mav;
    }
}
