package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class FruitServiceImpl implements FruitService{

    private final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    @Transactional
    public Fruit save(@RequestBody Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    @Transactional
    public Fruit delete(Long id) {
        Fruit deletedFruit = fruitRepository.findById(id).orElseThrow(()->
                new PlantException("id not found", HttpStatus.NOT_FOUND));
        fruitRepository.delete(deletedFruit);
        return deletedFruit;

    }

    @Override
    public Fruit findById(Long id) {
        Fruit foundFruit = fruitRepository.findById(id).orElseThrow(()->
                new PlantException("id not found", HttpStatus.NOT_FOUND));
        return foundFruit;
    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.sortByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.sortByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Fruit update(Long id, Fruit fruit) {
        Fruit foundFruit = fruitRepository.findById(id).orElseThrow(()->
                new PlantException("fruit not found related to id", HttpStatus.NOT_FOUND));
        foundFruit.setName(fruit.getName());
        foundFruit.setPrice(fruit.getPrice());
        foundFruit.setFruitType(fruit.getFruitType());
        return fruitRepository.save(foundFruit);
    }


}
