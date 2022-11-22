package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner (CustomerRepository repository, MongoTemplate mongoTemplate) {
        return args -> {
            Address address = new Address("Sweden","Södertälje", "15160");
            String lastName = "Resch";
            Customer customer = new Customer(
                    "Sally",
                    lastName,
                    "lactose",
                    5,
                    Gender.FEMALE,
                    address,
                    List.of("BeefBourginouge","falukorv"),
                    BigDecimal.TEN,
                    LocalDateTime.now()
            );

            //usingMongoTemplateAndQuery(repository, mongoTemplate, lastName, customer);
            repository.findCustomerByLastName(lastName)
                    .ifPresentOrElse(c -> {
                        System.out.println(c + "already exists");
                    }, ()->{System.out.println("Inserting customer " + customer);
                        repository.insert(customer);
                    });

        };
    }

    private void usingMongoTemplateAndQuery(CustomerRepository repository, MongoTemplate mongoTemplate, String lastName, Customer customer) {
        Query query = new Query();
        query.addCriteria(Criteria.where("lastName").is(lastName));

        List <Customer> customers = mongoTemplate.find(query,Customer.class);

        if(customers.size() >1){
            throw new IllegalStateException("found many students with same name " + lastName);
        }
        if(customers.isEmpty()){
            System.out.println("Inserting customer " + customer);
            repository.insert(customer);
        }else{
            System.out.println(customer + "already exists");
        }
    }

}
