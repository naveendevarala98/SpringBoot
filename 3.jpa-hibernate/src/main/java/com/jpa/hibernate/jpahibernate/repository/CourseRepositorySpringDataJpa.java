package com.jpa.hibernate.jpahibernate.repository;

import com.jpa.hibernate.jpahibernate.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepositorySpringDataJpa extends JpaRepository<Course,Long> {

    @Query("select c from Course c where c.name=:name")
    public Course findByName(String name);
}
