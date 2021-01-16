package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.zhevnov.myStore.model.Product;

import java.util.List;

public interface IProductDao {
    public List<Product> returnAllProducts();
    public Product returnProductById(int id);
}
