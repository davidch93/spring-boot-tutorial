package com.dch.tutorial.thymeleaf.controller;

import java.util.Date;

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
	 * Index of page.
	 * 
	 * @param mav
	 *            {@link ModelAndView}
	 * @return {@link ModelAndView}
	 */
	@GetMapping(value = { "", "/" })
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("serverTime", new Date());
		mav.setViewName("index");
		return mav;
	}
}
