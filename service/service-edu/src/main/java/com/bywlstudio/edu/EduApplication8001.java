package com.bywlstudio.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: zl
 * @Date: Create in 2021/1/6 22:43
 * @Description:
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.bywlstudio")
public class EduApplication8001 {
    public static void main(String[] args) {
            SpringApplication.run(EduApplication8001.class, args);
    }
}
