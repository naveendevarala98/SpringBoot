package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import com.jpa.hibernate.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class JpqlTest {

	//query using the entity - jpql

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

	@Test
	public void jpql_name_query_basic() {
		Query query= em.createNamedQuery("query_get_all_courses");
		List resutList = query.getResultList();
		logger.info("named query Select c From Course c -> {}",resutList);
	}

	@Test
	public  void jpql_where_course_without_student(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c where c.students is empty", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("course w/o student -> {}",resutList);
	}

	//fetch course where course associate with more than 2 student
	@Test
	public  void jpql_where_course_with_more2_student(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c where size(c.students) >= 2", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("course w/o student -> {}",resutList);
	}

	//fetch course list associated with student in ascending order
	@Test
	public  void jpql_where_course_with_student_order(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c order by size(c.students)", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("course w/o student order by -> {}",resutList);
	}

	@Test
	public  void jpql_where_course_with_student_order_desc(){
		TypedQuery<Course> query = em.createQuery("Select c From Course c order by size(c.students) desc", Course.class);
		List<Course> resutList = query.getResultList();
		logger.info("course w/o student order by desc-> {}",resutList);
	}

	@Test
	public  void jpql_student_passport_in_a_certain_patter(){
		TypedQuery<Student> query = em.createQuery("Select s From Student s where s.passport.number like '%12%'", Student.class);
		List<Student> resutList = query.getResultList();
		logger.info("fetch student_passport {}",resutList);
	}

	//join fetches only course details which is mapped with students
	@Test
	public void jpql_join(){
		Query query = em.createQuery("select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results size ->{}",resultList.size());
		for(Object[] result: resultList){
			logger.info("COurse{} student{}",result[0], result[1]);
		}
	}

	//fetch all details from course and matches with student
	@Test
	public void jpql_left_join(){
		Query query = em.createQuery("select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results size ->{}",resultList.size());
		for(Object[] result: resultList){
			logger.info("COurse{} student{}",result[0], result[1]);
		}
	}

}
