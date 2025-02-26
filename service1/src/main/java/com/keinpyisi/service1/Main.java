package com.keinpyisi.service1;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("com.keinpyisi.service1.model")
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        // Ensure the logs folder exists
        File logDirectory = new File("logs");
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();  // Create the logs folder if it doesn't exist
        }
    }


}
