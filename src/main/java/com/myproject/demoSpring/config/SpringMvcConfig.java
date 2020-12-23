package com.myproject.demoSpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import nz.net.ultraq.thymeleaf.LayoutDialect;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
	@Bean
	public LayoutDialect layoutDialect() {
		return new LayoutDialect();
	}
}
