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
        System.out.println("        .__                \n" +
                "  _____ |__| ____    ____  \n" +
                " /     \\|  |/    \\  / ___\\ \n" +
                "|  Y Y  \\  |   |  \\/ /_/  >\n" +
                "|__|_|  /__|___|  /\\___  / \n" +
                "      \\/        \\//_____/  \n" +
                "=============================");
    }
}
