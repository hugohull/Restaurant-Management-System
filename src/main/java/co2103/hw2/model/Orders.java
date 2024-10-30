package co2103.hw2.model;

import javax.persistence.*;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private int id;
    private int guests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", guests=" + guests +
                '}';
    }

}
