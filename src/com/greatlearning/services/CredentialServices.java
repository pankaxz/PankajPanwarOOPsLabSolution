package com.greatlearning.services;
import com.greatlearning.models.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CredentialServices {

    public boolean CheckEntry(String entry)
    {
        for(int i = 0; i < entry.length(); i++)
            if((entry.charAt(i) < 65 || entry.charAt(i) > 90) &&  ( entry.charAt(i)  < 97 || entry.charAt(i) > 123))
                return false;

        return true;
    }

    public void GenerateCredentials(Employee employee, String department)
    {
        System.out.println("Your company email id : "+GenerateEmail( employee, department ));
        System.out.println("password : " + GeneratePassword());
    }

    public String GenerateEmail(Employee employee, String department)
    {
        return employee.getEmpFirstName().toLowerCase() + employee.getEmpLastName().toLowerCase() + "." + department + "@mycompany.com";
    }

    public String GeneratePassword() {
        StringBuilder generatedString = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();

        map.put("capital", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        map.put("numbers", "0123456789");
        map.put("specialChar", "~!@#$%^&*()_+{}<>?:[]");
        map.put("small", "abcdefghijklmnopqrstuvxyz");

        for (Map.Entry<String, String> e : map.entrySet()) {
            Random random = new Random();
            int index = (int) (random.nextFloat() * e.getValue().length());
            generatedString.append(e.getValue().charAt(index));
            index = (int) (random.nextFloat() * e.getValue().length());
            generatedString.append(e.getValue().charAt(index));
        }

        return (generatedString.toString());
    }
}
