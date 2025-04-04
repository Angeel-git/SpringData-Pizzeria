package com.platzi.pizza.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_item")
/*Para indicar que la clave primaria es compuesta, hay que crear una nueva clase en la que se guarden los dos
* atributos que seran las PK de esta clase*/
@IdClass(OrderItemId.class)
//PODEMOS CON LAS SIGUIENTES ANOTACIONES GENERAR - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter
@Setter
@NoArgsConstructor
public class OrderItemEntity {
    @Id
    @Column(name = "id_item", nullable = false)
    private Integer idItem;

    @Id
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_pizza", nullable = false)
    private Integer idPizza;

    @Column(columnDefinition = ("Decimal(2,1)"))
    private Double quantity;

    @Column(columnDefinition = ("Decimal(5,2)"))
    private Double price;

    //RELACIONES
    @OneToOne       //Un orderItem solo podra tener una pizza
    /*En el joinColumn le indicamos que la columna de esta clase(id_pizza) es
    la que se va a relacionar con la columna de la otra clase (id_pizza)*/
    @JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
    private PizzaEntity pizza;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    @JsonIgnore
    private OrderEntity order;
}