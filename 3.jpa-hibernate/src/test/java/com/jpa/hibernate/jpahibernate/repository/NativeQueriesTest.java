package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
public class NativeQueriesTest {

    //create using the table - native query

    @Autowired
    EntityManager em;
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Test
    public void jpql_native_basic() {
        Query query= em.createNativeQuery("SELECT * FROM COURSE", Course.class);
        List resutList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resutList);
    }

    @Test
    public void jpql_native_basic_where() {
        Query query= em.createNativeQuery("SELECT * FROM COURSE where id = ?", Course.class);
        query.setParameter(1,1001);//position starts with 1 and id value
        List resutList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resutList);
    }

    //instead of position we can send parameter
    @Test
    public void jpql_nativename_basic_where() {
        Query query= em.createNativeQuery("SELECT * FROM COURSE where id = :id", Course.class);
        query.setParameter("id",1001);//name and id value
        List resutList = query.getResultList();
        logger.info("SELECT * FROM COURSE -> {}",resutList);
    }

    @Test
    @Transactional
    public void jpql_native_basic_update() {
        Query query= em.createNativeQuery("Update COURSE set last_updated_date=CURRENT_DATE()", Course.class);

        int noOfRowsUpdate = query.executeUpdate();
        logger.info("No of rows updated",noOfRowsUpdate);
    }
}
