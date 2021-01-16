package ru.zhevnov.myStore.service;

import ru.zhevnov.myStore.model.BasketItem;
import ru.zhevnov.myStore.model.Person;

import java.util.List;

public interface IBasketService {
    public void addProductToBasket(int personId, int productId, int count);
    public List<BasketItem> returnListOfProductsInBasket(Person person);
    public void updateCount(Person person1, int idProduct, int count);
    public void deleteItem(Person person1, int idProduct);
}
