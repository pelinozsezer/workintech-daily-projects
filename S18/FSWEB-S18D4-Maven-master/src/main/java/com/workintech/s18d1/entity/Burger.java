package com.workintech.s18d1.entity;

import java.util.List;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Boolean isVegan;

    @Enumerated(EnumType.STRING)
    private BreadType breadType;

    private String contents;

    /*
    @JdbcTypeCode(SqlTypes.ARRAY)
    @Column(name = "contents",
            columnDefinition = "text[]")
    private String[] contents; // contents TEXT[]
*/
}
