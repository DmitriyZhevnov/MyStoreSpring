package ru.zhevnov.myStore.service;

import ru.zhevnov.myStore.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> returnAllProducts();
    public Product returnProductById(int id);
}
