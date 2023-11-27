package com.jpa.hibernate.jpahibernate.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

   @Column(nullable = false)
    private String name;

    @UpdateTimestamp //hibernate annotation
    private LocalDateTime lastUpdatedDate;

    @CreationTimestamp //hibernate annotation
    private LocalDateTime CreatedDate;

    /*normmally it fetches student and passport(one query) details because bydefault one to one mapping is eager
    fetcing,
     if fetch type changed to lazy, then only student details fetched from db and again whenever
     try access passport separate query will be exceuted to fetch passport details
    */

    //this is ownning side which means, foreign key passport is created in student table
    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    //default constructor needs to be provided, if there is argument constructor, otherwise no need
    public Student(){

    }

    public Student(String name) {
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


    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", student name='" + name + '\'' +
                '}';
    }
}
