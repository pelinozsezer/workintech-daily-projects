package com.workintech.s18d2.repository;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends JpaRepository<Fruit, Long> {

    // letting the database handle sorting - more efficient
    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> sortByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> sortByPriceAsc();

    // jpa built-in derived query methods.
    List<Fruit> findByNameContainingIgnoreCase(String name);

}
