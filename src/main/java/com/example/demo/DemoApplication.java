package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (CustomerRepository repository) {
        return args -> {
            Address address = new Address("Sweden","Södertälje", "15160");

            Customer customer = new Customer(
                    "Sally",
                    "Resch",
                    "lactose",
                    5,
                    Gender.FEMALE,
                    address,
                    List.of("BeefBourginouge"),
                    BigDecimal.valueOf(540485),
                    ZonedDateTime.now()
            );
        };
    }

}
