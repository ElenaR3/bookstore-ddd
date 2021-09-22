package mk.ukim.finki.emt.ordermanagement.domain.models;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Book;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.BookId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.UserBuyerId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

    @Column(name="order_currency")
    @Enumerated(EnumType.STRING)
    private Currency currency;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList = new HashSet<>();

    @AttributeOverride(name = "id", column = @Column(name = "userbuyer_id", nullable = false))
    private UserBuyerId userBuyerId;

    public Money total() {
        return orderItemList.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0), Money::add);
    }

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }
    public Order(Instant now, mk.ukim.finki.emt.sharedkernel.domain.financial.Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }

    public OrderItem addItem(@NonNull Book book) {
        Objects.requireNonNull(book,"product must not be null");
        var item  = new OrderItem(book.getId(),book.getPrice());
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId,"Order Item must not be null");
        orderItemList.removeIf(v->v.getId().equals(orderItemId));
    }

}
