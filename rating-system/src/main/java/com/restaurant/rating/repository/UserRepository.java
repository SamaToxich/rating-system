package repository;  // Важно: пакет должен совпадать

import com.restaurant.rating.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>();
    private Long currentId = 1L;

    public User save(User user) {
        user.setId(currentId++);
        users.add(user);
        return user;
    }

    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    public void delete(User user) {
        users.removeIf(u -> u.getId().equals(user.getId()));
    }
}