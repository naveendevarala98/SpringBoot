package com.practice.database.database.jpa;

import com.practice.database.database.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Person findById(int id){
        return entityManager.find(Person.class,id);
    }

    //if id is already exist update or inser new one
    public Person update(Person person){
        return entityManager.merge(person);
    }

    //delete
    public void delete(int id){
        Person person = findById(id);
         entityManager.remove(person);
    }

    //jpql - query
    public List<Person> finAll(){
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons",Person.class);
        return namedQuery.getResultList();
    }
}
