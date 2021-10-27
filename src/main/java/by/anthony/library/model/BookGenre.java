package by.anthony.library.model;

import javax.persistence.*;

@Embeddable
@Table(name = "book_genres")
public enum BookGenre {
    FICTION,
    POETRY,
    SCIENTIFIC,
    BUSINESS,
    SOCIAL,
    IT;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
