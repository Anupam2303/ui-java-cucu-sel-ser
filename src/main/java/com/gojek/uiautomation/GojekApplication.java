package com.gojek.uiautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(
        basePackages = { "net.thucydides", "net.serenitybdd"}
)
public class GojekApplication {
    public static void main(String[] args) {
        SpringApplication.run(GojekApplication.class,args);
    }
}
