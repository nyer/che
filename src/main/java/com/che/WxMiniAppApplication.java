package com.che;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WxMiniAppApplication {

    public static void main(String[] args) {

        SpringApplication.run(WxMiniAppApplication.class, args);
    }
}


