package com.fishry;

import java.util.ArrayList;

public class Company {


    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        Employee airas = new Employee("airas", 26, 300000, "Lahore");
        Employee ahmed = new Employee("ahmed", 31, 800000, "Dubai");



        ahmed.createArrayList(1,2,3,4,2,4,5,6,3,2,1,5,2);


        employees.add(airas);
        employees.add(ahmed);



        airas.getRaise();

        Company.printInfo();


        airas.setName("adeel");
        // Employee.changeInfo(airas, "adeel");


        Company.printInfo();

    }




    static void printInfo() {
        for(Employee e: Company.employees){
            System.out.println("Employee{" +
                    "name='" + e.getName() + '\'' +
                    ", age=" + e.getAge() +
                    ", salary=" + e.getSalary() +
                    ", location='" + e.getLocation() + '\'' +
                    '}');
        }
    }



}
