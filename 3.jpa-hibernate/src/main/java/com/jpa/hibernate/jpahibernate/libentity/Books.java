package com.jpa.hibernate.jpahibernate.libentity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Books {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "books_name")
    private String bookName;

    @UpdateTimestamp
    private LocalDateTime createdDateTime;

    @CreationTimestamp
    private LocalDateTime updatedDateTime;

    //foreign key created in books
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Author author;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
