package com.fishry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Employee {


    private String name;
    private Integer age;
    private Integer salary;
    private String location;



    public Employee(String name, Integer age, Integer salary, String location) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }


    public void getRaise() {
        salary += (int)(0.30*salary);
    }


    static void changeInfo(Employee employeeToChange,String newName) {
        for(Employee e: Company.employees){
            if(e.name.equals(employeeToChange.name)) {
                e.name = newName;
                break;
            }
        }
    }




     void createArrayList(Integer... nums){

        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.stream(nums).filter(e -> {
            return e == 2;
        }).toList());
        

        System.out.println(arrayList);

    }



    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
