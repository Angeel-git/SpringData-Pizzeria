package com.platzi.pizza.persistence.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pizza")

//PODEMOS CON LAS SIGUIENTES ANOTACIONES GENERAR - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter  @Setter  @NoArgsConstructor
public class PizzaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false) //Para indicar que el id no puede ser nulo
    private Integer idPizza;

    //Indicar que no puede ser nulo, como mucho va a ocupar 30 carteres y no puede repetirse en la bd
    @Column(nullable = false, length = 30, unique = true)
    private String name;

    //Indicar que no puede ser nulo, y que no puede tener mas de 150 carcteres
    @Column(nullable = false, length = 150)
    private String description;

    //El columnDefinition es para indicar que va a ser un Double de 5 numeros de los cuales 2 van a ser decimales
    @Column(nullable = false, columnDefinition = "Decimal(5,2)")
    private Double price;

    private Boolean vegetarian;

    private Boolean vegan;

    @Column(nullable = false) //Indicamos que no puede ser falso
    private Boolean avaliable;
}
