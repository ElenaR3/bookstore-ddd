package mk.ukim.finki.emt.booksproducts.xport.events;

import mk.ukim.finki.emt.booksproducts.domain.exceptions.ProductNotFoundException;
import mk.ukim.finki.emt.booksproducts.domain.models.BookId;
import mk.ukim.finki.emt.booksproducts.services.BookService;
import mk.ukim.finki.emt.sharedkernel.domain.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.events.orders.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;


public class BookEventListener { // Listener кој чека да се случи одреден настан, во овој случај креирање/бришење на ставка во нарачка, имплементиран со помош на Кафка message broker

    private final BookService bookService;

    public BookEventListener(BookService bookService) {
        this.bookService = bookService;
    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage,OrderItemCreated.class);
            bookService.orderItemCreated(BookId.of(event.getProductId()));
        } catch (Exception | ProductNotFoundException e){

        }

    }

    @KafkaListener(topics= TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage,OrderItemRemoved.class);
            bookService.orderItemRemoved(BookId.of(event.getProductId()));
        } catch (Exception | ProductNotFoundException e){

        }

    }

}
