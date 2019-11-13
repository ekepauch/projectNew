package com.sample.project.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Ekenedirichukwu Amaechi on 06/15/2019.
 */
@Configuration
public class CustomWebMvcAutoConfig extends WebMvcConfigurerAdapter {






    @Override
    public void addCorsMappings(CorsRegistry registry) {

             registry.addMapping("/**")
               .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(4800);
    }
}
