package co2103.hw2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Chef> chefs;

    @ManyToOne
    private Chef headChef;

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

    public List<Chef> getChefs() {
        return chefs;
    }

    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }

    public Chef getHeadChef() {
        return headChef;
    }

    public void setHeadChef(Chef headChef) {
        this.headChef = headChef;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", chefs=" + chefs +
                ", headChef=" + headChef +
                '}';
    }

}
