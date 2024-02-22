package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.libentity.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GenreRepository {

    @Autowired
    private EntityManager entityManager;

    public void insertGenre(int id, String type){
        Query q = entityManager.createNativeQuery("insert into GENRE (id,type) values (:id,:type)");

        q.setParameter("id",id);
        q.setParameter("type",type);
        q.executeUpdate();
    }

    public void fetchGenre(){
        Query q = entityManager.createNativeQuery("select * from genre");

        List<Genre> g =q.getResultList();

        System.out.println(g);
    }
}
