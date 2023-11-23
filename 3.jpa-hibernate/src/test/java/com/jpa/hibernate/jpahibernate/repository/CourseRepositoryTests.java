package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CourseRepositoryTests {

	@Autowired
	CourseRepository repository;
	@Test
	public void findById_basic() {
		Course course = repository.findById(1001L);
		assertEquals("demo1",course.getName());
	}

}
