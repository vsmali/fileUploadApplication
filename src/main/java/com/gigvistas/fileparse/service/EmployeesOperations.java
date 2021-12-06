package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.exception.MyCustomException;
import com.gigvistas.fileparse.model.EmployeeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

@Service
public class EmployeesOperations {

    Scanner sc = new Scanner(System.in);
    
    @Autowired
    public List<EmployeeDto> getUsers;

    @Autowired
    EmployeesComparator userComparator;

    public static Logger logger = LogManager.getLogger(EmployeesOperations.class);
    public EmployeesOperations(List<EmployeeDto> user) {
        this.getUsers = user;
    }

    public EmployeeDto searchUserCodeOperation(String userCode){
        logger.debug("UserCode entered is " +userCode);
        for (EmployeeDto user : getUsers) {
            if (userCode.equals(user.getUsercode())) {
                return user;
            }
        }
        return null;
    }

    public List<EmployeeDto> sortByAlphabeticOrder() {
        Collections.sort(getUsers);
        logger.info("After sorting : ");
        logger.debug("Sorting Performance");
        System.out.println(getUsers);
        return getUsers;
    }

    public EmployeeDto searchMaxJobCompletion(){
       EmployeeDto emp1 = Collections.max(getUsers, userComparator);
        logger.debug("Searching the max job Performance");
        System.out.println(emp1);
        return emp1;
    }

    public EmployeeDto createFileConsistRemoteJobs(String location){
            logger.info("Preferred location entered is " +location);
            logger.debug("Add the remote job to another file Performance");
            for (EmployeeDto emp : getUsers) {
                if (location.equals(emp.getPreffered_location())) {
                    return emp;
                }
            }
        return null;
        }



    public EmployeeDto findInactiveUser(){
        logger.debug("Searching inactive user Performance");
        for(EmployeeDto emp1 : getUsers){
            if(!emp1.isInactive()){
                System.out.println(emp1);
                return emp1;
            }
        }
        return null;
    }
    
}
