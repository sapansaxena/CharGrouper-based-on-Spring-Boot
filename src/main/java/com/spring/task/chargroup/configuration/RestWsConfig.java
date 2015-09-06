package com.spring.task.chargroup.configuration;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author Sapan.Saxena
 * RestWsConfig class is used to initialize the web app which uses Spring application
 * Annotated with SpringBootApplication which indicates Configuration based out of Spring Boot
 * @ComponentScan is also added as Spring resources lie outside the package 
 *
 */
@ComponentScan("com.spring.task.chargroup.service.impl") 
@SpringBootApplication
public class RestWsConfig extends WebMvcConfigurerAdapter{
	
	
	/**
	 * Possible classpath resources
	 */
	private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
		"classpath:/META-INF/resources/", "classpath:/resources/",
		"classpath:/static/", "classpath:/public/" };
	
	/**
	 * Main method which initializes and executes Spring application based on Spring boot
	 * @param args String arguments array
	 */
	public static void main(String args[]){
		SpringApplication.run(RestWsConfig.class, args);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
        }
	
	 /**
	  * This class initialzies JSON mapping converter and assigns object mapper to the same
	 * @return converter based on MappingJackson2HttpMessageConverter
	 */
	@Bean
	    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
	        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper());
	        return mappingJackson2HttpMessageConverter;
	    }

	    /**
	     * Inits object mapper and returns the same. Needed for JSON based marshalling/unmarshalling of objects.
	     * @return object mapper
	     */
	    @Bean
	    public ObjectMapper objectMapper() {
	        ObjectMapper objMapper = new ObjectMapper();
	        objMapper.enable(SerializationFeature.INDENT_OUTPUT);
	        return objMapper;
	    }

	    @Override
	    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	        super.configureMessageConverters(converters);        
	        converters.add(mappingJackson2HttpMessageConverter());
	    }
}
