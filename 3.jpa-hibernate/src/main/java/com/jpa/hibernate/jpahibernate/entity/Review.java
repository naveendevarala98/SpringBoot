package com.jpa.hibernate.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Review {

    @Id
    @GeneratedValue
    private Long id;

   @Column(nullable = false)
    private String rating;

    private String description;

    @UpdateTimestamp //hibernate annotation
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp //hibernate annotation
    private LocalDateTime CreatedDate;

    //one review associated with one course
    //eager fetching by default
    @ManyToOne
    private Course course;

    //default constructor needs to be provided, if there is argument constructor, otherwise no need
    public Review(){

    }

    public Review(String rating, String description) {

        this.rating = rating;
        this.description=description;
    }

    public Long getId() {
        return id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
