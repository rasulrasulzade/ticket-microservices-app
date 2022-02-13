package com.company.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.company")
@EnableElasticsearchRepositories
@ComponentScan("com.company")
public class TicketConfig {

    @Bean
    public ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
