package com.example.tacocloud.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(min = 5, message = "Минимальная длина имени - 5 символов ")
    private String name;

    @ToString.Exclude
    @ManyToMany(targetEntity = Ingredient.class)
    @JoinTable(name = "taco_ingredient",
            joinColumns = {@JoinColumn(name = "taco", foreignKey = @ForeignKey(name = "taco_ingredient_ingredient_fkey"))})
    @Size(min = 1, message = "Должен быть выбран хотя бы один ингредиент")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

    private Date createdAt;
}


