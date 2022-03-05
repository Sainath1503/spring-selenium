package com.sai.spring.springselenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private Salary1 salary1;
    @Autowired
    private Address address;

    //Setting objects via Spring
/*    @Autowired
    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Autowired
    public void setAddress(Address address) {
        this.address = address;
    }*/

    /*this.salary = salary;
    this.address = address;*/

    public void printDetails()
    {
        System.out.println("Address : "+this.address.getStreet());
        System.out.println("Salary : "+this.salary1.getAmount());

    }

}
