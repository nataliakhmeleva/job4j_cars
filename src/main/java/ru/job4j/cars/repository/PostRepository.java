package ru.job4j.cars.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.job4j.cars.model.Post;

import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class PostRepository {
    private final CrudRepository crudRepository;


    public List<Post> findByLastDay() {
        return crudRepository.query("FROM Post WHERE created >= CURRENT_DATE - INTERVAL '1 day'", Post.class);
    }

    public List<Post> findByPhoto() {
        return crudRepository.query("FROM Post WHERE file_id IS NOT NULL", Post.class);
    }

    public List<Post> findByModelOfCar(String name) {
        return crudRepository.query("FROM Post car_id in (SELECT id FROM Car WHERE name= :fName)",
                Post.class, Map.of("fName", name));
    }
}
