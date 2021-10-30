package by.anthony.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true, exclude = {"password", "usedBooks"})
public class User extends BaseEntity implements Serializable {

    @Column(name = "email", unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Wrong email format")
    private String email;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 64, message = "Name must be at least 3 characters long, but less than 64 characters")
    private String name;

    @NotBlank(message = "Password is required")
    @Size(max = 128)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    //@JsonDeserialize(using = DeserializerJson.PasswordDeserializer.class)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    @JoinTable(name = "books_in_use",
            joinColumns = {@JoinColumn(name = "id_user_fk")},
            inverseJoinColumns = {@JoinColumn(name = "id_book_fk")}
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Book> usedBooks = new HashSet<>();
}
