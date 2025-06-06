package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController

public class AnimalController {

    private final Map<Integer, Animal> animals = new HashMap<>();

    public AnimalController() {
        // Sample data
        animals.put(1, new Animal(1, "Leo"));
        animals.put(2, new Animal(2, "Milo"));
        animals.put(3, new Animal(3, "Armin"));
    }


    @GetMapping("/workintech/animal")
    public List<Animal> getAllAnimals() {
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/workintech/animal/{id}")
    public ResponseEntity<Animal> returnAnimalById(@PathVariable int id) {
        Animal animal = animals.get(id);
        if (animal != null) {
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/workintech/animal")
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal) {
        int id = animal.getId();
        String name = animal.getName();

        if (animals.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // ID already exists
        }

        Animal newAnimal = new Animal(id, name); // assuming species is optional or empty
        animals.put(id, newAnimal);

        return ResponseEntity.status(HttpStatus.CREATED).body(newAnimal);
    }

    @PutMapping("/workintech/animal/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {


        if (!animals.containsKey(id)) {return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}

            updatedAnimal.setId(id);
            animals.put(id, updatedAnimal);
            return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/workintech/animal/{id}")
    public ResponseEntity<Animal> deleteAnimal(@PathVariable int id) {
        if (!animals.containsKey(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Animal removed = animals.remove(id);
        return ResponseEntity.ok(removed);
    }







}
