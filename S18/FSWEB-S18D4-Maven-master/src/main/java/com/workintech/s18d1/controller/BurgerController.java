package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/burgers")
public class BurgerController{

    private BurgerDaoImpl burgerDaoImpl;

    @Autowired
    public  BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl=burgerDaoImpl;
    }

    @GetMapping
    public List<Burger> getBurgers() {
        return burgerDaoImpl.findAll(); // List
    }

    @GetMapping("/{id}")
    public Burger getById(@PathVariable("id") Long id) {
        Burger removed = burgerDaoImpl.findById(id); // return Burger
        return removed; // maybe null!!
    }

    @PostMapping
    public void createBurger(Burger burger) {
        burgerDaoImpl.save(burger); // returns void
    }

    @PutMapping
    public Burger updateBurger(@RequestBody Burger burger) {
        return burgerDaoImpl.update(burger); // Burger
    }

    @DeleteMapping("/{id}")
    public Boolean deleteBurger(@PathVariable("id") Long id) {
        return burgerDaoImpl.remove(id);
    }

    @GetMapping("/findByPrice")
    public List<Burger> getFindByPrice(Double price) {
        return burgerDaoImpl.findByPrice(price); // List
    }

    @GetMapping("/findByBreadType")
    public List<Burger> getFindByBreadType (BreadType breadType) {
        return burgerDaoImpl.findByBreadType(breadType); // List
    }

    @GetMapping("/findByContent")
    public List<Burger> getFindByContent(String content) {
        return burgerDaoImpl.findByContent(content); // List
    }





}
