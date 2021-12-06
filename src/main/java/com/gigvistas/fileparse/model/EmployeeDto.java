package com.gigvistas.fileparse.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employeedata")
public class EmployeeDto implements Comparable  {
    @Id
    private String usercode;
    private String name;
    private int  jobs_completed;
    private String preferred_location;
    private boolean inactive_user;

    public EmployeeDto() {
    }

    public EmployeeDto(String usercode,
                       String name,
                       int jobs_completed,
                       String preffered_location,
                       boolean inactive) {
        this.usercode = usercode;
        this.name = name;
        this.jobs_completed = jobs_completed;
        this.preferred_location = preffered_location;
        this.inactive_user = inactive;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJobs_completed() {
        return jobs_completed;
    }

    public void setJobs_completed(int jobs_completed) {
        this.jobs_completed = jobs_completed;
    }

    public String getPreffered_location() {
        return preferred_location;
    }

    public void setPreffered_location(String preffered_location) {
        this.preferred_location = preffered_location;
    }

    public boolean isInactive() {
        return inactive_user;
    }

    public void setInactive(boolean inactive) {
        this.inactive_user = inactive;
    }

    @Override
    public String toString() {
        return "UserCode = "+usercode +", Name = " + name + ", Job_Completed = " +jobs_completed + ", " +
                "Preferred_Location = " + preferred_location + ", Inactive_User = " + inactive_user+"\n";
    }

    @Override
    public int compareTo(Object o) {
        EmployeeDto comparingTo =(EmployeeDto) o;
        int comp = name.compareTo(comparingTo.name);
        return comp;
    }

    public String addData(){
        return getUsercode()+","+getName()+","+getJobs_completed()+","+getPreffered_location()+","+isInactive();
    }

}
