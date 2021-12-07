package com.gigvistas.fileparse.controllers;

import com.gigvistas.fileparse.model.EmployeeDto;
//import com.gigvistas.fileparse.repository.EmployeeRepository;
import com.gigvistas.fileparse.repository.EmployeeRepository;
import com.gigvistas.fileparse.service.EmployeesOperations;
import com.gigvistas.fileparse.service.ReadFileData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    public List<EmployeeDto> getEmployeeWithUserCode(@RequestParam String usercode) throws IOException {
        logger.info("Enter the user code to search : ");
       return employeesOperations.searchUserCodeOperation(usercode);
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
    public List<EmployeeDto> getEmployeeWithPreferredLocation(@RequestParam String location){
       return employeesOperations.createFileConsistRemoteJobs(location);
    }

    @GetMapping("/find-inactive-user")
    public List<EmployeeDto> getEmployeeWithInactive(){
       return  employeesOperations.findInactiveUser();
    }

    @GetMapping("/display-user")
    public List<EmployeeDto> getEmployee(){
       return readFileData.display();
    }

    @GetMapping("/display-employee-records")
    public List<EmployeeDto> getAllRecords()
    {
        return employeeRepository.findAll();
    }

   @GetMapping("/display-employee-records/{usercode}")
    public Optional<EmployeeDto> getEmployeeById(@PathVariable(value = "usercode") String usercode){
        return employeeRepository.findById(usercode);
   }

}
