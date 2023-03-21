package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class PostRepository {
    private final CrudRepository crudRepository;


    public List<Post> findByLastDay() {
        var today = LocalDateTime.now();
        var yesterday = today.minusDays(1);
        return crudRepository.query("FROM Post WHERE created between :fYesterday and :fToday", Post.class,
                Map.of("fYesterday", yesterday, "fToday", today));
    }

    public List<Post> findByPhoto() {
        return crudRepository.query("FROM Post WHERE file_id IS NOT NULL", Post.class);
    }

    public List<Post> findByModelOfCar(String name) {
        return crudRepository.query("FROM Post car_id in (SELECT id FROM Car WHERE name= :fName)",
                Post.class, Map.of("fName", name));
    }
}
