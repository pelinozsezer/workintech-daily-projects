package com.workintech.s17d2.model;

import org.springframework.stereotype.Component;

@Component
public class Developer {
    private Long id;
    private String name;
    private Double salary;
    private Experience experience;

    public Developer(Double salary, Long id, String name, Experience experience) {
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.experience = experience;
    }
}
