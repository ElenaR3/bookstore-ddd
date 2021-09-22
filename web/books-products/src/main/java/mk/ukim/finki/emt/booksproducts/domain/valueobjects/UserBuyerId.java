package mk.ukim.finki.emt.booksproducts.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class UserBuyerId extends DomainObjectId {
}

/* Со оглед на тоа дека User претставува посебен модул,
*  а секоја книга има свој продавач koj e корисник сам по себе,
* како и купувач кој е корисник сам по себе потребно е креирање на UserBuyerId како value object.
* */