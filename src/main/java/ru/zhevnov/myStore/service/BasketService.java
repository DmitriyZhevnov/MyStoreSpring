package ru.zhevnov.myStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zhevnov.myStore.dao.IBasketDao;
import ru.zhevnov.myStore.model.BasketItem;
import ru.zhevnov.myStore.model.Person;

import java.util.List;

@Service
public class BasketService implements IBasketService{

    @Autowired
    private IBasketDao basketDao;

    @Override
    public void addProductToBasket(int personId, int productId, int count) {
        basketDao.addProductToBasket(personId, productId, count);
    }

    @Override
    public List<BasketItem> returnListOfProductsInBasket(Person person) {
        return basketDao.returnListOfProductsInBasket(person);
    }

    @Override
    public void updateCount(Person person1, int idProduct, int count) {
        basketDao.updateCount(person1, idProduct, count);
    }

    @Override
    public void deleteItem(Person person1, int idProduct) {
        basketDao.deleteItem(person1, idProduct);
    }
}
