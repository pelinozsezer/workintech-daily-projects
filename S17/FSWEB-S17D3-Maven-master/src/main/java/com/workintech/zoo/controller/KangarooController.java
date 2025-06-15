package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
    }

    @GetMapping
    public List<Kangaroo> getAll() {
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable Integer id) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo with id not found", HttpStatus.NOT_FOUND);
        }
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo add(@Valid @RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroo;
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable Integer id, @Valid @RequestBody Kangaroo kangaroo) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo with id not found", HttpStatus.NOT_FOUND);
        }
        kangaroos.put(id, kangaroo);
        return kangaroo;
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable Integer id) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo with id not found", HttpStatus.NOT_FOUND);
        }
        Kangaroo removed = kangaroos.get(id);
        kangaroos.remove(id);
        return removed;
    }
}
