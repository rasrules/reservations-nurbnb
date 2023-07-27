package com.nurbnb.reservation.adapter.driver.restapi.spring.configurations;

import com.nurbnb.reservation.core.ports.driven.DateTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

    @Autowired
    private DateTimeService dateTimeService;

}
