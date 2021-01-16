package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import ru.zhevnov.myStore.model.BasketItem;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface IBasketDao {
    public void addProductToBasket(int personId, int productId, int count);
    public List<BasketItem> returnListOfProductsInBasket(Person person);
    public void updateCount(Person person1, int idProduct, int count);
    public void deleteItem(Person person1, int idProduct);
}
