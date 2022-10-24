package com.example.demo.customer;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component(value = "fake")
public class CustomerFakeRepository implements CustomerRepo{
    @Override
    public List<Customer> getCustomers() {
        return Arrays.asList(
                new Customer(1L, "John Doe", "12345", "email@example.com"),
                new Customer(2L, "Jane Doe", "12345", "email@example.com"),
                new Customer(3L, "Sara Doe", "12345", "email@example.com")
        );
    }
}
