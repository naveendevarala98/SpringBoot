package com.jpa.hibernate.jpahibernate.libentity;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue
    private int id;
    private String authorName;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "author")
    private Books books;


//    public Author(int id, String authorName) {
//        this.id = id;
//        this.authorName = authorName;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}
