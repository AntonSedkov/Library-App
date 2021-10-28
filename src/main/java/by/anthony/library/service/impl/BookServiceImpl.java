package by.anthony.library.service.impl;

import by.anthony.library.model.Book;
import by.anthony.library.repository.BookRepository;
import by.anthony.library.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, long id) {
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public void markAsEbook(long id) {
        bookRepository.markAsEbook(id);
    }

    @Override
    public void deleteBook(long id) {
        bookRepository.deleteById(id);
    }

}
