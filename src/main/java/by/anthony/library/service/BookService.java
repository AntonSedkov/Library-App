package by.anthony.library.service;

import by.anthony.library.model.Book;

public interface BookService {

    Iterable<Book> findAllBooks();

    Book findBookById(long id);

    Book createBook(Book book);

    Book updateBook(Book book, long id);

    void markAsEbook(long id);

    void deleteBook(long id);

}
