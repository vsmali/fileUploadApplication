package com.gigvistas.fileparse.configuration;

import com.gigvistas.fileparse.model.EmployeeDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class EmployeesContext {

    @Bean
    public List<EmployeeDto> getUsers(){
        List<EmployeeDto> users = new ArrayList<>();
        return users;
    }
}
