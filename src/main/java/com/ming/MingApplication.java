package com.ming;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.ming.*.dao")
@SpringBootApplication
public class MingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MingApplication.class, args);
        System.out.println(
                "----------ming启动成功----------\n" +
                        " __   ___ _\n" +
                        "|   \\/   (_)_ __  __ _\n" +
                        "| |\\  /| | | '_ \\/ _` |\n" +
                        "| | \\/ | | | | || (_| |\n" +
                        "| |    | |_|_| |_\\__, |\n" +
                        "|_/    \\_|       |___/ \n" +
                        "-------------------------------\n");
    }
}
