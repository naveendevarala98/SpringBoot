package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import javafx.scene.control.Pagination;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryDataJpaTests {

	@Autowired
	CourseRepositorySpringDataJpa repository;

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Test
	public void find_isPresent(){
		Optional<Course> course = repository.findById(1001L);
		logger.info("is present ->{}",course.isPresent());
	}

	@Test
	public void find(){
		Optional<Course> course = repository.findById(1001L);
		logger.info("Course details -> {}",course);
	}

	@Test
	public void find_all(){
		List<Course> course = repository.findAll();
		logger.info("Course details -> {}",course);
	}

	@Test
	public void find_by_name(){
		Course course = repository.findByName("demo1");
		logger.info("Course by name -> {}",course);
	}

	@Test
	public void sort(){
		List<Course> course = repository.findAll(Sort.by(Sort.Direction.DESC,"name"));
		logger.info("Course by name -> {}",course);
	}

	@Test
	public void pagination(){
		PageRequest firstPage=  PageRequest.of(0,3);
		Page<Course> course = repository.findAll(firstPage);
		logger.info("Course by page -> {}",course.getContent());

		Pageable secondPage = firstPage.next();
		Page<Course> course1 = repository.findAll(secondPage);
		logger.info("Course  second page -> {}",course1.getContent());

	}

}
