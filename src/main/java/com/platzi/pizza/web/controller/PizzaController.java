package com.platzi.pizza.web.controller;

import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    //Llamada al metodo de la clase PizzaService para saber todas las pizzas
    @GetMapping //No se le indica la ruta porque queremos que se ejecute cuando entramos a la ruta del controller
    public ResponseEntity<List<PizzaEntity>>getAll(){
        return ResponseEntity.ok(this.pizzaService.getAll());
    }

    //Llamada al metodo de la clase PizzaService para saber la pizza por su id
    @GetMapping("/pizza/{id}")
    public ResponseEntity<PizzaEntity> getById(@PathVariable int id){
        return ResponseEntity.ok(this.pizzaService.getById(id));
    }

    //Llamada al metodo de la clase PizzaService para saber las pizzas que no estan disponibles
    @GetMapping("/notAvailable")
    public ResponseEntity<List<PizzaEntity>> getNotAvailable(){
        return ResponseEntity.ok(this.pizzaService.getNotAvailable());
    }

    //LLamada al metodo de la clase PizzaService para CREAR una nueva pizza
    @PostMapping //manejar solicitudes HTTP POST(para obtener elementos del Path)
    public ResponseEntity<PizzaEntity> addPizza(@RequestBody PizzaEntity pizza){
        //Para controlar que el id que se introduce no existe o la pizza no existe
        if(pizza.getIdPizza()==null || !this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.newPizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    //LLamada al metodo de la clase PizzaService para ACTUALIZAR una nueva pizza
    @PutMapping //manejar solicitudes HTTP PUT(para obtener elementos del Path)
    public ResponseEntity<PizzaEntity> updatePizza(@RequestBody PizzaEntity pizza){
        //Para controlar que el id que se introduce SI existe Y QUE la pizza tambien existe
        if(pizza.getIdPizza()!=null && this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.newPizza(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    //LLamada al metodo de la clase PizzaService para BORRAR una pizza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        this.pizzaService.deletePizza(id);
        return ResponseEntity.ok().build();
    }
}