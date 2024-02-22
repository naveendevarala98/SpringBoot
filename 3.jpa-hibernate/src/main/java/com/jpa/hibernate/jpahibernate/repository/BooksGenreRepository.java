package com.jpa.hibernate.jpahibernate.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BooksGenreRepository {

    @Autowired
    private EntityManager entityManager;
    public void insert(int bId, int gId){
        Query query = entityManager.createNativeQuery("Insert into Book_Genre(books_id, genre_id) values (:bId, :gId)");
        query.setParameter("bId",bId);
        query.setParameter("gId",gId);
        query.executeUpdate();
    }
}
