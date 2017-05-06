package com.web.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.web.application.interceptor.ControllerAndActionNameInterceptor;

@Configuration
public class AdapterConfig extends WebMvcConfigurerAdapter{
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ControllerAndActionNameInterceptor()).addPathPatterns("/**");
	}

}
