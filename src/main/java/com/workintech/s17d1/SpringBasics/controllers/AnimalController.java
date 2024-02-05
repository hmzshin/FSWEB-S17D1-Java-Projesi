package com.workintech.s17d1.SpringBasics.controllers;

import com.workintech.s17d1.SpringBasics.animal.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class AnimalController {

    Map<Integer, Animal> animals = new HashMap<>();

    @RequestMapping("/")
    public String hello() {
        return "Welcome to our new animal api!";
    }

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimals(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("/animals")
    public Animal setAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);

        return animals.get(animal.getId());
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@RequestBody Animal animal, @PathVariable int id) {
        animals.put(id, animal);


        return animals.get(id);
    }

    @DeleteMapping("/animals/{id}")
    public Animal deleteAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.remove(id);


        return animal;
    }
}
