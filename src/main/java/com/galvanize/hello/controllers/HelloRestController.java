package com.galvanize.hello.controllers;

import com.galvanize.hello.entities.Person;
import com.galvanize.hello.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class HelloRestController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/hello")
    public Person getPerson(@RequestParam String name,
                            @RequestParam String email,
                            @RequestParam LocalDate birthdate){
        Person person = new Person(name, email, birthdate);

        return person;

    }

    /*** CREATE ***/
    @PostMapping
    public Person postPerson(@RequestBody Person person){
        return personRepository.save(person);
    }

    /*** READ ***/
    @GetMapping
    public List<Person> getAllPeople(){
        return personRepository.getAllPeople();
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id){
        return personRepository.findById(id);
    }

    @GetMapping("/{name}")
    public Person findPersonByName(@PathVariable String name){
        return personRepository.findByName(name);
    }
    /*** UPDATE ***/
    @PatchMapping("/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        person.setId(id);
        return personRepository.update(person);
    }

    /*** DELETE ***/
    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id){
        if (personRepository.delete(id)){
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
