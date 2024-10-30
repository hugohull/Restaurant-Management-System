package co2103.hw2;

import co2103.hw2.model.Chef;
import co2103.hw2.model.Orders;
import co2103.hw2.model.Restaurant;
import co2103.hw2.repo.ChefRepository;
import co2103.hw2.repo.OrderRepository;
import co2103.hw2.repo.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {

    @Autowired
    private ChefRepository chefRepo;
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private RestaurantRepository restaurantRepo;

    public static List<Restaurant> restaurants;
    public static List<Chef> chefs;
    public static List<Orders> orders;

    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        restaurants = new ArrayList<>();
        chefs = new ArrayList<>();
        orders = new ArrayList<>();

        Orders o = new Orders();
        o.setGuests(2);
        orders.add(o);
        orderRepo.save(o);

        Chef c = new Chef();
        c.setFirstName("Gordan");
        c.setOrders(orders);
        c.setNextOrder(o);

        Restaurant r = new Restaurant();
        r.setName("restaurant");
        r.setHeadChef(c);
        r.setChefs(chefs);

        chefs.add(c);
        c.setRestaurants(restaurants);

        r.setChefs(chefs);
        restaurants.add(r);

        orderRepo.save(o);
        restaurantRepo.save(r);

    }
}
