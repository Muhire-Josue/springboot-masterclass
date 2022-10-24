package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer customer1 = new Customer(1L, "jane doe", "1234", "email@example1.com");
        Customer customer2 = new Customer(2L, "jane doe", "1234", "email@example2.com");
        customerRepository.saveAll(Arrays.asList(customer1, customer2));
        assertEquals(2, underTest.getCustomers().size());
    }

    @Test
    void getOne() {
        Customer customer = new Customer(3L, "jane doe", "1234", "email@example.com");
        customerRepository.save(customer);
        assertEquals(3L, customer.getId());
    }
}