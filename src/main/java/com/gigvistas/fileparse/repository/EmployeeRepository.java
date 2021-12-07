package com.gigvistas.fileparse.repository;

import com.gigvistas.fileparse.model.EmployeeDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDto,String> {

    List<EmployeeDto> findAll();
    Optional<EmployeeDto> findById(String usercode);

}
