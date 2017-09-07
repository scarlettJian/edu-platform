package edu.bistu.platform.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:spring/*.xml")
public class EduPlatformStarter {

    public static void main(String[] args) {
        SpringApplication.run(EduPlatformStarter.class, args);
    }
}
