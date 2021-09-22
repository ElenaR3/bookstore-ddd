package mk.ukim.finki.emt.booksproducts.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.booksproducts.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.booksproducts.domain.models.Book;
import mk.ukim.finki.emt.booksproducts.domain.models.BookId;
import mk.ukim.finki.emt.booksproducts.domain.repository.BookRepository;
import mk.ukim.finki.emt.booksproducts.services.BookService;
import mk.ukim.finki.emt.booksproducts.services.forms.BookForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book findById(BookId id) throws ProductNotFoundException {
        return bookRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public Book createProduct(BookForm form) {
        Book p = Book.build(form.getBookName(),form.getPrice());
        bookRepository.save(p);
        return p;
    }

    @Override
    public Book orderItemCreated(BookId productId) throws ProductNotFoundException {
        Book p = bookRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        bookRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public Book orderItemRemoved(BookId productId) throws ProductNotFoundException {
        Book p = bookRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
        bookRepository.saveAndFlush(p);
        return p;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

}
