package com.workintech.zoo.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Kangaroo {
    @Min(1)
    private Integer id;

    @NotBlank
    private String name;

    private Double height;

    private Double weight;

    private String gender;

    private Boolean isAggressive;
}
