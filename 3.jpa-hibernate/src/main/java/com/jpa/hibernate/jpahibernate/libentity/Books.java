package com.jpa.hibernate.jpahibernate.libentity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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


    @OneToMany(mappedBy = "books")
    private List<BookReview> bookReview;

    @ManyToMany
    @JoinTable(name="BOOK_GENRE",
    joinColumns = @JoinColumn(name="BOOKS_ID"),
    inverseJoinColumns = @JoinColumn(name="GENRE_ID"))
    private List<Genre> genre;

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

    @JsonManagedReference  // - to stop infinite recursion refere again not working
    public List<BookReview> getBookReview() {
        return bookReview;
    }

    public void setBookReview(List<BookReview> bookReview) {
        this.bookReview = bookReview;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }
}
