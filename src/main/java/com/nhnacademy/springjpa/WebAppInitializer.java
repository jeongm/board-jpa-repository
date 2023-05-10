package com.nhnacademy.springjpa;

import com.nhnacademy.springjpa.config.RootConfig;
import com.nhnacademy.springjpa.config.WebConfig;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    /*
        // TODO #1: @MultipartConfig
        @MultipartConfig(
            location = "/tmp",
            maxFileSize = -1L,
            maxRequestSize = -1L,
            fileSizeThreshold = 1024
        )
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        MultipartConfigElement multipartConfigElement
            = new MultipartConfigElement("/tmp/", -1, -1, 1024);

        registration.setMultipartConfig(multipartConfigElement);
    }
}
