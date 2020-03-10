package com.galvanize.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.galvanize")
public class HelloRestControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloRestControllerApplication.class, args);
    }

}
