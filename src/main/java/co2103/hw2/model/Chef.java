package co2103.hw2.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Chef {
    @Id
    private String firstName;
    @ManyToMany(mappedBy = "chefs")
    private List<Restaurant> restaurants;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn
    private List<Orders> orders;

    @OneToOne
    private Orders nextOrder;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(List<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Orders getNextOrder() {
        return nextOrder;
    }

    public void setNextOrder(Orders nextOrder) {
        this.nextOrder = nextOrder;
    }

    @Override
    public String toString() {
        return "Chef{" +
                "firstName='" + firstName + '\'' +
                ", orders=" + orders +
                ", nextOrder=" + nextOrder +
                '}';
    }

}
