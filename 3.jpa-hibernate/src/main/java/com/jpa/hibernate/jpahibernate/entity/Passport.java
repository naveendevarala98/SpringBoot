package com.jpa.hibernate.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;

   @Column(nullable = false)
    private String number;

    @UpdateTimestamp //hibernate annotation
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp //hibernate annotation
    private LocalDateTime CreatedDate;

    //maaped by tells key is created in student not in passport, in table student id is not created in passport
    // it is just for fetching data in the code
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    //default constructor needs to be provided, if there is argument constructor, otherwise no need
    public Passport(){

    }

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
