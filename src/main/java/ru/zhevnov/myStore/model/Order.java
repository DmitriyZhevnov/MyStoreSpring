//package ru.zhevnov.myStore.pojo;
//
//import javax.persistence.*;
//import java.ru.zhevnov.myStore.util.Date;
//import java.ru.zhevnov.myStore.util.HashSet;
//import java.ru.zhevnov.myStore.util.Set;
//
//@Entity
//@Table(name = "order")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @Temporal(TemporalType.DATE)
//    @Column(name = "date")
//    private Date dateOrder;
//    @ManyToOne()
//    @JoinColumn(name = "person_id")
//    private Person person;
//    private String info;
//
////    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
////    private Set<OrderItem> orderItems = new HashSet<>();
//
//    public Order() {
//    }
//
//    public Order(Date dateOrder, Person person, String info) {
//        this.dateOrder = dateOrder;
//        this.person = person;
//        this.info = info;
//    }
//
////    public Set<OrderItem> getOrderItems() {
////        return orderItems;
////    }
////
////    public void setOrderItems(Set<OrderItem> orderItems) {
////        this.orderItems = orderItems;
////    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Date getDateOrder() {
//        return dateOrder;
//    }
//
//    public void setDateOrder(Date dateOrder) {
//        this.dateOrder = dateOrder;
//    }
//
//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public String getInfo() {
//        return info;
//    }
//
//    public void setInfo(String info) {
//        this.info = info;
//    }
//
//    @Override
//    public String toString() {
//        return "Order{" +
//                "id=" + id +
//                ", dateOrder=" + dateOrder +
//                ", person=" + person +
//                ", info='" + info + '\'' +
//           //     ", orderItems=" + orderItems +
//                '}';
//    }
//}
