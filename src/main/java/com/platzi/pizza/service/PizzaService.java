package com.platzi.pizza.service;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    private final PizzaRepository pizzaRepository;


    @Autowired
    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }


    //Consulta para saber todas las pizzas
    public List<PizzaEntity> getAll(){
        return this.pizzaRepository.findAll();
    }

    //Consulta para saber una pizza por su id
    public PizzaEntity getById(int id){
            return this.pizzaRepository.findById(id).orElse(null);
    }

    //Consulta para saber las pizzas que no estan disponibles
    public List<PizzaEntity> getNotAvailable(){
        return this.pizzaRepository.findByAvailableFalse(); /*No es necesario el ".orElse" ya que el metodo de la clase
                                                     PizzaRepository ya devuelve una lista vacia si no encuentra nada*/
    }

    //Consulta para crear una nueva pizza
    public PizzaEntity newPizza(PizzaEntity pizza){
        return this.pizzaRepository.save(pizza);
    }

    //Consulta para borrar una pizza
    public void deletePizza(int id){
        this.pizzaRepository.deleteById(id);
    }

    //Consulta para saber si una pizza existe por su id(Devuelve un boolean)
    public boolean exists(int id){
        return this.pizzaRepository.existsById(id);
    }
}
