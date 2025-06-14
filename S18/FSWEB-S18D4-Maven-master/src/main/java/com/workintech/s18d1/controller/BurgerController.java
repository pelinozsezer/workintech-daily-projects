package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDaoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workintech")
public class BurgerController {

    private BurgerDaoImpl burgerDaoImpl;

    public  BurgerController(BurgerDaoImpl burgerDaoImpl) {
        this.burgerDaoImpl=burgerDaoImpl;
    }


}
