package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {

    // leaving sorting to the DB because it is computationally more efficient
    @Query("SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> sortByPriceDesc();


    @Query("SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> sortByPriceAsc();

    // jpa built-in derived query methods.
    List<Vegetable> findByNameContainingIgnoreCase(String name);
}
