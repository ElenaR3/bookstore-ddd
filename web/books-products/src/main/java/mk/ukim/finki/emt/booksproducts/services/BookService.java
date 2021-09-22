package mk.ukim.finki.emt.booksproducts.services;

import mk.ukim.finki.emt.booksproducts.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.booksproducts.domain.models.Book;
import mk.ukim.finki.emt.booksproducts.domain.models.BookId;
import mk.ukim.finki.emt.booksproducts.services.forms.BookForm;

import java.util.List;

public interface BookService {

    Book findById(BookId id) throws ProductNotFoundException;
    Book createProduct(BookForm form);
    Book orderItemCreated(BookId productId) throws ProductNotFoundException;
    Book orderItemRemoved(BookId productId) throws ProductNotFoundException;
    List<Book> getAll();

}
