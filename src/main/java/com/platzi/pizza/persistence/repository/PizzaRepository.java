package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.PizzaEntity;
//La clase ListCrudRepository es una interfaz que permite realizar operaciones CRUD (Create, Read, Update, Delete) en una base de datos.
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

//Tenemos que indicar el tipo de entidad y el tipo de id(el tipo de Pk que tiene la tabla)
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

    /*Metodo para buscar las pizzas que no estan disponibles
    * En JPA el nombre de los metodos de los Reposirtory, ya le indica a la base de datos la columna y el valor
    * que queremos comparar*/
    List<PizzaEntity> findByAvailableFalse();
}