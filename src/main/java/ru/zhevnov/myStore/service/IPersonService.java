package ru.zhevnov.myStore.service;

import ru.zhevnov.myStore.model.Person;

import java.util.List;

public interface IPersonService {
    public void setPhoneNumberAndAddress(Person person, String phoneNumber, String address);
    public boolean checkLoginForExist(String login);
    public void updatePerson(Person person);
    public void registerNewPerson(String name, int age, String login, String password);
    public List<Person> returnAllPersons();
    public Person checkAndReturnPersonByLoginAndPassword(String login, String password);
}
