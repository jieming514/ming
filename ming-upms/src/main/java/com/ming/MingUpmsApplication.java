package com.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MingUpmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingUpmsApplication.class, args);
    }
}
