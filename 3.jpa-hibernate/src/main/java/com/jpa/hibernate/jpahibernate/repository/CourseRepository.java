package com.jpa.hibernate.jpahibernate.repository;


import com.jpa.hibernate.jpahibernate.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class CourseRepository {

    @Autowired
    EntityManager em;

    public Course findById(Long id){
        return em.find(Course.class, id);
    }

    public void deleteById(Long id){
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course){
        if(course.getId() == null){
            //inser data
            em.persist(course);
        }else{
            //update data
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        Course course = new Course("web service");
        em.persist(course);
        course.setName("web service update"); // this value will be updated eventhough , there is no explicit merge, because of em
    }

    public void playWithEntityManager2(){
        Course course = new Course("web service");
        em.persist(course);

        Course course2 = new Course("Angular");
        em.persist(course2);
        em.flush();// to send data to db till now
        em.detach(course);//slected one - to detach or not consider changes after this for particular object
        em.clear();//all - to detach all things above instead og each one like detach

        //do not update
        course.setName("web service update");
        em.flush();
        course2.setName("angular updated");
        em.flush();

    }

    public void playWithEntityManager3(){
        Course course = new Course("web service");
        em.persist(course); // data in entity manager

        Course course2 = new Course("Angular");
        em.persist(course2);
        em.flush();//here data sends /stores in db - uptill then data only in em


        //do not update
        course.setName("web service update");
        course2.setName("angular updated");

        em.refresh(course);// course data will be fetched from db and assign

        em.flush();// course will not be updated because of no changes(refresh), but course2 will be updated

        //em.flush -> to store data in db
        //em.clear/detach -> to clear the em not holds previous
        //em.refresh -> fetches data from the db

    }
}
