package com.tien.ss10.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.util.UrlPathHelper;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
        "com.tien.ss10.repository",
        "com.tien.ss10.service",
        "com.tien.ss10.controller"
})

public class AppConfig implements WebMvcConfigurer {
    private String HOST_NAME = "dv1nv2bj7";
    private String API_KEY = "627236299488196";
    private String API_SECRET = "J_cFRfX3W5Z1G71_1TIIzzUYO8c";

    //cau hinh ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(("/WEB-INF/views/"));
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
           "cloud_name", HOST_NAME,
           "api_key", API_KEY,
           "api_secret", API_SECRET,
           "secure", true
        ));
    }





    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper pathHelper = new UrlPathHelper();
        pathHelper.setRemoveSemicolonContent(false); // Rất quan trọng
        configurer.setUrlPathHelper(pathHelper);
    }
}