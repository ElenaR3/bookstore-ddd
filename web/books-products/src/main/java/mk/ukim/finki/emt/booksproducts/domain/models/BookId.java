package mk.ukim.finki.emt.booksproducts.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import org.springframework.lang.NonNull;

public class BookId extends DomainObjectId {

    private BookId() {
        super(BookId.randomId(BookId.class).getId());
    }

    public BookId(@NonNull String uuid) {
        super(uuid);
    }

    public static BookId of(String uuid) {
        BookId p = new BookId(uuid);
        return p;
    }


}
