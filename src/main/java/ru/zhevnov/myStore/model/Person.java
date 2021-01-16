package ru.zhevnov.myStore.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Size(max = 20, min = 3, message = "{person.name.invalid}")
    @NotEmpty(message = "{person.name.empty}")
    private String name;
   // @NotEmpty(message = "{person.age.empty}")
    @Min(value = 0, message = "{person.age.invalid}")
    private int age;
    @Column(name = "login", unique = true)
    @NotEmpty(message = "{person.name.empty}")
    @Size(max = 10, min = 4, message = "{person.login.invalid}")
    private String login;
    @Size(max = 10, min = 4, message = "{person.password.invalid}")
    @NotEmpty(message = "{person.password.empty}")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Basket basket;

    public Person() {
    }

    public Person(String name, int age, String login, String password, Role role, String phoneNumber, String address, Basket basket) {
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.basket = basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", basket=" + basket +
                '}';
    }
}
