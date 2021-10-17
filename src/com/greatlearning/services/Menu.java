package com.greatlearning.services;

import com.greatlearning.models.Employee;

import java.util.Scanner;

public class Menu {
    private final CredentialServices credentials = new CredentialServices();
    private final Scanner sc = new Scanner(System.in);
    private String fName;
    private String lName;

    public void InitialiseMenu(){
        InitialiseUser();
    }

    public void InitialiseUser(){
        System.out.println("Welcome to my company");
        System.out.println("Hello employee !");
        System.out.println("Enter first name : ");

        do{
            fName = sc.next();
            if(!credentials.CheckEntry(fName))
            {System.out.println("Wrong entry");}
        }
        while(!credentials.CheckEntry(fName));

        System.out.println("Enter last name : ");

        do{
            lName = sc.next();
            if(!credentials.CheckEntry(lName))
            {System.out.println("Wrong entry");}
        }
        while(!credentials.CheckEntry(lName));

        InitialiseDepartment();
    }

    public void InitialiseDepartment(){
        System.out.println("Please Select the department");
        System.out.println();
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("1. Tech Department");
        System.out.println("2. HR Department");
        System.out.println("3. Legal Department");
        System.out.println("4. Admin Department");
        System.out.println("-------------------------------------------------------------------------");

        Employee employee = new Employee(fName, lName);
        int deptChoice;
        deptChoice = sc.nextInt();
        switch (deptChoice) {
            case 1 -> credentials.GenerateCredentials(employee, "tech");
            case 2 -> credentials.GenerateCredentials(employee, "hr");
            case 3 -> credentials.GenerateCredentials(employee, "legal");
            case 4 -> credentials.GenerateCredentials(employee, "admin");
            default -> System.out.println("Unexpected value: " + deptChoice + ", please enter correct option.");
        }
    }
}
