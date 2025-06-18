package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface FruitService {

    Fruit save(Fruit fruit);

    Fruit delete(Long id);

    Fruit findById(Long id);

    Fruit update(Long id, Fruit fruit);


    List<Fruit> getAll();

    List<Fruit> getByPriceAsc();

    List<Fruit> getByPriceDesc();

    List<Fruit> searchByName(String name);
}
