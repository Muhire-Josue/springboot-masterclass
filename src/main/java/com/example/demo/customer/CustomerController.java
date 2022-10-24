package com.example.demo.customer;

import com.example.demo.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping(path = "api/v1/customers")
@RestController
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomer(){
        return customerService.getCustomers();
    }

    @GetMapping(path = "{id}")
    public Customer getCustomer(@PathVariable("id") Long id) {
        return customerService.getOne(id);
    }

    @GetMapping(path = "{id}/exception")
    public Customer getException(@PathVariable("id") Long id) {
        throw new ApiRequestException("ApiRequestException for customer " + id);
    }

    @PostMapping
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return customer;
    }
}
