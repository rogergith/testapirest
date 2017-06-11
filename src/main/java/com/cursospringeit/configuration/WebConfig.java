package com.cursospringeit.configuration;

import java.util.Locale;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/api/**")
			.allowedOrigins("*")
			.allowedMethods("GET","POST")
			.allowCredentials(false)
			.maxAge(3600);
			
	
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
	
	}

	
	
}
