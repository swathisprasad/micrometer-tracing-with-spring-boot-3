package com.swathiprasad.customer.service;

import com.swathiprasad.customer.dto.CustomerDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Logger log = LoggerFactory.getLogger(CustomerService.class);

    public CustomerDTO getCustomer() {
        log.info("Service request to get customer");
        return new CustomerDTO("John Doe");
    }

    @Async
    public void executeAsync() {
        log.info("Start Async method");
        //do something
    }
}
