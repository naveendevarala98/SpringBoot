package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.libentity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class BooksRepository {

    @Autowired
    EntityManager em;

    public void insertBooks(Long id, String name, int authorId){
        Query query = em.createNativeQuery("insert into Books (ID,BOOKS_NAME,CREATED_DATE_TIME,UPDATED_DATE_TIME,Author_id) " +
                "values (:id,:name,CURRENT_DATE(),CURRENT_DATE(),:authorId)", Books.class);
        query.setParameter("name",name);
        query.setParameter("id",id);
        query.setParameter("authorId",authorId);
       int n = query.executeUpdate();
       System.out.println("afect rows"+n);

    }

    public void updateBooks(Long id, String name){
        Query query = em.createNativeQuery("update Books set BOOKS_NAME=:name,UPDATED_DATE_TIME=CURRENT_DATE()  where ID=:id", Books.class);
        query.setParameter("name",name);
        query.setParameter("id",id);
        int n = query.executeUpdate();
        System.out.println("afect rows"+n);

    }

    public void fetchBooks(){
        Query query = em.createNativeQuery("Select * from BOOKS", Books.class);
        List<Books> l = query.getResultList();

        System.out.println("bokk name "+l.get(0).getBookName());
        System.out.println("bokk name "+l.get(0).getAuthor().getAuthorName());
    }
}
