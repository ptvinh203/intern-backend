package com.ptvinh203.internbackend;

import com.ptvinh203.internbackend.configuration.auth_config.JwtApplicationProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties({JwtApplicationProperty.class})
@SpringBootApplication
public class InternBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternBackendApplication.class, args);
    }

}
