package com.gigvistas.fileparse.dto;

public class EmployeeDto implements Comparable  {
    private String userCode;
    private String name;
    private int jobsCompleted;
    private String preferredLocation;
    private boolean isProfileComplete;

    public EmployeeDto() {
    }

    public EmployeeDto(String usercode,
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

    @Override
    public String toString() {
        return "UserCode = "+ userCode +", Name = " + name + ", Job_Completed = " + jobsCompleted + ", " +
                "Preferred_Location = " + preferredLocation + ", Inactive_User = " + isProfileComplete +"\n";
    }

    @Override
    public int compareTo(Object o) {
        EmployeeDto comparingTo =(EmployeeDto) o;
        int comp = name.compareTo(comparingTo.name);
        return comp;
    }

    public String addData(){
        return getUserCode()+","+getName()+","+ getJobsCompleted()+","+getPreferredLocation()+","+isProfileComplete;
    }

}
