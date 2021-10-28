package by.anthony.library.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String author;

    @Column(name = "year")
    private int publishedYear;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private BookGenre genre;

    @Column(name = "is_ebook")
    private boolean isEbook;

}
