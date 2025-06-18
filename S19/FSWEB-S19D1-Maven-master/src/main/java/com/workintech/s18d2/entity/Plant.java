package com.workintech.s18d2.entity;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass
public class Plant {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "name can not be null")
    @Size(min = 2, max = 45, message = "name size must be between 2 to 45")
    private String name;


    private Double price;
}
