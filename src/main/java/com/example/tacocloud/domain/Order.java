package com.example.tacocloud.domain;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "taco_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Date placedAt;

    @ManyToMany(targetEntity = Taco.class)
    List<Taco> tacos = new ArrayList<>();

    @NotBlank(message = "Необходимо заполнить имя")
    private String name;

    @NotBlank(message = "Необходимо заполнить улицу")
    private String street;

    @NotBlank(message = "Необходимо заполнить город")
    private String city;

    @NotBlank(message = "Необходимо заполнить область")
    private String state;

    @NotBlank(message = "Необходимо заполнить индекс")
    private String zip;

    @CreditCardNumber(message = "Некорректный номер карты")
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message = "Обязательный формат даты MM/YY")
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Некорректный CVV")
    private String ccCVV;

//    @ToString.Exclude
//    @ManyToMany(targetEntity = Taco.class)
//    @JoinTable(name = "taco_order_taco")
//    private List<Taco> tacos = new ArrayList<>();


    public void addDesign(Taco design) {
        tacos.add(design);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }
}
