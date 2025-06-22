package com.uniquext.quickframe.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author penghaitao
 * @version 1.0
 * @description
 * @date 2025/6/22 18:41
 */
@SpringBootApplication
@MapperScan("com.uniquext.quickframe.repository.dao")
public class StarterApplication {
    public static void main(String[] args) {
        SpringApplication.run(StarterApplication.class, args);
    }
}