package ru.zhevnov.myStore.dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ru.zhevnov.myStore.model.Basket;
import ru.zhevnov.myStore.model.Person;
import ru.zhevnov.myStore.model.Role;

import java.util.List;

public interface IPersonDao {
    public void setPhoneNumberAndAddress(Person person, String phoneNumber, String address);
    public boolean checkLoginForExist(String login);
    public void updatePerson(Person person);
    public void registerNewPerson(String name, int age, String login, String password);
    public List<Person> returnAllPersons();
    public Person checkAndReturnPersonByLoginAndPassword(String login, String password);
}
