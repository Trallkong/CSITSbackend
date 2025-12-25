package com.trallkong.csitsbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.trallkong.csitsbackend.entity")
@EnableJpaRepositories("com.trallkong.csitsbackend.repository")
public class CsitSbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CsitSbackendApplication.class, args);
    }

}
