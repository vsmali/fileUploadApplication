package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.model.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class EmployeesComparator implements Comparator<EmployeeDto> {

    @Override
    public int compare(EmployeeDto o1, EmployeeDto o2) {
        if (o1.getJobs_completed()<o2.getJobs_completed()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
