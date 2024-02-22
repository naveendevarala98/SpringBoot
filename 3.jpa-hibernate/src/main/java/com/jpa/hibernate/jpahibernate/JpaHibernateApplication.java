package com.jpa.hibernate.jpahibernate;

import com.jpa.hibernate.jpahibernate.entity.Student;
import com.jpa.hibernate.jpahibernate.libentity.Books;
import com.jpa.hibernate.jpahibernate.repository.*;
import com.jpa.hibernate.jpahibernate.entity.Course;
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

	@Autowired
	BookReviewRespository bookReviewRespository;

	@Autowired
	GenreRepository genreRepository;

	@Autowired
	BooksGenreRepository booksGenreRepository;

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
		genreRepository.insertGenre(1, "comedy");
		genreRepository.insertGenre(2, "horror");

		authorRepository.insertAuthor(200, "swan");


		booksRepository.insertBooks(1L,"books",200);
		Thread.sleep(1000);
		booksRepository.updateBooks(1L,"updatebooks");

		booksGenreRepository.insert(1,1);
		booksGenreRepository.insert(1,2);

		authorRepository.fetchAuthor();

		bookReviewRespository.insertReview(1,"good",1);
		bookReviewRespository.insertReview(2,"best",1);

		booksRepository.fetchBooks();
		genreRepository.fetchGenre();

		bookReviewRespository.fetchBooksReview();

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
