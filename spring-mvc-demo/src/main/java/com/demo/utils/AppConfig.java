package com.demo.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// toma el lugar de <mvc: annotation-driven/>
@EnableWebMvc
@ComponentScan(basePackages="com.demo.controllers") //<context:component-scan base-package="com.demo.controllers"></context:component-scan>
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter{
    
//    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
//    <property name="prefix" value="WEB-INF/jsp/"/>
//    <property name="suffix" value=".jsp"/>
//    </bean>
    @Bean
    public InternalResourceViewResolver getIRVR() {
        System.out.println("Setting up view resolver");
        InternalResourceViewResolver irvr = new InternalResourceViewResolver();
        irvr.setPrefix("WEB-INF/jsp/");
        irvr.setSuffix(".jsp");
        return irvr;
    }
    
//    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
//    <property name="maxUploadSize" value="525880"/> <!-- In Kb -->
//    </bean>
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("Setting up resources");
        registry.addResourceHandler("/myResources/**").addResourceLocations("/resources/");
    }
    

}
