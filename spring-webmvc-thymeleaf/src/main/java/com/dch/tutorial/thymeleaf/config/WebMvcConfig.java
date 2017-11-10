package com.dch.tutorial.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import nz.net.ultraq.thymeleaf.decorators.strategies.GroupingStrategy;

/**
 * Java configuration file that is used for Spring MVC and Thymeleaf
 * configurations.
 * 
 * @author David.Christianto
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	private static final String[] RESOURCE_LOCATIONS = { "classpath:/META-INF/resources/", "classpath:/resources/",
			"classpath:/static/", "classpath:/public/" };

	/**
	 * Bean of HTML template resolver.
	 * <p>
	 * The TemplateResolver bean properties prefix and suffix indicate the
	 * location of the view pages within the webapp directory and their filename
	 * extension, respectively.
	 * </p>
	 * 
	 * @return {@link ServletContextTemplateResolver}
	 */
	@Bean
	@Description("HTML Template Resolver")
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	/**
	 * The SpringTemplateEngine class performs all of the configuration steps.
	 * 
	 * @param templateResolver
	 *            {@link ITemplateResolver}
	 * @return {@link TemplateEngine}
	 */
	@Bean
	@Description("Thymeleaf Template Engine")
	public TemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new LayoutDialect(new GroupingStrategy()));
		engine.setTemplateResolver(templateResolver());
		return engine;
	}

	/**
	 * Bean of HTML view resolver.
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
	@Description("HTML View Resolver")
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setContentType("text/html");
		viewResolver.setCharacterEncoding("UTF-8");
		viewResolver.setViewNames(new String[] { "*.html" });
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if (!registry.hasMappingForPattern("/webjars/**"))
			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		if (!registry.hasMappingForPattern("/**"))
			registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
	}
}
