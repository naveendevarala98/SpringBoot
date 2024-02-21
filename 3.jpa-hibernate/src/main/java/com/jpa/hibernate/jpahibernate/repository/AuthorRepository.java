package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.libentity.Author;
import com.jpa.hibernate.jpahibernate.libentity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class AuthorRepository {

    @Autowired
    EntityManager em;

    public void insertAuthor(int id, String name){
        Query query = em.createNativeQuery("Insert into Author(id, author_name) values (:id,:name)");
        query.setParameter("id",id);
        query.setParameter("name",name);
        query.executeUpdate();
    }

    public void fetchAuthor(){
        Query query = em.createNativeQuery("Select * from Author", Author.class);
        List<Author> l = query.getResultList();

        System.out.println("author name "+l.get(0).getAuthorName());
    }
}
