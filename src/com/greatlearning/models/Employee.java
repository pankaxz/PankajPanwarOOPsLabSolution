package com.greatlearning.models;

public class Employee {
    public Employee(String fName, String lName)
    {
        this.empFirstName = fName;
        this.empLastName = lName;
    }

    private String empFirstName;
    private String empLastName;

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }
}
