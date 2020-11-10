package com.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MingAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingAdminApplication.class, args);
        System.out.println("=== welcome to ming-admin ===");
    }
}
