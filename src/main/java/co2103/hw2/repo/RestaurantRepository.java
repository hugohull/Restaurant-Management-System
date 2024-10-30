package co2103.hw2.repo;

import co2103.hw2.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
public List<Restaurant> findByName(String name);
public List<Restaurant> findByHeadChefFirstName(String firstName);
}
