package com.gigvistas.fileparse.controllers;

import com.gigvistas.fileparse.dto.EmployeeDto;
import com.gigvistas.fileparse.entity.EmployeeEntity;
import com.gigvistas.fileparse.service.EmployeeServices;
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
    EmployeeServices employeeServices;

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
    public List<EmployeeDto> getEmployeeWithUserCode(@RequestParam String userCode) throws IOException {
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
    public Iterable<EmployeeEntity> getAllRecords()
    {
        return employeeServices.findAll();
    }

   @GetMapping("/display-employee-records-by-usercode/{usercode}")
    public Optional<EmployeeEntity> getEmployeeById(@PathVariable(value = "usercode") String userCode){
        return employeeServices.findById(userCode);
   }

   @GetMapping("/display-employee-records-by-remote-location/{preferredLocation}")
    public List<EmployeeEntity> getEmployeeByPreferredLocation(@PathVariable(value = "preferredLocation")String preferredLocation){
       return employeeServices.findByPreferredLocation( preferredLocation);
   }

//   @GetMapping("/display-employee-with-max-jobs-completed")
//   public int getEmployeeWithJobsCompleted(){
//        return employeeServices.findMaxByJobsCompleted();
//   }

    @GetMapping("/display-employee-with-sort")
   public List<EmployeeEntity> getEmployeeWithJobsCompleted(){
        return employeeServices.findAllAndSortByName();
   }


}
