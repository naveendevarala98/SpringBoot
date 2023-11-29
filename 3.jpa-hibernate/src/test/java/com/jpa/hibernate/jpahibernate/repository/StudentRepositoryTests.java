package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import com.jpa.hibernate.jpahibernate.entity.Passport;
import com.jpa.hibernate.jpahibernate.entity.Student;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class StudentRepositoryTests {

	@Autowired
	StudentRepository repository;

	@Autowired
	EntityManager em;

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Test
	@Transactional
	public void retrieveStudentAndPassport_basic() {
		Student student = repository.findById(2001L);
		logger.info("Student->{}",student);
		logger.info("passport->{}",student.getPassport());

	}

	@Test
	@Transactional
	public void retrievePassportAndStudent_basic() {
		Passport passport = em.find(Passport.class,3002L);
		logger.info("passport->{}",passport);
		logger.info("student->{}",passport.getStudent());

	}

	@Test
	@Transactional
	public void retrieveCourseFromStudent_basic() {
		Student student = em.find(Student.class,2001L);
		logger.info("studentData->{}",student);
		logger.info("course->{}",student.getCourse());

	}

}
