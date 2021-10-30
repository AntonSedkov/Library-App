package by.anthony.library.controller;

import by.anthony.library.model.Book;
import by.anthony.library.model.BookGenre;
import by.anthony.library.repository.BookRepository;
import by.anthony.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute
    public void addBookGenres(Model model) {
        model.addAttribute("genres", BookGenre.values());
    }

    @GetMapping
    public String showAllBooks(Model model) {
        Iterable<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping("/add")
    public String processBook(@Valid @ModelAttribute("book") Book book, Errors errors) {
        if (errors.hasErrors()) {
            return "add_book";
        }
        bookService.createBook(book);
        log.info("Save book: " + book.getTitle());
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable long id,
                           Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "edit_book";
    }

    @PostMapping("/edit/{id}")
    public String updateBook(@PathVariable long id,
                             @RequestBody Book book,
                             Model model) {
        bookService.updateBook(book, id);
        model.addAttribute("book", book);
        return "redirect:/edit/" + id;
    }

    @DeleteMapping("/edit/{id}")
    public String deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
        return "/books";
    }

}
