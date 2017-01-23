package com.experian.services;

import com.experian.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by lee.flatt on 1/13/2017.
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findById(int id);

    List<Person> findByName(String name);
}
