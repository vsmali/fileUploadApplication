package com.gigvistas.fileparse.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_data")
public class EmployeeEntity{
    @Id
    private String userCode;
    private String name;
    private int jobsCompleted;
    private String preferredLocation;
    private boolean isProfileComplete;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String usercode,
                       String name,
                       int jobs_completed,
                       String preffered_location,
                       boolean inactive) {
        this.userCode = usercode;
        this.name = name;
        this.jobsCompleted = jobs_completed;
        this.preferredLocation = preffered_location;
        this.isProfileComplete = inactive;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobsCompleted() {
        return jobsCompleted;
    }

    public void setJobsCompleted(int jobsCompleted) {
        this.jobsCompleted = jobsCompleted;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public boolean isProfileComplete() {
        return isProfileComplete;
    }

    public void setProfileComplete(boolean profileComplete) {
        isProfileComplete = profileComplete;
    }
}
