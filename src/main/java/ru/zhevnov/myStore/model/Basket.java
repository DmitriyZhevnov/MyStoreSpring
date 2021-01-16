package ru.zhevnov.myStore.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "id_person")
    private Person person;

    @OneToMany (mappedBy="basket", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BasketItem> basketItems;

    public Basket() {
    }

    public Basket(Person person, List<BasketItem> basketItems) {
        this.person = person;
        this.basketItems = basketItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<BasketItem> getBasketItems() {
        return basketItems;
    }

    public void setBasketItems(List<BasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
               // ", person=" + person +
               // ", basketItems=" + basketItems +
                '}';
    }
}
