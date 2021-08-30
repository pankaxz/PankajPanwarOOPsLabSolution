package com.greatlearning.services;
import com.greatlearning.models.Employee;
import java.util.Random;

public class CredentialServices {
    public String capitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public String smallLetter = "abcdefghijklmnopqrstuvwxyz";
    public String numbers = "1234567890";
    public String special = "!@#$%^&*()_+-=><";

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
        return employee.getEmpFirstName().toLowerCase()+employee.getEmpLastName().toLowerCase()+"."+department + "@mycompany.com";
    }

    public String GeneratePassword()
    {
        Random random = new Random();
        String [] chars = {capitalLetter, smallLetter, numbers, special};
        StringBuilder sbString = new StringBuilder(8);

        for(int i=0; i < 2; i++){
            for(int j = 0; j < 4; j++)
            {
                sbString.append(chars[j].charAt(random.nextInt(chars[j].length())));
            }
        }
        return sbString.toString();
    }
}
