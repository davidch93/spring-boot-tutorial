package com.dch.tutorial.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Main controller of Spring Web MVC.
 *
 * @author David.Christianto
 */
@Controller
public class MainController {

    /**
     * Home of page.
     */
    @GetMapping(value = "")
    public ModelAndView home(ModelAndView mav) {
        mav.addObject("activeTab", "city");
        mav.setViewName("home");
        return mav;
    }

    /**
     * City of page.
     */
    @GetMapping(value = "/city")
    public ModelAndView city(ModelAndView mav) {
        mav.addObject("activeTab", "city");
        mav.setViewName("city/city");
        return mav;
    }

    /**
     * Weather of page.
     */
    @GetMapping(value = "/weather")
    public ModelAndView weather(ModelAndView mav) {
        mav.addObject("activeTab", "weather");
        mav.setViewName("weather/weather");
        return mav;
    }
}
