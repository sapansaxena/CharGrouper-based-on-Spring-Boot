package com.spring.task.chargroup.configuration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * @author Sapan.Saxena
 * JAVA version of Web.XML This class is used to configure web app initializer used to run Spring based applications.
 * This class extends SpringBootServletInitializer and exposes configure method
 *
 */
public class WebXML extends SpringBootServletInitializer {


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RestWsConfig.class);
    }
    
    

}
