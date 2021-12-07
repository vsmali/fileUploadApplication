package com.gigvistas.fileparse.repository;

import com.gigvistas.fileparse.entity.EmployeeEntity;
import net.bytebuddy.TypeCache;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity,String> {

    Iterable<EmployeeEntity> findAll();
    Optional<EmployeeEntity> findById(String userCode);
    List<EmployeeEntity> findByPreferredLocation(String preferredLocation);
    @Query("FROM EmployeeEntity")
    List<EmployeeEntity> findAllOrderByNameAsc(Sort sort);
}
