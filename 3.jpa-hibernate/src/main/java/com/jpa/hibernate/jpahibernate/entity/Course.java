package com.jpa.hibernate.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    //one course can have many reviews
    //by default lazy
    @OneToMany(mappedBy = "course")
    private List<Review> reviewList = new ArrayList<>();

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

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void addReview(Review review) {
        this.reviewList.add(review);
    }

    public void removeReview(Review review){
        this.reviewList.remove(review);
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
