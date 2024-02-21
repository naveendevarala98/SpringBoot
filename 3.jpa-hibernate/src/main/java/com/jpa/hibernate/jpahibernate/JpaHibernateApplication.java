package com.jpa.hibernate.jpahibernate;

import com.jpa.hibernate.jpahibernate.entity.Student;
import com.jpa.hibernate.jpahibernate.libentity.Books;
import com.jpa.hibernate.jpahibernate.repository.AuthorRepository;
import com.jpa.hibernate.jpahibernate.repository.BooksRepository;
import com.jpa.hibernate.jpahibernate.repository.CourseRepository;
import com.jpa.hibernate.jpahibernate.entity.Course;
import com.jpa.hibernate.jpahibernate.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class JpaHibernateApplication implements CommandLineRunner {

	@Autowired
	CourseRepository repository;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	BooksRepository booksRepository;

	@Autowired
	AuthorRepository authorRepository;

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

		//studentOperation();

		//oneTOManyCourse();
		//manyToMany();


		//Lib entity
		libentity();
	}

	private void libentity() throws InterruptedException {
		authorRepository.insertAuthor(200, "swan");


		booksRepository.insertBooks(1L,"books",200);
		Thread.sleep(1000);
		booksRepository.updateBooks(1L,"updatebooks");

		booksRepository.fetchBooks();

		authorRepository.fetchAuthor();

	}

	private  void studentOperation(){
		Student student = new Student("mike");
		studentRepository.saveStudentWithPassowrd(student);
	}

	private void oneTOManyCourse(){
		repository.saveReviewCourse();
	}

	private void manyToMany(){
		studentRepository.saveStudentandCourseJoin();
	}
}
