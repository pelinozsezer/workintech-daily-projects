package com.workintech.s17d2.model;

import org.springframework.stereotype.Component;


public class Developer {
    private int id;
    private String name;
    private Double salary;
    private Experience experience;

    public Developer(Integer id,  String name, Double salary, Experience experience) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.experience = experience;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }
}
