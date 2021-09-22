package mk.ukim.finki.emt.ordermanagement.domain.models;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.BookId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    private Money itemPrice;

    @AttributeOverride(name = "id", column = @Column(name = "book_id", nullable = false))
    private BookId bookId;


    public Money subtotal() {
        return itemPrice;
    }

    private OrderItem() {
        super(DomainObjectId.randomId(OrderItemId.class));
    }

    public OrderItem(@NonNull BookId bookId, @NonNull Money itemPrice) {
        super(DomainObjectId.randomId(OrderItemId.class));
        this.bookId = bookId;
        this.itemPrice = itemPrice;
    }

}
