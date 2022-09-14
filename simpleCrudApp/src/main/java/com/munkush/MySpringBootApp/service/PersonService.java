package com.munkush.MySpringBootApp.controller.service;

import com.munkush.MySpringBootApp.controller.entity.Person;
import com.munkush.MySpringBootApp.controller.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> getAllPersons() {
        return repository.findAll();
    }

    public Person getPerson(int id) {
        return repository.findById(id).get();
    }

    public void save(Person person) {
        repository.save(person);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}