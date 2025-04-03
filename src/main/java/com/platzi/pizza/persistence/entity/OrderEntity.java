package com.platzi.pizza.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pizza_order")
//PODEMOS CON LAS SIGUIENTES ANOTACIONES GENERAR - LOS GETTER, SETTERS Y EL CONSTRUCTOR VACIO
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String idCustomer;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    //El columnDefinition es para indicar que va a ser un Double de 6 numeros de los cuales 2 van a ser decimales
    @Column(nullable = false, columnDefinition = "Decimal(6,2)")
    private Double total;

    //El columnDefinition es para indicar que va a ser una variable de tipo Char(1)
    @Column(nullable = false, columnDefinition = "Char(1)")
    private String method;

    @Column(name = "additional_notes ", length = 200)
    private String additionalNotes;


    //Relaciones
    @OneToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order") //Hacemos referencia a la relacion ya creada en OrderItemEntity
    private List<OrderItemEntity> items;
}
