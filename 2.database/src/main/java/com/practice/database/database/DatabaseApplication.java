package com.practice.database.database;

import com.practice.database.database.entity.Person;
import com.practice.database.database.jpa.PersonJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;


@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner {

	private Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository personJpaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Find user by id 1001->{}",personJpaRepository.findById(1001));
		logger.info("update user  id 1002->{}",personJpaRepository
				.update(new Person(1002,"mm0","delhi",new Date())));

		logger.info("inser user  id 1->{}",personJpaRepository
				.update(new Person(1,"mm0","delhi",new Date())));

		logger.info("inser user->{}",personJpaRepository
				.update(new Person("vvv","mumbai",new Date())));
		personJpaRepository.delete(1002);

		logger.info("All users -> {} ",personJpaRepository.finAll());
	}
}
