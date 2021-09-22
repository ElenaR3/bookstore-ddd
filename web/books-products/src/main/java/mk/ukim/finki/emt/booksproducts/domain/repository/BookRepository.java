package mk.ukim.finki.emt.booksproducts.domain.repository;

import mk.ukim.finki.emt.booksproducts.domain.models.Book;
import mk.ukim.finki.emt.booksproducts.domain.models.BookId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, BookId> {
}
