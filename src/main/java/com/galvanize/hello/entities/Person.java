package com.galvanize.hello.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    Long id;
    String name;
    LocalDate birthDate;
    String email;

    public Person() {
    }

    public Person(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Person(Long id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonFormat(pattern = "MM/dd/yyyy")
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    //Updates this person with the values in person
    public void update(Person person) {
        //First check the id
        if(getId() != person.getId()){
            throw new RuntimeException("Cannot update this person");
        }
        if(person.getName() != null && !this.name.equals(person.getName())){
            setName(person.getName());
        }
        if(person.getBirthDate() != null && this.birthDate != person.getBirthDate()){
            setBirthDate(person.getBirthDate());
        }
        if(person.getEmail() != null && !this.email.equals(person.getEmail())){
            setEmail(person.getEmail());
        }
    }
}
