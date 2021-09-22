package mk.ukim.finki.emt.booksproducts.services.forms;

import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class BookForm {

    private String bookName;
    private Money price;
}
