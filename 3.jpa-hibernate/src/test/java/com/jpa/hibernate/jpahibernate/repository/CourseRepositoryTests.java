package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CourseRepositoryTests {

	@Autowired
	CourseRepository repository;
	@Test
	public void findById_basic() {
		Course course = repository.findById(1001L);
		assertEquals("demo1",course.getName());
	}

	@Test
	@DirtiesContext //inorder to restore the data after deleting
	public void deleteById_basic() {
		repository.deleteById(1001L);
		assertNull(repository.findById(1001L));
	}

	@Test
	@DirtiesContext //inorder to restore the data after deleting
	public void save_basic() {
		Course course = repository.findById(1001L);
		assertEquals("demo1",course.getName());

		course.setName("demo1Updated");
		repository.save(course);

		Course course1 = repository.findById(1001L);
		assertEquals("demo1Updated",course1.getName());
	}

}
