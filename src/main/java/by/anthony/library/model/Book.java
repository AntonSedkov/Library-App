package by.anthony.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Data
@ToString(callSuper = true, exclude = {"users"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Title is required")
    @Size(min = 3, max = 64, message = "Title must be at least 3 characters long, but less than 64 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 3, max = 64, message = "Title must be at least 3 characters long, but less than 64 characters")
    private String author;

    @Column(name = "year")
    @Pattern(regexp = "-?^[0-2]?([0-9]{1,3})$", message = "Wrong year format, for example '2021'")
    private String createdYear;

    @Column(name = "genre")
    @Enumerated(value = EnumType.STRING)
    private BookGenre genre;

    @Column(name = "is_ebook")
    private boolean isEbook;

    @ManyToMany(mappedBy = "usedBooks", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<User> users = new HashSet<>();
}
