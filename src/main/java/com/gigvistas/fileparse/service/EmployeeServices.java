package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.dto.EmployeeDto;
import com.gigvistas.fileparse.entity.EmployeeEntity;
import com.gigvistas.fileparse.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {

    @Autowired
    EmployeeRepository employeeRepository;

    public Iterable<EmployeeEntity> findAll(){
        return employeeRepository.findAll();
    }

    public Optional<EmployeeEntity> findById(String userCode){
        return employeeRepository.findById(userCode);
    }

    public List<EmployeeEntity> findByPreferredLocation(String preferredLocation){
        return employeeRepository.findByPreferredLocation(preferredLocation);
    }

    public List<EmployeeEntity> findAllAndSortByName() {
        List<EmployeeEntity> response = employeeRepository.findAllOrderByNameAsc(Sort.by(Sort.Direction.ASC, "name"));
        return response;
    }



}
