package com.gs.console.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @User远
 * @Date2022/3/25
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.gs.dao",
        "com.gs.console"
})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
