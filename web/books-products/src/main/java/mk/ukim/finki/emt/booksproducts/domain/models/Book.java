package mk.ukim.finki.emt.booksproducts.domain.models;

import mk.ukim.finki.emt.booksproducts.domain.enumerations.FacultyChoice;
import mk.ukim.finki.emt.booksproducts.domain.valueobjects.UserBuyerId;
import mk.ukim.finki.emt.booksproducts.domain.valueobjects.UserSellerId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.users.domain.models.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book extends AbstractEntity<BookId> {

    /* Оваа класа е Agregate Root на контекстот кој се однесува на самите книги
    * како продукти. Ги содржи сите атрибути кои се прикажани и на самиот ER дијаграм,
    * како и value object-от Money.*/

    private String bookName;
    private int yearPublished;
    private String description;

    @AttributeOverrides({
            @AttributeOverride(name="amount", column = @Column(name="price_amount")),
            @AttributeOverride(name="currency", column = @Column(name="price_currency"))
    })
    private Money price;

    @Enumerated(EnumType.STRING)
    private FacultyChoice whichFaculty;   // за кој Факултет е книгата

    @ManyToMany(cascade= CascadeType.ALL)
    private List<Author> authors;

    @AttributeOverride(name = "id", column = @Column(name = "userSeller_id", nullable = false))
    private UserSellerId userSellerId;

    @AttributeOverride(name = "id", column = @Column(name = "userBuyer_id", nullable = false))
    private UserBuyerId userBuyerId;

    protected Book() {
        super(BookId.randomId(BookId.class));
    }

    public static Book build(String bookName, Money price) {
       Book b= new Book();
        b.price = price;
        b.bookName = bookName;
        return b;
    }

}
