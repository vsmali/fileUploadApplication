package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.exception.MyCustomException;
import com.gigvistas.fileparse.model.EmployeeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    String filename;
    List<EmployeeDto> users = new ArrayList<>();
    public static Logger logger = LogManager.getLogger(EmployeesOperations.class);
    public EmployeesOperations(List<EmployeeDto> user) {
        this.users = user;
    }

    public void searchUserCodeOperation(String userCode){
        boolean found = false;
        logger.debug("UserCode entered is " +userCode);
        for (EmployeeDto user : users) {
            if (userCode.equals(user.getUsercode())) {
                System.out.println(user.toString());
                found = true;
            }
        }
        if(!found){
            logger.info("User not found");
        }
    }



    public void sortByAlphabeticOrder() {
        Collections.sort(users);
        logger.info("After sorting : ");
        logger.debug("Sorting Performance");
        System.out.println(users);
    }

    public void searchMaxJobCompletion(){
        EmployeesComparator userComparator = new EmployeesComparator();
        logger.debug("Searching the max job Performance");
        System.out.println(Collections.max(users, userComparator));
    }

    public void createFileConsistRemoteJobs(String location){
            logger.info("Preferred location entered is " +location);
            String filename3 = sc.next();
            logger.info("Name of the file entered is " +filename3);
            logger.debug("Add the remote job to another file Performance");
        try{
            FileWriter writer = new FileWriter(filename3,true);
            for (EmployeeDto u2 : users) {
                if (location.equals(u2.getPreffered_location())) {
                    System.out.println(u2.toString());
                    writer.append(u2.addData()+"\n");
                }
            }
            writer.close();
            throw new MyCustomException("Unable to write into the file");
        }
        catch (MyCustomException | IOException e){
            logger.error("Error : "+e.getMessage());
        }
    }

    public void findInactiveUser(){
        logger.debug("Searching inactive user Performance");
        for(EmployeeDto emp1 : users){
            if(emp1.isInactive() == false){
                System.out.println(emp1.toString());
            }
        }
    }

}
