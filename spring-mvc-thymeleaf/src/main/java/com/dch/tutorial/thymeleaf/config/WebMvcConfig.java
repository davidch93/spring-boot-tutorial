package com.dch.tutorial.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

/**
 * Java configuration file that is used for Spring MVC and Thymeleaf
 * configurations.
 * 
 * @author David.Christianto
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * Bean of message source used for message resolver.
	 * 
	 * @return {@link ResourceBundleMessageSource}
	 */
	@Bean
	@Description("Spring Message Resolver")
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages/messages");
		messageSource.setCacheMillis(3600);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	/**
	 * Bean of template resolver.
	 * <p>
	 * The TemplateResolver bean properties prefix and suffix indicate the
	 * location of the view pages within the webapp directory and their filename
	 * extension, respectively.
	 * </p>
	 * 
	 * @return {@link ServletContextTemplateResolver}
	 */
	@Bean
	@Description("Thymeleaf Template Resolver")
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}

	/**
	 * Bean of template engine.
	 * <p>
	 * The SpringTemplateEngine class performs all of the configuration steps.
	 * </p>
	 * 
	 * @return {@link SpringTemplateEngine}
	 */
	@Bean
	@Description("Thymeleaf Template Engine")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setTemplateEngineMessageSource(messageSource());
		return templateEngine;
	}

	/**
	 * Bean of thymeleaf view resolver.
	 * <p>
	 * The ViewResolver interface in Spring MVC maps the view names returned by
	 * a controller to actual view objects. ThymeleafViewResolver implements the
	 * ViewResolver interface and is used to determine which Thymeleaf views to
	 * render, given a view name.
	 * </p>
	 * 
	 * @return {@link ThymeleafViewResolver}
	 */
	@Bean
	@Description("Thymeleaf View Resolver")
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setOrder(1);
		return viewResolver;
	}
}
