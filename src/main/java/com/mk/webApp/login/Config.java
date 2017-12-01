package com.mk.webApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
//public class Config extends WebMvcConfigurerAdapter{
public class Config extends WebMvcConfigurationSupport{	
	
	@Autowired
	RequestInterceptor requestInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		String[] excludes = {"/login*","/logout*"};
		registry.addInterceptor(requestInterceptor).excludePathPatterns(excludes);
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }
}
