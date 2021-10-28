package by.anthony.library.repository;

import by.anthony.library.model.Book;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Modifying
    @Query("UPDATE Book b SET b.isEbook=true WHERE b.id= :id")
    void markAsEbook(@Param("id") long id);

}
