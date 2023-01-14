package com.jinnyjinnyjinjin.pharmacyrecommend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PharmacyRecommendApplication {

    public static void main(String[] args) {
        SpringApplication.run(PharmacyRecommendApplication.class, args);
    }

}
