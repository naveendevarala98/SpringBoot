package com.jpa.hibernate.jpahibernate.repository;


import com.jpa.hibernate.jpahibernate.entity.Course;
import com.jpa.hibernate.jpahibernate.entity.Passport;
import com.jpa.hibernate.jpahibernate.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {

    @Autowired
    EntityManager em;

    public Student findById(Long id){
        return em.find(Student.class, id);
    }

    public void deleteById(Long id){
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student){
        if(student.getId() == null){
            //inser data
            em.persist(student);
        }else{
            //update data
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassowrd(Student student){
        Passport passport = new Passport("Z123");
        em.persist(passport); // first persist password , then only it can map with student

        student.setPassport(passport);
        em.persist(student);

    }

    //many to many
    public void saveStudentandCourseJoin(){
        Student student = new Student("jack");
        Course course = new Course("microservice");
        em.persist(course);
        student.addCourse(course);
        em.persist(student);


    }


}
