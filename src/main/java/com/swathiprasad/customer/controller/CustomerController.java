package com.swathiprasad.customer.controller;

import com.swathiprasad.customer.dto.CustomerDTO;
import com.swathiprasad.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public CustomerDTO getCustomer() {
        log.info("API Request to get customer");
        return customerService.getCustomer();
    }

    @GetMapping("/async")
    public String executeAsync() {
        log.info("API Request before Async method call");
        customerService.executeAsync();
        log.info("API Request after Async method call");
        return "Request accepted";
    }

}
