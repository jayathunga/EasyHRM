package com.gen.test.testBack.testDomain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String orderId;

    private double cost;

    //Entity relationship

//    @ManyToOne
//    @JoinColumn(name = "id")
//    private Test test;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "order_details",
//            joinColumns = @JoinColumn(name="orderId",referencedColumnName = "orderId"),
//            inverseJoinColumns = @JoinColumn(name="id",referencedColumnName = "id")
//    )
//    private Set<Item> itemSet=new HashSet<>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
