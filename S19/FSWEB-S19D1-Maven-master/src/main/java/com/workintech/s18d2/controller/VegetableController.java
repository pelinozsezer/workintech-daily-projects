package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vegetables")
@Validated
public class VegetableController {

    private final VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> getAllAsc() {
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Vegetable getById(@PathVariable @Positive  Long id) {
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getAllDesc() {
        return vegetableService.getByPriceDesc();
    }



    @PostMapping
    public Vegetable save(@RequestBody @Valid Vegetable vegetable) {
        return vegetableService.save(vegetable);
    }

    @PutMapping("/{id}")
    public Vegetable update(@PathVariable @Positive Long id, @RequestBody @Valid Vegetable vegetable) {
        return vegetableService.update(id, vegetable);

    }


    @GetMapping("/search")
    public List<Vegetable> getByName(@RequestParam @NotBlank String name) {
        return vegetableService.searchByName(name);
    }


    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable @Positive Long id) {
        return vegetableService.delete(id);
    }




}
