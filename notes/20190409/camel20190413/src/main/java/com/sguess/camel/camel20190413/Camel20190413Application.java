package com.sguess.camel.camel20190413;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/applicationContext.xml")
public class Camel20190413Application {

    public static void main(String[] args) {
        SpringApplication.run(Camel20190413Application.class, args);
    }

}
