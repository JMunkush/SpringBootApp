package com.munkush.MySpringBootApp.controller.repository;

import com.munkush.MySpringBootApp.controller.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {

}
