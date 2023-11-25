package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryJpqlTests {

	@Autowired
	EntityManager em;
	private Logger logger= LoggerFactory.getLogger(this.getClass());
	@Test
	public void jpql_basic() {
		 Query query= em.createQuery("Select c From Course c");
		List resutList = query.getResultList();
		logger.info("Select c From Course c -> {}",resutList);
	}

	@Test
	public  void jpql_typed(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("Select c From Course c -> {}",resutList);
	}

	@Test
	public  void jpql_hwer(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%100 steps'", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("Select c From Course c -> {}",resutList);
	}



}
