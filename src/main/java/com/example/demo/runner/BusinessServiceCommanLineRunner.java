package com.example.demo.runner;

import com.example.demo.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BusinessServiceCommanLineRunner implements CommandLineRunner {

    private final BusinessService businessService;

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public BusinessServiceCommanLineRunner(BusinessService businessService) {
        this.businessService = businessService;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Max Value os {}",businessService.calculateMax());
    }
}
