package com.example.tacocloud.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
public class Ingredient {

    @Id
    private final String id;
    private final String name;

    // Для сохранения значения названия
    @Enumerated(EnumType.STRING)
    private final Type type;

   

    private enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }

}