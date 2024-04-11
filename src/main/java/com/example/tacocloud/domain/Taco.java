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
public class Taco {

    private Long id;
    private Date createdAt;

    @NotNull
    @Size(min = 5, message = "Минимальная длина имени - 5 символов ")
    private String name;
    @Size(min = 1, message = "Должен быть выбран хотя бы один ингредиент")
    private List<String> ingredients;
}


