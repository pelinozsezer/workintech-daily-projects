package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooKangarooValidation {
    public static void isIdValid(Integer id) throws ZooException {
        if (id == null || id < 0) {
            throw new ZooException("Id is not valid: " + id, HttpStatus.BAD_REQUEST);
        }

    }

    public static void checkKangarooExistence(Map<Integer, Kangaroo> kangaroos, Integer id, boolean b) {

    }
}
