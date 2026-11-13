package com.fraudlens.fraudlens_ai;

import com.fraudlens.fraudlens_ai.config.FraudlensProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(FraudlensProperties.class)
public class FraudlensAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FraudlensAiApplication.class, args);
    }
}
