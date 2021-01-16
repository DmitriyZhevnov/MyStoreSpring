//package ru.zhevnov.myStore.pojo;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "order_item")
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//    private int quantity;
//
//    public OrderItem() {
//    }
//
//    public OrderItem(Order order, Product product, int quantity) {
//        this.order = order;
//        this.product = product;
//        this.quantity = quantity;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }
//
//    @Override
//    public String toString() {
//        return "OrderItem{" +
//                "id=" + id +
//                ", order=" + order +
//                ", product=" + product +
//                ", quantity=" + quantity +
//                '}';
//    }
//}
