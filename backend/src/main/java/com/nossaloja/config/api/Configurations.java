package com.nossaloja.config.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

@Configuration
public class Configurations {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
