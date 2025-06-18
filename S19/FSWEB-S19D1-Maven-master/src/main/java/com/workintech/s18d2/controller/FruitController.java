package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
@Validated
public class FruitController {

    private final FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAllAsc() {
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable  @Positive Long id) {
        return fruitService.findById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getAllDesc() {
        return fruitService.getByPriceDesc();
    }


    @PostMapping
    public Fruit save(@RequestBody @Valid Fruit fruit) {
        return fruitService.save(fruit);
    }

    @PutMapping("/{id}")
    public Fruit update(@PathVariable @Positive Long id, @RequestBody @Valid Fruit fruit) {
        return fruitService.update(id, fruit);

    }


    @GetMapping("/search")
    public List<Fruit> getByName(@RequestParam @NotBlank String name) {
        return fruitService.searchByName(name);
    }



    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable @Positive Long id) {
        return fruitService.delete(id);
    }




}
