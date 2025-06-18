package com.workintech.s18d2.entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vegetable", schema="fsweb")
public class Vegetable extends Plant{


    @NotNull(message = "isGrownOnTree can not be null")
    public Boolean isGrownOnTree;
}
