package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.libentity.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookReviewRespository {

    @Autowired
    private EntityManager em;


    public void insertReview(int id, String review, int bookId){
        Query q = em.createNativeQuery("Insert into Book_Review(ID, review, books_id) values(:id,:review,:bookId)");
        q.setParameter("id",id);
        q.setParameter("review",review);
        q.setParameter("bookId",bookId);
        q.executeUpdate();
    }

    public void fetchBooksReview(){
        Query query = em.createNativeQuery("Select * from BOOK_REVIEW");
        List l = query.getResultList();

        System.out.println("bokk name "+l.get(0));
    }
}
