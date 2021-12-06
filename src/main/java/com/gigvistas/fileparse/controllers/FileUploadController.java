package com.gigvistas.fileparse.controllers;

import com.gigvistas.fileparse.service.EmployeesOperations;
import com.gigvistas.fileparse.service.ReadFileData;
import com.gigvistas.fileparse.model.EmployeeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@RestController
public class FileUploadController {

    @Autowired
    ReadFileData readFileData;
    EmployeesOperations employeesOperations;

    public static Logger logger = LogManager.getLogger(FileUploadController.class);
    Scanner sc = new Scanner(System.in);


    @GetMapping("/")
    public String index(){
        return "upload";
    }


    @PostMapping("/file-upload")
    public List<EmployeeDto> uploadNewFile(@RequestParam("file") MultipartFile file) throws IOException {
        List<EmployeeDto> user = readFileData.dataReadFile(file);
        return user;
    }

    @PostMapping("/search-by-user-code")
    public void getEmployeeWithUserCode() throws IOException {
        logger.info("Enter the user code to search : ");
        String userCode = sc.next();
        employeesOperations.searchUserCodeOperation(userCode);
    }


    @PostMapping("/sort-by-alphabetic-order")
    public void getEmployeeWithAlphabeticOrder(){
        employeesOperations.sortByAlphabeticOrder();
    }

    @PostMapping("/max-jobs-completed")
    public void getEmployeeWithMaxJobs(){
        employeesOperations.searchMaxJobCompletion();
    }

    @PostMapping("/preferred-location")
    public void getEmployeeWithPreferredLocation(){
        logger.info("Enter Preferred Location: ");
        String location = sc.next();
        employeesOperations.createFileConsistRemoteJobs(location);
    }

    @PostMapping("/find-inactive-user")
    public void getEmployeeWithInactive(){
        employeesOperations.findInactiveUser();
    }


}
