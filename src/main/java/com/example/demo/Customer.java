package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Document
public class Customer {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String allergies;
    private int tableNumber;
    private Gender gender;
    private Address address;
    private List<String> favouriteFood;
    private BigDecimal foodBill;
    private ZonedDateTime created;
}
