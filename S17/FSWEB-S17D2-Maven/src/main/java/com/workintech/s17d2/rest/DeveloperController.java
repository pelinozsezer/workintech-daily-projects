package com.workintech.s17d2.rest;

import com.workintech.s17d2.model.Developer;
import com.workintech.s17d2.tax.Taxable;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DeveloperController {

    private Map<Integer, Developer> developers;

    private final Taxable taxable;

    // Constructor Injection of Taxable implementation (DeveloperTax)
    public DeveloperController(Taxable developerTax) {
        this.taxable = developerTax;
    }

    @PostConstruct
    public void init() {
        developers = new HashMap<>();
    }

    test
}
