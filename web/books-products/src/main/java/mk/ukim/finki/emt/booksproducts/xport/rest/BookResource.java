package mk.ukim.finki.emt.booksproducts.xport.rest;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.booksproducts.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.booksproducts.domain.models.Book;
import mk.ukim.finki.emt.booksproducts.domain.models.BookId;
import mk.ukim.finki.emt.booksproducts.services.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class BookResource {

    private final BookService bookService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping
    public Book getById(BookId id) throws ProductNotFoundException {
        return bookService.findById(id);
    }

}
