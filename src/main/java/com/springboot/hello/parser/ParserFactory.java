package com.springboot.hello.parser;

import com.springboot.hello.domain.Hospital;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParserFactory { // 조립

    @Bean
    public ReadLineContext<Hospital> readLineContext() {
        return new ReadLineContext<Hospital>(new HospitalParser());
    }
}
