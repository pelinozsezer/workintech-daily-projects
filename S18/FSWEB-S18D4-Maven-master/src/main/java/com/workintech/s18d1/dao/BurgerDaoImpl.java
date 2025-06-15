package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public Burger save(@RequestBody Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
        if (id == null || id <= 0) {
            throw new BurgerException("id should not be smaller than 0",
                    HttpStatus.BAD_REQUEST);
        }

        Burger burger = entityManager.find(Burger.class, id);
        if (burger == null) {
            throw new BurgerException(
                    "Burger with id " + id + " not found",
                    HttpStatus.NOT_FOUND
            );
        }

        return burger;
    }


    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return query.getResultList();
    }

   /* @Override
    public List<Burger> findByPrice(Double price) { // 0dan küçük olmamalı
        if (price <= 0) {throw new BurgerException("price should not be smaller than 0",
                HttpStatus.BAD_REQUEST);}
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b" +
                "WHERE b.price= :price ORDER BY price",Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }

    */

    @Override
    public List<Burger> findByPrice(Double price) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.price = :price",
                Burger.class);
        query.setParameter("price", price);
        return query.getResultList();
    }



    @Override
    public List<Burger> findByBreadType(@RequestBody BreadType breadType) {

        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b" +
                "WHERE b.bread_type= :breadType ORDER BY b.name ASC",Burger.class);
        query.setParameter("bread_type", breadType);
        return query.getResultList();
    }



    @Override
    @Transactional
    public Burger update(@RequestBody Burger burger) {
        Burger found = entityManager.find(Burger.class,burger.getId());
        if (found==null) {throw new BurgerException("id of your input could not be found", HttpStatus.BAD_REQUEST);}
        return entityManager.merge(burger); // looks for id
    }

    @Override
    @Transactional
    public Burger remove(Long id) { // 0dan küçük olmamalı
        if (id <= 0 || id == null) {throw new BurgerException("id should not be smaller than 0", HttpStatus.BAD_REQUEST);}
        return entityManager.find(Burger.class,id);
    }




/*
    @Override
    public List<Burger> findByContent(String content) {

        String sql = """
        SELECT b
        FROM Burger b
        WHERE EXISTS (
            SELECT 1
            FROM unnest(contents) AS elem
            WHERE elem ILIKE :pattern
        )
        """;

        TypedQuery<Burger> query = entityManager.createQuery(sql,Burger.class);
        query.setParameter("pattern", "%" + content + "%");
        return query.getResultList();
    }

 */
    @Override
    public List<Burger> findByContent(String content) { // boş olabilir
        if (content == null) {throw new BurgerException("content should not be null", HttpStatus.BAD_REQUEST);}
        TypedQuery<Burger> query = entityManager.createQuery(
                "SELECT b FROM Burger b WHERE b.contents ILIKE :content ORDER BY b.name",
                Burger.class
        );
        query.setParameter("content", "%" + content + "%");
        return query.getResultList();

    }




}
