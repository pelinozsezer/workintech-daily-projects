package com.workintech.s17d2.model;

import org.springframework.stereotype.Component;

@Component
public class JuniorDeveloper extends Developer{
    public JuniorDeveloper(Double salary, Long id, String name, Experience experience) {
        super(salary, id, name, experience);
    }
}
