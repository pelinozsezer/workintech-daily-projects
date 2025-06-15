package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    @Override
    @Transactional
    public Burger save(@RequestBody Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) { //0dan küçük olmamalı
        return entityManager.find(Burger.class, id);
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b",Burger.class);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(Double price) { // 0dan küçük olmamalı
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b" +
                "WHERE b.price= :price ORDER BY b.price",Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }



    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b" +
                "WHERE b.bread_type= :breadType ORDER BY b.name ASC",Burger.class);
        query.setParameter("bread_type", breadType);
        return query.getResultList();
    }



    @Override
    @Transactional
    public Burger update(@RequestBody Burger burger) {
        return entityManager.merge(burger); // looks for id
    }

    @Override
    @Transactional
    public Boolean remove(Long id) { // 0dan küçük olabilir
        Burger removed = entityManager.find(Burger.class,id);
        if (removed!=null) { entityManager.remove(removed); return true;}
        return false;
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
        TypedQuery<Burger> query = entityManager.createQuery(
                "SELECT b FROM Burger b WHERE b.contents ILIKE :content ORDER BY b.name",
                Burger.class
        );
        query.setParameter("content", "%" + content + "%");
        return query.getResultList();

    }




}
