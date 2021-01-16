package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.zhevnov.myStore.model.BasketItem;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BasketDao implements IBasketDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void addProductToBasket(int personId, int productId, int count) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, personId);
            if (person.getBasket().getBasketItems().stream().anyMatch(basketItem -> basketItem.getProducts().get(0).getId() == productId)) {
                BasketItem basketItem = person.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getId() == productId).collect(Collectors.toList()).get(0);
                int firstCountInBasketItem = basketItem.getQuantity();
                basketItem.setQuantity(firstCountInBasketItem + count);
                session.update(basketItem);
                session.getTransaction().commit();
            } else {
                Product product = session.get(Product.class, productId);
                List<Product> tt = new ArrayList<>();
                tt.add(product);
                BasketItem basketItem = new BasketItem(person.getBasket(), count, tt);
                session.save(basketItem);
                product.getBasketItems().add(basketItem);
                session.update(product);
                person.getBasket().getBasketItems().add(basketItem);
                session.update(person);
                session.getTransaction().commit();
            }
        }
    }

    public void updateCount(Person person1, int idProduct, int count) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, person1.getId());
            BasketItem basketItem = person.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getId() == idProduct).collect(Collectors.toList()).get(0);
            basketItem.setQuantity(count);
            session.update(basketItem);
            session.getTransaction().commit();
        }
    }

    public void deleteItem(Person person1, int idProduct) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person person = session.get(Person.class, person1.getId());
            BasketItem basketItem = person.getBasket().getBasketItems().stream().filter(s -> s.getProducts().get(0).getId() == idProduct).collect(Collectors.toList()).get(0);
            Product product = session.get(Product.class, idProduct);
            BasketItem productItem = product.getBasketItems().stream().filter(s -> s.getProducts().get(0).getId() == idProduct).collect(Collectors.toList()).get(0);
            session.delete(basketItem);
            session.delete(productItem);
            session.getTransaction().commit();
        }
    }

    public List<BasketItem> returnListOfProductsInBasket(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Person p = session.get(Person.class, person.getId());
            List<Product> list = new ArrayList<>();
            p.getBasket().getBasketItems().stream().forEach(basketItem -> list.add(basketItem.getProducts().get(0)));
            session.getTransaction().commit();
            return p.getBasket().getBasketItems();
        }
    }
}
