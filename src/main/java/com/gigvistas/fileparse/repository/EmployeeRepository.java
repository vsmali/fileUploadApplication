package com.gigvistas.fileparse.repository;

import com.gigvistas.fileparse.model.EmployeeDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDto,Integer> {

    EmployeeDto findById(int id);
    List<EmployeeDto> findAll();
    void deleteById(int id);
}