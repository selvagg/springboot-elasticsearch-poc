package com.scrapbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ScrapbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScrapbookApplication.class, args);
    }

}
