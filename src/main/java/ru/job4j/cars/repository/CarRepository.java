package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Car;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class CarRepository {
    private final CrudRepository crudRepository;

    public List<Car> findAll() {
        return crudRepository.query("from Car order by id", Car.class);
    }

    public Optional<Car> findById(int userId) {
        return crudRepository.optional(
                "from Car where id = :fId", Car.class,
                Map.of("fId", userId)
        );
    }
}
