package com.test.springboot.testspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    private CurrenyServiceConfiguration configuration;

    @RequestMapping("/currency-configuration")
    public CurrenyServiceConfiguration getCurrentService(){
        return configuration;
    }
}
