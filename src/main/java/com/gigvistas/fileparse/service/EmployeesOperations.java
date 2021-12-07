package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.dto.EmployeeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public List<EmployeeDto> searchUserCodeOperation(String usercode){
        List<EmployeeDto> employeeDto =new ArrayList<EmployeeDto>();
        logger.debug("UserCode entered is " +usercode);
        for (EmployeeDto user : getUsers) {
            if (usercode.equals(user.getUserCode())) {
                employeeDto.add(user)
;            }
        }
        return employeeDto;
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

    public List<EmployeeDto> createFileConsistRemoteJobs(String location){
        List<EmployeeDto> employeeDtoList1 =new ArrayList<EmployeeDto>();
            logger.info("Preferred location entered is " +location);
            logger.debug("Add the remote job to another file Performance");
            for (EmployeeDto emp : getUsers) {
                if (location.equals(emp.getPreferredLocation())) {
                    employeeDtoList1.add(emp);
                }
            }
        return employeeDtoList1;
        }


    public List<EmployeeDto> findInactiveUser(){
        List<EmployeeDto> employeeDtoList=new ArrayList<EmployeeDto>();
        logger.debug("Searching inactive user Performance");
        for(EmployeeDto emp1 : getUsers){
            if(!emp1.isProfileComplete()){
                System.out.println(emp1);
                employeeDtoList.add(emp1);
            }
        }
        return employeeDtoList;
    }
    
}
