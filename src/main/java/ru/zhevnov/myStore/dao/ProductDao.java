package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.zhevnov.myStore.model.Product;

import java.util.List;

@Repository
public class ProductDao implements IProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> returnAllProducts(){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Query query = session.createQuery("from Product");
            List<Product> list = query.list();
            session.getTransaction().commit();
            return list;
        }
    }

    public Product returnProductById(int id){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }
}
