package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.zhevnov.myStore.model.Basket;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.model.Role;

import java.util.List;

@Repository
public class PersonDao implements IPersonDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setPhoneNumberAndAddress(Person person, String phoneNumber, String address){
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Person p =  session.get(Person.class, person.getId());
            p.setPhoneNumber(phoneNumber);
            p.setAddress(address);
            session.update(p);
            session.getTransaction().commit();
        }
    }

    public boolean checkLoginForExist(String login) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select id from Person where login = :login");
            query.setParameter("login", login);
            List list = query.list();
            session.getTransaction().commit();
            if (list.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
    }
    public void updatePerson(Person person){
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        }
    }

    public void registerNewPerson(String name, int age, String login, String password) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            RoleDao roleDao = new RoleDao();
            Role roleForNewUser = roleDao.returnUserValue();
            Basket basket = new Basket();
            Person person = new Person(name, age, login, password, roleForNewUser, "", "", basket);
            session.save(person);
            basket.setPerson(person);
            session.save(basket);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    public List<Person> returnAllPersons() {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Person");
            List<Person> listPerson = query.list();
            session.getTransaction().commit();
            return listPerson;
        }
    }

    public Person checkAndReturnPersonByLoginAndPassword(String login, String password) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("select id from Person where login = :login and password = :password");
            query.setParameter("login", login);
            query.setParameter("password", password);
            List list = query.list();
            session.getTransaction().commit();
            if (list.isEmpty()) {
                return null;
            } else {
                return session.get(Person.class, (Integer.parseInt(list.get(0).toString())));
            }
        }
    }
}
