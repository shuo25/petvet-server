package com.vet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PetvetSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(PetvetSystemApplication.class,args);
    }
}