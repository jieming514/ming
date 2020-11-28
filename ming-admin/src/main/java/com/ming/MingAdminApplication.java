package com.ming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;


/**
 * @author jie_ming514
 */
@ServletComponentScan
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class MingAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingAdminApplication.class, args);
        System.out.println("=== welcome to ming-admin ===");
    }
}
