package com.workintech.s17d2.model;

import org.springframework.stereotype.Component;

@Component
public class MidDeveloper extends Developer{
    public MidDeveloper(Double salary, Long id, String name, Experience experience) {
        super(salary, id, name, experience);
    }
}
