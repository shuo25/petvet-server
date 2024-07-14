package com.vet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PetvetUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetvetUserApplication.class,args);
    }
}