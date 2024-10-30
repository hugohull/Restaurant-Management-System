package co2103.hw2.repo;

import co2103.hw2.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Integer> {
    public List<Orders> findByGuests(String guests);
}
