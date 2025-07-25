package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    Vegetable save(Vegetable vegetable);

    Vegetable delete(Long id);

    Vegetable findById(Long id);

    Vegetable update(Long id, Vegetable vegetable);


    List<Vegetable> findAll();

    List<Vegetable> getByPriceAsc();

    List<Vegetable> getByPriceDesc();

    List<Vegetable> searchByName(String name);


}
