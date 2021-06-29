package com.birprojedaha.asistan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@PropertySource("classpath:credentials.properties")
@ComponentScan(basePackages = "com.birprojedaha")
public class AsistanApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsistanApplication.class, args);
    }


    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
