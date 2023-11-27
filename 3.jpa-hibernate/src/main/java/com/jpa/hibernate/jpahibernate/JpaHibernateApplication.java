package com.jpa.hibernate.jpahibernate;

import com.jpa.hibernate.jpahibernate.entity.Student;
import com.jpa.hibernate.jpahibernate.repository.CourseRepository;
import com.jpa.hibernate.jpahibernate.entity.Course;
import com.jpa.hibernate.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repository;

	@Autowired
	StudentRepository studentRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	Course course=repository.findById(1001L);
	//	logger.info("Course details 1001 ->{}",course);
		//repository.deleteById(1001L);
		//logger.info("delete by id 1001 ->{}",);

	//	repository.save(new Course("new course"));


	//	repository.playWithEntityManager();
	//	repository.playWithEntityManager2();
	//	repository.playWithEntityManager3();

	//	repository.playWithEntityManager_datetime();

		studentOperation();
	}

	private  void studentOperation(){
		Student student = new Student("mike");
		studentRepository.saveStudentWithPassowrd(student);
	}
}
