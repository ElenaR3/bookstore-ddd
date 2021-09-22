package mk.ukim.finki.emt.booksproducts.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Author extends AbstractEntity<AuthorId> {

    private String authorName;


}
