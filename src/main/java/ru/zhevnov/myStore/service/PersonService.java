package ru.zhevnov.myStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.zhevnov.myStore.dao.IPersonDao;
import ru.zhevnov.myStore.model.Person;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonDao personDao;

    @Override
    public void setPhoneNumberAndAddress(Person person, String phoneNumber, String address) {
        personDao.setPhoneNumberAndAddress(person, phoneNumber, address);
    }

    @Override
    public boolean checkLoginForExist(String login) {
        return personDao.checkLoginForExist(login);
    }

    @Override
    public void updatePerson(Person person) {
        personDao.updatePerson(person);
    }

    @Override
    public void registerNewPerson(String name, int age, String login, String password) {
        personDao.registerNewPerson(name, age, login, password);
    }

    @Override
    public List<Person> returnAllPersons() {
        return personDao.returnAllPersons();
    }

    @Override
    public Person checkAndReturnPersonByLoginAndPassword(String login, String password) {
        return personDao.checkAndReturnPersonByLoginAndPassword(login, password);
    }
}
