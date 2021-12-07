package com.gigvistas.fileparse.controllers;

import com.gigvistas.fileparse.model.EmployeeDto;
import com.gigvistas.fileparse.repository.EmployeeRepository;
import com.gigvistas.fileparse.service.EmployeesOperations;
import com.gigvistas.fileparse.service.ReadFileData;
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

@RestController
public class FileUploadController {

    @Autowired
    ReadFileData readFileData;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeesOperations employeesOperations;

    public static Logger logger = LogManager.getLogger(FileUploadController.class);

    @GetMapping("/")
    public String index(){
        return "upload";
    }


    @PostMapping("/file-upload")
    public List<EmployeeDto> uploadNewFile(@RequestParam("file") MultipartFile file) throws IOException {
        List<EmployeeDto> user = readFileData.dataReadFile(file);
        return user;
    }

    @GetMapping("/search-by-user-code")
    public EmployeeDto getEmployeeWithUserCode(@RequestParam String userCode) throws IOException {
        logger.info("Enter the user code to search : ");
       return employeesOperations.searchUserCodeOperation(userCode);
    }


    @GetMapping("/sort-by-alphabetic-order")
    public List<EmployeeDto> getEmployeeWithAlphabeticOrder(){
        return  employeesOperations.sortByAlphabeticOrder();
    }

    @GetMapping("/max-jobs-completed")
    public EmployeeDto getEmployeeWithMaxJobs(){
        return  employeesOperations.searchMaxJobCompletion();
    }

    @GetMapping("/preferred-location")
    public EmployeeDto getEmployeeWithPreferredLocation(@RequestParam String location){
       return employeesOperations.createFileConsistRemoteJobs(location);
    }

    @GetMapping("/find-inactive-user")
    public EmployeeDto getEmployeeWithInactive(){
       return  employeesOperations.findInactiveUser();
    }

    @GetMapping("/display-user")
    public List<EmployeeDto> getEmployee(){
       return readFileData.display();
    }

    @GetMapping("/employee-records")
    public List<EmployeeDto> getAllRecords()
    {
        return employeeRepository.findAll();
    }

    

}
