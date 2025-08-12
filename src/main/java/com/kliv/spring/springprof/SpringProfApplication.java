package com.kliv.spring.springprof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class SpringProfApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfApplication.class, args);
    }

}
