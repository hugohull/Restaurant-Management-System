package co2103.hw2.repo;

import co2103.hw2.model.Chef;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChefRepository extends CrudRepository<Chef,String> {
    public List<Chef> findByFirstName(String firstName);
}
