package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Getter
public class Book implements ValueObject {

    private final BookId id;

    private final String bookName;

    private final Money price;

    private Book() {
        this.id= BookId.randomId(BookId.class);
        this.bookName= "";
        this.price = Money.valueOf(Currency.MKD,0);
    }

    @JsonCreator
    public Book(BookId id, String bookName, Money price) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
    }
}
