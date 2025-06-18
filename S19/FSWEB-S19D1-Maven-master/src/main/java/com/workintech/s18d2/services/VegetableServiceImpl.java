package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
public class VegetableServiceImpl implements VegetableService{

    private final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    @Transactional
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    @Transactional
    public Vegetable delete(Long id) {
        Vegetable deletedVegetable = vegetableRepository.findById(id).orElseThrow(()->
                new PlantException("id not found", HttpStatus.NOT_FOUND));
        vegetableRepository.delete(deletedVegetable);
        return deletedVegetable;
    }

    @Override
    public Vegetable findById(Long id) {
        Vegetable foundVegetable = vegetableRepository.findById(id).orElseThrow(()->
                new PlantException("id not found", HttpStatus.NOT_FOUND));
        return foundVegetable;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.sortByPriceDesc();
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.sortByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Vegetable update(Long id, Vegetable vegetable) {
        Vegetable foundVegetable = vegetableRepository.findById(id).orElseThrow(()->
                new PlantException("vegetable not found related to id", HttpStatus.NOT_FOUND));
        foundVegetable.setName(vegetable.getName());
        foundVegetable.setPrice(vegetable.getPrice());
        foundVegetable.setIsGrownOnTree(vegetable.getIsGrownOnTree());
        return vegetableRepository.save(foundVegetable);
    }
}
