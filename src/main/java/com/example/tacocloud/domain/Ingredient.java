package com.example.tacocloud.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Entity
@Table(name = "Ingredient")
public class Ingredient {

    @Id
    private final String id;
    private final String name;

    // Для сохранения значения названия
    @Enumerated(EnumType.STRING)
    private final Type type;


    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}

