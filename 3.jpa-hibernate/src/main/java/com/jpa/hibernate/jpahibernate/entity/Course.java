package com.jpa.hibernate.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Table(name="CourseDetails") - to map with table in db or to create table in this name -> db course_details

//@NamedQuery(name="query_get_all_courses",query = "Select c From Course c") // for only one
//for multiple query use belwo
@NamedQueries(
        value = {
                @NamedQuery(name="query_get_all_courses",query = "Select c From Course c"),
                @NamedQuery(name="query_where_courses",query = "Select c From Course c where id =1001")
        }
)

public class Course {

    @Id
    @GeneratedValue
    private Long id;

   // @Column(name="fullname", nullable = false) //cannot be null - not null
    private String name;

    @UpdateTimestamp //hibernate annotation
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp //hibernate annotation
    private LocalDateTime CreatedDate;

    //default constructor needs to be provided, if there is argument constructor, otherwise no need
    public Course(){

    }

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
