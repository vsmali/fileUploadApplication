package com.gigvistas.fileparse.service;

import com.gigvistas.fileparse.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class EmployeesComparator implements Comparator<EmployeeDto> {

    @Override
    public int compare(EmployeeDto o1, EmployeeDto o2) {
        if (o1.getJobsCompleted()<o2.getJobsCompleted()){
            return -1;
        }
        else {
            return 1;
        }
    }
}
