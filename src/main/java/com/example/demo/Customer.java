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

    public Customer(String firstName,
                    String lastName,
                    String allergies,
                    int tableNumber,
                    Gender gender,
                    Address address,
                    List<String> favouriteFood,
                    BigDecimal foodBill,
                    ZonedDateTime created) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.allergies = allergies;
        this.tableNumber = tableNumber;
        this.gender = gender;
        this.address = address;
        this.favouriteFood = favouriteFood;
        this.foodBill = foodBill;
        this.created = created;
    }
}
