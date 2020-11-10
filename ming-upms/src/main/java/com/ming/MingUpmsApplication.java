package com.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class MingUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingUpmsApplication.class, args);
        System.out.println("===welcome to ming-upms===");
    }
}
