package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Driver;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class DriverRepository {
    private final CrudRepository crudRepository;

    public List<Driver> findAll() {
        return crudRepository.query("from Driver order by id", Driver.class);
    }

    public Optional<Driver> findById(int userId) {
        return crudRepository.optional(
                "from Driver where id = :fId", Driver.class,
                Map.of("fId", userId)
        );
    }
}
